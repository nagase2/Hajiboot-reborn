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
@IntegrationTest
class SpockControllerTest extends Specification {
  @Autowired
  CustomerController customerController
  //@Autowired
  
//  @Autowired
//  def ContentService contentService
  
   MockMvc mockMvc;
   @Autowired
   private WebApplicationContext context;
//   @Autowired
//   CustomerService customerService;
//   
//   @Autowired
//   CustomerRepository customerRepository;
   
 
    def setup() {
        //mockMvc = MockMvcBuilders.standaloneSetup(customerController).build()
       // contentController.contentService = contentService
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
        .apply(SecurityMockMvcConfigurers.springSecurity()).build();
        
        }

    def "Content一覧取得"() {
      String url ="http://localhost:7776";
      
        when:
        ResultActions response = mockMvc.perform(get("http://localhost:7776/content/list").with(user("user2").password("pass")))

        then:
        response.andExpect(status().isOk())
        println "LLLLL"+response.andReturn().response.contentAsString
    }
    
    def "デタラメURL"() {
      
        when:
        def response = mockMvc.perform(get("http://localhost:7776/content/xxxxxxx").with(user("user2").password("pass")))

        then:
        response.andExpect(status().isNotFound())
    }
}
