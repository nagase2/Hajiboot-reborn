package com.example.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Content;
import com.example.domain.MstItem;
import com.example.repository.ContentRepository;

/**
 * カスタマのサービスクラス
 * 
 * @author nagase
 *
 */
@Service
// サービスクラスであることを示す。Componentと意味は変わらない
@Transactional
public class ContentService {
  @Autowired
  ContentRepository contentRepository;

  /*
   * すべてを返す
   */
  public List<Content> findAll() {
    return contentRepository.findAll();
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
// public Content update(Content content){
//   //更新をするために一度登録されているデータを取得する。
//   Content updatedContent = contentRepository.getOne(content.getContentId());
//   
//   //まとめてコピー
//   //BeanUtils.copyProperties(content, updatedContent);
//
//   updatedContent.setContentName(content.getContentName());
//   updatedContent.setCount(content.getCount());
//   updatedContent.setComment(content.getComment());
//   //TODO:まとめてコピーしたら動かないか？
//   //TODO:楽観的ロックのチェックは自分でやるのか？今のままだと、楽観的ロックが意図したとおりに動かない。
//   
//   return contentRepository.save(updatedContent);
//}
 public Content update(Content content){
   //更新をするために一度登録されているデータを取得する。
   //Content updatedContent = contentRepository.getOne(content.getContentId());
   Content content_ = content;
   //まとめてコピー
   //BeanUtils.copyProperties(content, updatedContent);
  //content.setMstItem(new MstItem(2));
   //updatedContent.setContentN ame(content.getContentName());
  // updatedContent.setCount(content.getCount());
  // updatedContent.setComment(content.getComment());
   //TODO:まとめてコピーしたら動かないか？
   //TODO:楽観的ロックのチェックは自分でやるのか？今のままだと、楽観的ロックが意図したとおりに動かない。
   //->Version情報を渡すことで解決した。？
   
   return contentRepository.save(content);
}

}
