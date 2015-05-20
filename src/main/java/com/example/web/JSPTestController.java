package com.example.web;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class JSPTestController {

	
	@RequestMapping("/jsptest1")
	String JSPTest1() {
		
		//値渡しA（一つのクラスを渡すパターン）
		
		log.info("JSP test が呼ばれました。!!");
		return "jsptest";
	}
	
	@RequestMapping("/jsptest2")
	String JSPTest2() {
		
		//値渡しB(複数のクラスをListに入れて渡すパターン）
		
		log.info("JSP test が呼ばれました。!!");
		return "jsptest2";
	}
}


