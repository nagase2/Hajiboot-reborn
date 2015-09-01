package com.example
import static org.junit.Assert.*
import hello.world.jpa.Calc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

import spock.lang.Specification
import spock.lang.Stepwise

import com.example.App2
import com.example.repository.CustomerRepository
import com.example.web.CustomerController

/**
 * 全てまだ動かないので注意！！！
 * @author ac12955
 *
 */
//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = SpringApplicationContextLoader.class, classes = [App2.class] )
@WebIntegrationTest
@WebAppConfiguration
@IntegrationTest
@Stepwise
class MVCTest /*extends Specification*/{

  @Autowired
  private WebApplicationContext context;
  private MockMvc mvc;
  private Calc instance;
  @Autowired
  CustomerRepository customerRepository;
  @Autowired
  CustomerController customerController;
  
  
  def setup() {
   //mockMvc = MockMvcBuilders.standaloneSetup(customerController).build()
//      mvc = MockMvcBuilders.webAppContextSetup(context)
//          .apply(SecurityMockMvcConfigurers.springSecurity()).build();
   
   instance = new Calc()
 }

    def "２つの値の合計チェック"() {
        expect:
        instance.add(a, b) == c

        where:
        a | b | c
        1 | 3 | 4
        7 | 4 | 11
        0 | 0 | 0
        
    }

}
