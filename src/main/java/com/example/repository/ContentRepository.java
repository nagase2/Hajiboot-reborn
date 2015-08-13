package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Content;
import com.example.web.ContentForm;

@Repository
@Transactional
public interface ContentRepository extends JpaRepository<Content, Long> {
  List<Content> findByContentName(String contentName);
  
  Content findByContentId(Long contentId);

  Page<Content> findAllOrderByContentName(Pageable pageable);

  @Query("SELECT a FROM Content a ORDER BY  a.contentId, a.contentName")
  Page<Content> findAllOrderByContentId(Pageable pageable);

  List<Content> findAll();
  
  /**
   * 検索を行って結果をPagableで返す(動作確認中）
   * データはEntityグラフを使って取得。検索条件はSQLで指定
   * @return
   */
  @EntityGraph(value = "content.search", type = EntityGraphType.LOAD)
  @Query("select c from Content c where " //c.deleteFlag = false and "//これが0になる…なぜ？
      + "  (c.contentName like :contentName or :contentName is null ) "
      + " and (c.count > :count or :count is null ) "
    //  + "and (c.comment like :itemId or :itemId is null ) "
      + "and (c.comment like :comment or :comment is null ) ")
  //@Query("select c from Content c")
  Page<Content> findAllWithEntityGraph(@Param("contentName")String contentName, @Param("count")int count,
      @Param("comment")String comment, /*@Param("itemId") int itemId,*/ Pageable pageable);
//  @Query(value = "select o from OrderSlip o left join fetch o.receiver r "
//      + " where o.deleted = false "
//      + " and ( o.orderNumber like :orderNumber or :orderNumber is null ) "
//      + " and ( r.name like :receiverCustomerName or :receiverCustomerName is null ) "
//      + " and ( o.group.id.unitCode = :groupCode or :groupCode is null ) "
//      + " and ( o.directShipment = :directShipment or :directShipment is null ) "
  
  
  @Query("select c from Content c ORDER BY c.contentName")
  List<Content> findAllByNone();

  Page<Content> findAll(Pageable pageable);
  
  /**
   * ContentNameで検索してContentIdの昇順で並べ替え
   * Query methd利用
   * @param contentName
   * @param pageable
   * @return
   */
  Page<Content> findByContentNameOrderByContentIdAsc(String contentName,Pageable pageable);
  
  /**
   * Like検索
   * @param contentName
   * @param pageable
   * @return
   */
  @Query("select c from Content c where c.contentName like CONCAT('%',CONCAT(:contentName, '%'))")
  Page<Content> findContents(@Param("contentName")String contentName,Pageable pageable);
  
  //Page<Content> findByItemName_Mstitem(MstItem mstItem,Pageable pageable);

 // List<Content> findAllOrderByContentId();
}
