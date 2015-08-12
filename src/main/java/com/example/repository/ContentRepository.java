package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Content;
import com.example.domain.Customer;
import com.example.domain.MstItem;

@Repository
@Transactional
public interface ContentRepository extends JpaRepository<Content, Long> {
  List<Content> findByContentName(String contentName);
  
  Content findByContentId(Long contentId);

  Page<Content> findAllOrderByContentName(Pageable pageable);

  @Query("SELECT a FROM Content a ORDER BY  a.contentId, a.contentName")
  Page<Content> findAllOrderByContentId(Pageable pageable);

  List<Content> findAll();
  
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
