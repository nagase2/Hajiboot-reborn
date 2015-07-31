package com.test

import org.springframework.beans.factory.annotation.Autowired

import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders

import spock.lang.Specification

import com.example.App2
import com.example.repository.CustomerRepository
import com.example.service.CustomerService
import com.example.web.CustomerController;


@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = App2.class)
@WebAppConfiguration
@IntegrationTest
class SpockControllerTest extends Specification {
  @Autowired
  CustomerController customerController
  //@Autowired
  
//  @Autowired
//  def ContentService contentService
  
   MockMvc mockMvc;
   
//   @Autowired
//   CustomerService customerService;
//   
//   @Autowired
//   CustomerRepository customerRepository;
   
 
    def setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build()
       // contentController.contentService = contentService
    }

    def "Content一覧取得"() {
      String url ="http://localhost:9999";
      
        when:
        def response = mockMvc.perform(get("http://localhost:9999/content/list").with(user("user2").password("pass")))

        then:
        response.andExpect(status().isOk())
        println "LLLLL"+response.andReturn().response.contentAsString
    }
    
    def "デタラメURL"() {
      
        when:
        def response = mockMvc.perform(get("http://localhost:9999/content/xxxxxxx").with(user("user2").password("pass")))

        then:
        response.andExpect(status().isNotFound())
    }
}
