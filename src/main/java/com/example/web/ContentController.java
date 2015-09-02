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
import com.example.domain.MstItem;
import com.example.service.ContentService;
import com.example.service.MstItemService;

@Controller
@RequestMapping("content")
@Slf4j
public class ContentController  {

  @Autowired
  private ContentService contentService;
  @Autowired
  private MstItemService mstItemService;

  /**
   * Contentの一覧画面を表示する。
   * EntityGraphを使って全部所得（EAGERなので遅い）
   * @param model
   * @param contentForm
   * @return
   */
  @RequestMapping("/list")
  String showContentList(Model model, ContentForm contentForm) {
    log.info("ここでContent Llistを取得!");

    Pageable pageable = new PageRequest(contentForm.getPage(), contentForm.getSize());
    log.info("データ取得前");
    
    Page<Content> contents;
    
    if(contentForm.getContentName()==null){
      // contents = contentService.findAllOrderByContentId(pageable);
      contents=contentService.simpleFindAllWithEntityGraph(contentForm,pageable);
    }else{
//      contents = contentService.findAllWithEntityGraph(
//        contentForm.getContentName(),contentForm.getCount(),contentForm.getComment(),0, pageable);
      contents=contentService.simpleFindAllWithEntityGraph(contentForm,pageable);
    }
    log.info("データ取得しました。■");
    
  //Itemマスタを渡す
    List<MstItem> mstItems = mstItemService.findAll();
    log.info("Listの件数"+mstItems.size());
    model.addAttribute("mstItems",mstItems);

    model.addAttribute("contents", contents);
    return "content/contentList";
  }
  
  /**
   * こっちはEntityGraphなしで全件取得(LAZYなのではやい）
   * @param model
   * @param contentForm
   * @return
   */
  @RequestMapping("/list2")
  String showContentList2(Model model, ContentForm contentForm) {
    log.info("ここでContent Llistを取得!");

    Pageable pageable = new PageRequest(contentForm.getPage(), contentForm.getSize());
    log.info("データ取得前");
    
    Page<Content> contents;
    
      contents = contentService.findAll(pageable);
    log.info("データ取得しました。■");
    
  //Itemマスタを渡す
    List<MstItem> mstItems = mstItemService.findAll();
    log.info("Listの件数"+mstItems.size());
    model.addAttribute("mstItems",mstItems);

    model.addAttribute("contents", contents);
    return "/content/contentList.jsp";
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
	  log.info("更新Form表示機能が呼ばれました。");

    Pageable pageable = new PageRequest(contentForm.getPage(), contentForm.getSize());
    // List<Content> contents = contentService.findByContentName("aaa");// これはOK
    // List<Content> contents = contentService.findAll();// これは... OK

//    Page<Content> contentList =
//        contentService.findByContentNameOrderByContentId(contentForm.getContentName(), pageable);
//    log.info("データ取得しました。ID= "+contentForm.getContentId());

    //Idからオブジェクト取得
   Content content = contentService.findByContentId(contentForm.getContentId());
    
   //Itemマスタを渡す
    List<MstItem> mstItems = mstItemService.findAll();
    log.info("Listの件数"+mstItems.size());
    model.addAttribute("mstItems",mstItems);
    
    model.addAttribute("contentForm", content);
    return "content/updateForm";
    
  }

  /**
   * 
   * @param model
   * @param contentForm
   * @return
   */
  @RequestMapping(value = "/update", method = RequestMethod.POST)
  String updateAndCreateContent2(Model model, ContentForm contentForm,MstItem mstItem) {

    
    log.info("データ更新処理をここで行います。"+contentForm.getContentId()+contentForm.getContentName());
   log.info("mstitem="+mstItem.getItemId());
   //log.info("FormのItem"+cmstItem)
    Content content = new Content();
    //FormからEntityにコピー
    BeanUtils.copyProperties(contentForm, content);
    log.info("xxxxxxxxxxxxxx"+content.getContentId()+content.getContentName());
    
    contentService.update(content);
    
    // @Query("SELECT a FROM Customer a ORDER BY a.firstName, a.lastName")
    // // JPQLで指定
    // Page<Customer> findAllOrderByName2(Pageable pageable);
    return "redirect:list";
  }
  
  /**
   * トランザクションメソッドのテスト用
   * @param model
   * @param contentForm
   * @param mstItem
   * @return
 * @throws Throwable 
   */
  @RequestMapping(value = "/trantest", method = RequestMethod.GET)
  String tranTest(Model model, ContentForm contentForm) throws Throwable {
	  //ここでトランザクションテスト
	  contentService.update5Data();
	  
	  
	  Pageable pageable = new PageRequest(contentForm.getPage(), contentForm.getSize());

	    log.info("データ取得前");
	    Page<Content> contentList =
	        contentService.findByContentNameOrderByContentId(contentForm.getContentName(), pageable);
	    log.info("データ取得しました。");
	    model.addAttribute("contents", contentList);
	    model.addAttribute("form", contentForm);
	    return "content/contentList";
  }
  

}
