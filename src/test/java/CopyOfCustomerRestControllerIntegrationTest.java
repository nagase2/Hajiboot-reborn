import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.hasXPath;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

import javax.enterprise.inject.Model;

import lombok.Data;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.thymeleaf.standard.expression.AndExpression;

import sun.print.resources.serviceui;

import com.example.App2;
import com.example.domain.Customer;
import com.example.domain.User;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;
import com.example.web.CustomerController;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App2.class)
@WebAppConfiguration
@IntegrationTest({"server.port:0","spring.datasource.url:jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=postgreSQL"})
//jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;
//@WithMockUser
public class CopyOfCustomerRestControllerIntegrationTest {
  @Autowired
  private WebApplicationContext context;
  private MockMvc mvc;
  
  @Autowired
  CustomerService customerService;
  
  @Autowired
  CustomerRepository customerRepository;
  @Autowired
  CustomerController customerController;
  @Value("${local.server.port}")
  int port;
  String apiEndpoint;
  RestTemplate restTemplate = new TestRestTemplate();
  Customer customer1;
  Customer customer2;
  
  @Data
  @JsonIgnoreProperties(ignoreUnknown =true)
  static class Page<T>{
    private List<T> content;
    private int numberOfElements;
  }
 
  public void setUp(){
  //  mvc = MockMvcBuilders.webAppContextSetup(context).alwaysExpect(status().isOk())
  //        .apply(SecurityMockMvcConfigurers.springSecurity()).build();
    
  }
  @Test
  public void testGetCustomers8() throws Exception {

   // customerController.

 }

  @Test
  @WithMockUser
  public void testGetCustomer5() throws Exception {
    
    List<Customer> list = customerService.findAllSecured();
    System.out.println("見つかった件数："+list.size());
 }
  @Test
  public void testGetCustomers6() throws Exception {
    
    List<Customer> list = customerService.findAllSecured();
    System.out.println("見つかった件数："+list.size());
 }

}
/**
 * Test sample
 * https://github.com/spring-projects/spring-test-mvc/blob/master/src/test/java/org/springframework/test/web/server/samples/standalone/resultmatchers/ContentAssertionTests.java
*/