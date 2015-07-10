package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Content;
import com.example.domain.Customer;
import com.example.domain.MstItem;
import com.example.domain.User;
import com.example.repository.ContentRepository;
import com.example.repository.CustomerRepository;
import com.example.repository.MstItemRepository;

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

//  /**
//   * 並べ替えしてすべて返す
//   * @return
//   */
//  public List<Content> findAllOrderByContentName() {
//    return contentRepository.findAllOrderByContentId();
//  }

}