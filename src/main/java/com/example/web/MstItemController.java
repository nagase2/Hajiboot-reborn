package com.example.web;

import java.awt.print.Pageable;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.MstItem;
import com.example.service.CustomerService;
import com.example.service.MstItemService;

@Controller
@Slf4j
public class MstItemController {

  @Autowired
  MstItemService mstItemService;

  @RequestMapping("/itemlist")
  String startpage(Model model) {
    log.info("ここでMstItemLlistを取得!");

    List<MstItem> items = mstItemService.findAll();

    model.addAttribute("items", items);


    return "MstItemList";
  }

}
