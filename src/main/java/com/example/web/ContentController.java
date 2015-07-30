package com.example.web;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.example.domain.Content;
import com.example.service.ContentService;

@Controller
@RequestMapping("content")
@Slf4j
public class ContentController {

  @Autowired
  private ContentService contentService;


  /**
   * 一行表示
   * 
   * @param model
   * @param contentForm
   * @return
   */
  @RequestMapping("/list")
  String showContentList(Model model, ContentForm contentForm) {
    log.info("ここでContent Llistを取得!");

    Pageable pageable = new PageRequest(contentForm.getPage(), contentForm.getSize());
    log.info("データ取得前");
    Page<Content> contents = contentService.findAllOrderByContentId(pageable);
    log.info("データ取得しました。■");
    if(contents!=null){
       log.info("★サイズは="+contents.getSize());
    }
    
    model.addAttribute("testvalue","xxxxxxxxxSuccess!xxxxxxxxxx");

    model.addAttribute("contents", contents);
    return "content/contentList";
  }

  /**
   * ContentsNameで検索
   * 
   * @param model
   * @param contentForm
   * @return
   */
  @RequestMapping("/search")
  String searchContentsByContentsName(Model model, ContentForm contentForm) {

    Pageable pageable = new PageRequest(contentForm.getPage(), contentForm.getSize());
    // List<Content> contents = contentService.findByContentName("aaa");// これはOK
    // List<Content> contents = contentService.findAll();// これは... OK

    log.info("データ取得前");
    Page<Content> contentList =
        contentService.findByContentNameOrderByContentId(contentForm.getContentName(), pageable);
    log.info("データ取得しました。");
    model.addAttribute("contents", contentList);
    model.addAttribute("form", contentForm);
    return "content/contentList";
  }

  @RequestMapping("/search2")
  String searchContentsByContentsName2(Model model, ContentForm contentForm) {

    Pageable pageable = new PageRequest(contentForm.getPage(), contentForm.getSize());
    // List<Content> contents = contentService.findByContentName("aaa");// これはOK
    // List<Content> contents = contentService.findAll();// これは... OK

    log.info("データ取得前");
    Page<Content> contentList =
        contentService.findByContentNameOrderByContentId(contentForm.getContentName(), pageable);
    log.info("データ取得しました。");

    model.addAttribute("contents", contentList);
    model.addAttribute("form", contentForm);
    return "content/contentList";
  }

  @RequestMapping(value = "/update", method = RequestMethod.GET)
  String updateAndCreateContent(Model model, ContentForm contentForm) {

    Pageable pageable = new PageRequest(contentForm.getPage(), contentForm.getSize());
    // List<Content> contents = contentService.findByContentName("aaa");// これはOK
    // List<Content> contents = contentService.findAll();// これは... OK

//    log.info("データ取得前");
//    Page<Content> contentList =
//        contentService.findByContentNameOrderByContentId(contentForm.getContentName(), pageable);
//    log.info("データ取得しました。ID= "+contentForm.getContentId());

    //Idからオブジェクト取得
   Content content = contentService.findByContentId(contentForm.getContentId());
    
//    //MEMO:取得したオブジェクトを渡す
//   BeanUtils.copyProperties(contentForm, content);
//   
//   log.info("データをコピー= "+content.getContentName());
   
//    model.addAttribute("contents", contentList);
    model.addAttribute("contentForm", content);
    return "content/updateForm";
  }

  
  @RequestMapping(value = "/update", method = RequestMethod.POST)
  String updateAndCreateContent2(Model model, ContentForm contentForm) {

    
    log.info("データ更新処理をここで行います。"+contentForm.getContentId()+contentForm.getContentName());
    
    Content content = new Content();
    BeanUtils.copyProperties(contentForm, content);
    log.info("xxxxxxxxxxxxxx"+content.getContentId()+content.getContentName());
    contentService.update(content);
    
    // @Query("SELECT a FROM Customer a ORDER BY a.firstName, a.lastName")
    // // JPQLで指定
    // Page<Customer> findAllOrderByName2(Pageable pageable);
    return "redirect:list";
  }

}
