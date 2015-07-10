package com.example.web;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Content;
import com.example.service.ContentService;

@Controller
@RequestMapping("content")
@Slf4j
public class ContentController {

  @Autowired
  ContentService contentService;


  @RequestMapping("/list")
  String showContentList(Model model,Integer page) {
    log.info("ここでContent Llistを取得!");

    // List<Content> contents = contentService.findByContentName("aaa");// これはOK
    // List<Content> contents = contentService.findAll();// これは... OK
    if(page==null){
      page=0;
    }
    Pageable pageable = new PageRequest(page, 5);
    log.info("データ取得前");
    Page<Content> contents = contentService.findAllOrderByContentId(pageable);
    log.info("データ取得しました。");

    model.addAttribute("contents", contents);
    return "content/contentList";
  }

  // @Query("SELECT a FROM Customer a ORDER BY a.firstName, a.lastName")
  // // JPQLで指定
  // Page<Customer> findAllOrderByName2(Pageable pageable);

}
