package com.test

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.hasXPath;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext;

import spock.lang.Specification

import com.example.App2
import com.example.repository.CustomerRepository
import com.example.service.CustomerService
import com.example.web.CustomerController;


@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = App2.class)
@WebAppConfiguration
@IntegrationTest(["server.port:0","spring.datasource.url:jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=postgreSQL"])
class CopyOfSpockControllerTest extends Specification {
  @Autowired
  CustomerController customerController

  MockMvc mockMvc;
  @Autowired
  private WebApplicationContext context;

  @Value("\${local.server.port}")
  int port;

  String endPointURL;

  def setup() {

    mockMvc = MockMvcBuilders.webAppContextSetup(context)
        .apply(SecurityMockMvcConfigurers.springSecurity()).build();
    endPointURL = "http://localhost:"+port
    println "URL is "+endPointURL
  }
  def "Customers Controller Test(Thymeleaf)"(){

    when:
    def response = mockMvc.perform(get(endPointURL+"/customers").with(user("user2").password("pass")))

    then:
    response.andExpect(status().isOk())

    println response.andReturn().response.contentAsString
  }

  def "Content Controller test(JSP)"() {

    when:
    def response = mockMvc.perform(get(endPointURL+"/content/list").with(user("user2").password("pass")))

    then:
    response.andExpect(status().isOk())

    println response.andReturn().response.contentAsString
  }



  def "Jspテスト"(){

    when:
    //テスト対象のURL（/content/list)にuser2でアクセスする。
    def response = mockMvc.perform(get(endPointURL+"/jsptest1").with(user("user2").password("pass")))

    then:
    //レスポンスがOKかどうかを確認
    response.andExpect(status().isOk())

    //レスポンスを文字で出力(うまく動作していない）
    println "LLLLL"+response.andReturn().response.contentAsString

  }

  def "デタラメURL"() {

    when:
    def response = mockMvc.perform(get(endPointURL+"/content/xxxxxxx").with(user("user2").password("pass")))

    then:
    //HTTPステータスコードがNotFound(404)であることを確認
    response.andExpect(status().isNotFound())
  }

  def "Content更新"() {

    when:
    def response = mockMvc.perform(get(endPointURL+"/content/update").with(user("user2").password("pass")))

    then:
    //HTTPステータスコードがNotFound(404)であることを確認
    response.andExpect(status().isNotFound())

    //処理の引数の内容が正しいことを確認


    //遷移先が正しいことを確認

  }
}
