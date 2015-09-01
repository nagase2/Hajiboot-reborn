import java.util.List;

import lombok.Data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.example.App2;
import com.example.domain.Customer;
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
  //private MockMvc mvc;
  
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
 // @WithMockUser
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