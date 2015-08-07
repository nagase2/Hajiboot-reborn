package com.example.web;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class LoginController {
  @RequestMapping("/")
  String startpage() {
    log.info("start");
    return "loginForm.html";
  }

  @RequestMapping("loginForm")
  String loginForm() {
    log.info("LoginFormが呼ばれました。!!!!!!llllooooo");
    return "loginForm.html";
  }
}
