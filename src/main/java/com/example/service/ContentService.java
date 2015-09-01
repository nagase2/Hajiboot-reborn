package com.example.service;

import static com.example.service.ContentSpecifications.*;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Content;
import com.example.repository.ContentRepository;
import com.example.web.ContentForm;

/**
 * カスタマのサービスクラス
 * 
 * @author nagase
 *　TODO:Entityグラフを追加してみる。
 */
@Service
// サービスクラスであることを示す。Componentと意味は変わらない
@Transactional
@Slf4j
public class ContentService {
  @Autowired
  ContentRepository contentRepository;

  /*
   * すべてを返す
   */
  public List<Content> findAll() {
	  
    return contentRepository.findAll();
  }
  
  /**
   * １秒以内に処理が返ってこなかったらタイムアウト
   */
  @Transactional(timeout=1)
  public List<Content> findAllTransactional(){
	  return contentRepository.findAll();
  }
  
  public Page<Content> findAllWithEntityGraph(String contentName, int count, String comment, int itemId, Pageable pageable){
    return contentRepository.findAllWithEntityGraph(contentName, count, comment, /*itemId,*/ pageable);
  }
  
  public Page<Content> findAll(Pageable pageable) {
    return contentRepository.findAll(pageable);
  }

  public List<Content> findByContentName(String contentName) {
    return contentRepository.findByContentName(contentName);
  }

  public Page<Content> findAllOrderByContentName(Pageable pageable){
      return contentRepository.findAllOrderByContentName(pageable);
  }

  public Page<Content> findAllOrderByContentId(Pageable pageable){
     return contentRepository.findAllOrderByContentId(pageable);
  }
  
  public Content findByContentId(Long contentId){
    return contentRepository.findByContentId(contentId);
  }
  
  public Page<Content> findByContentNameOrderByContentId(String contentName,Pageable pageable){
  //  return contentRepository.findByContentNameOrderByContentIdAsc(contentName,pageable);
    return contentRepository.findContents(contentName,pageable);
  }
 public Content save(Content content){
    return contentRepository.save(content);
 }

 public Content update(Content content){
	 log.info("ContentServiceが呼ばれました。");
   //TODO:楽観的ロックのチェックは自分でやるのか？今のままだと、楽観的ロックが意図したとおりに動かない。
   //->Version情報を渡すことで解決した。？
   
   return contentRepository.save(content);
}
 /**
  * トランザクションのテストを行うメソッド。ステップは下記の通り。
  * データを５件更新する
  * ①	サービス内でコンテンツを５つ更新する処理を作る。
  * ②	更新を行い、３番目でエラーを発生。
  * ③	DBが更新されたかどうかを確認する。（更新されていなければTransaction成功）
  * ->今のところ、３件更新されてしまっているが、、、
 * @throws Throwable 
  */
 @javax.transaction.Transactional
 public int update5Data() throws Throwable{
	 log.info("リポジトリからデータを取得（特殊ならべかえを実施）");
	 //５回繰り返す
	  //データを更新
	  //３回めだったら
	 	//Exceptionを発生
	 
	 List<Content> contents = contentRepository.findAllByNone();
	 
	 for(int i =0; i<5; i++){
		log.info(i+"回目です");
		Content con = contents.get(i);
		con.setContentName("D_Updated"+i);
		contentRepository.save(con);
		
		if(i==3){
			throw new Throwable();
		}
	 }
	 return 0;
 }
 
 /**
  * EntityGraphを使って検索
  * @param pageable
  * @return
  */
 public Page<Content> simpleFindAllWithEntityGraph(ContentForm contentForm,Pageable pageable) {
   log.info("ここで動的検索のテスト");
   //return contentRepository.simpleFindAllWithEntityGraph(pageable);
   
   return contentRepository.findAll(Specifications.where(
       //TODO:ここで固定条件（deleteflag=false)を渡したい
       contentNamecontains(contentForm.getContentName()))
       .and(commentContains(contentForm.getComment()))
       .and(countContains(contentForm.getCount()))
       //これで検索するとエラーとなる。
       .and(mstItemContain(contentForm.getMstItem()))
           
        , pageable);
 }
 /**
  * 全条件での検索サービス
  * 検索フォームに入力された値のみを検索し、結果を返す。入力値が空白だった場合は検索条件から除外する。
  * 検索は全条件入力可能（可変）
  * @param contentName
  * @param pageable
  * @return 検索結果
  */



}
