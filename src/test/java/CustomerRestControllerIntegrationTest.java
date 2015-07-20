import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.is;

import java.util.Arrays;
import java.util.List;

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
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.example.App2;
import com.example.domain.Customer;
import com.example.domain.User;
import com.example.repository.CustomerRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App2.class)
@WebAppConfiguration
@IntegrationTest({"server.port:0","spring.datasource.url:jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=postgreSQL"})
//jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;
@WithMockUser("user2")
public class CustomerRestControllerIntegrationTest {
  @Autowired
  CustomerRepository customerRepository;
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
 
  @Before
  public void setUp(){
    // add principal object to SecurityContextHolder
 
    //customerRepository.deleteAll();
    customer1= new Customer();
    customer1.setFirstName("Taro");
    customer1.setLastName("Yamada");
    customer1.setUser(new User("user2", "", null));
    customer1.setId(888);
    customer2 = new Customer();
    customer2.setId(999);
    customer2.setFirstName("Ichiro");
    customer2.setLastName("Suxzuki");
    customer2.setUser(new User("user2", "", null));
    
    //customerRepository.save(Arrays.asList(customer1,customer2));
    apiEndpoint ="http://localhost:"+port;
  }
  
 
  @Test
 // @with("user2")
  @WithUserDetails("user2")
  public void testGetCustomers() throws Exception {
    String url = apiEndpoint + "/api/customers";
    ResponseEntity<Page<Customer>> response = restTemplate.exchange(url,  HttpMethod.GET, null /*body, header */
        ,new ParameterizedTypeReference<Page<Customer>>(){}); // 
    
    assertThat(response.getStatusCode(),is(HttpStatus.OK));
    System.out.println("Test Completed"+response.getBody().toString());
  }
  
  @Test
  @WithUserDetails("user2")
  public void testGetCustomers2() throws Exception {
    String url = apiEndpoint + "/content/list";
    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class); // 
    
    assertThat(response.getStatusCode(),is(HttpStatus.OK));
    //assertThat(response.getHeaders())
    System.out.println("HEADER:::"+response.getHeaders());
    System.out.println("Test Completed"+response.getBody().toString());
  }

}
