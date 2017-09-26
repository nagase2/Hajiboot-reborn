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
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.mock.web.MockHttpServletResponse;
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
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.standard.expression.AndExpression;

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
public class CustomerRestControllerIntegrationTest {
  @Autowired
  private WebApplicationContext context;
  private MockMvc mvc;
  private MockMvc mvc2;
  @Autowired
  CustomerService customerService;
  
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
    /** すべて２００が返ってくることを確認したい場合は下記のように記述する*/
    //mvc = MockMvcBuilders.webAppContextSetup(context).alwaysExpect(status().isOk())
	  

	
    mvc = MockMvcBuilders.webAppContextSetup(context)
          .apply(SecurityMockMvcConfigurers.springSecurity()).build();
    
    
    //コントローラだけ使う場合のサンプル
	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	viewResolver.setPrefix("/WEB-INF/jsp/view/");
	viewResolver.setSuffix(".jsp");
    
    mvc2 = MockMvcBuilders.standaloneSetup(new CustomerController()).setViewResolvers(viewResolver).build();
    

//	mockMvc = MockMvcBuilders.standaloneSetup(new HelpController())
//							 .setViewResolvers(viewResolver)
//							 .build();
    apiEndpoint ="http://localhost:"+port;
  }
  
 /**
  * Spring SecuritをOnにするとうまくいかない。。。（Offだとうまくいく）
  * @throws Exception
  */
 // @Test
  @WithUserDetails("user")
  public void __testGetCustomers() throws Exception {
    String url = apiEndpoint + "/api/customers";
    ResponseEntity<Page<Customer>> response = restTemplate.exchange(url,  HttpMethod.GET, null /*body, header */
        ,new ParameterizedTypeReference<Page<Customer>>(){}); // 
//    .perform(get(url).with(user("admin").password("pass").roles("USER","ADMIN")))
    assertThat(response.getStatusCode(),is(HttpStatus.OK));
    System.out.println("Test Completed"+response.getBody().toString());
  }
  
  //@Test //テスト対象外！（うまく動作しないため。SpringSecurityを使ったControllerのテストは、この方法は適さない。
  @WithUserDetails("user")
  public void __testGetCustomers2() throws Exception {
    String url = apiEndpoint + "/content/list";
    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class); // 
    
    assertThat(response.getStatusCode(),is(HttpStatus.OK));
    //assertThat(response.getHeaders())
    System.out.println("HEADER:::"+response.getHeaders());
    System.out.println("Test Completed"+response.getBody().toString());
  }
  
  //@Test
  public void __testGetCustomers3() throws Exception {
    String url = apiEndpoint + "/xxxx";
    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class); // 
    
    assertThat(response.getStatusCode(),is(HttpStatus.OK));
    //assertThat(response.getHeaders())
    System.out.println("HEADER:::"+response.getHeaders());
    System.out.println("Test Completed"+response.getBody().toString());
  }
  
  @Test
  public void testGetCustomers4() throws Exception {
    String url = apiEndpoint + "/api/customers";
   /*これはOK。ちゃんとStringに返り値が入っている。 */
   ResultActions ra = mvc
    .perform(get(url).with(user("admin").password("pass").roles("USER","ADMIN")))
    .andExpect(status().isOk())
    .andExpect(content().string(containsString("firstName")));
   
 }
  /**
   * 認証を指定しない（NG）
   * @throws Exception
   */
  @Test
  public void testGetCustomers4_2() throws Exception {
    String url = apiEndpoint + "/xxxxxxxx";
   ResultActions ra = mvc
    .perform(get(url).with(user("a").password("a")))
    .andExpect(status().isNotFound());
    //.andExpect(content().string(containsString("firstName")));
   
 }
  @Test
  public void testGetCustomers5() throws Exception {
    String url = apiEndpoint + "/content/list";
   /* 何故かContentの中に値が入ってこない。 Mockであるがゆえの仕様っぽい。*/
   ResultActions ra = mvc
    .perform(get(url).with(user("user2").password("pass").roles("USER","ADMIN")))
    .andExpect(status().isOk())
    .andExpect(model().attributeExists("contents"))
    .andExpect(model().size(3))
    .andExpect(view().name("content/contentList"))
    .andExpect(view().name(containsString("content")));
   
   System.out.println(ra.andReturn().getResponse().toString());
   System.out.println("●STATUS"+status().toString());
   
   // .andExpect(content().);
    //.perform(get(url)); 
   
   System.out.println("★"+ra.andReturn().getResponse().toString());
   
   ///色々やってみたけど、値がうまく取れない。確認できるのは値の数までか。。。
   //Entityの値がLAZYになっていると、値の中身を確認できない。それ以外は多分確認可能
   MockHttpServletResponse msr = ra.andReturn().getResponse();
   
   //このパターンは、値の習得が可能。（渡しているのが普通のStringであるため）
   Map<String, Object> m = ra.andReturn().getModelAndView().getModel();
   System.out.println("★★★"+m.get("testvalue"));
   
   /** Assersionの良いサンプルなので載せておく*/
//   mockMvc.perform(
//       post("/policies/persist").param("companyName", "Company Name")
//       .param("name", "Name").param("effectiveDate", "2001-01-01"))
//       .andExpect(status().isMovedTemporarily()).andExpect(model().hasNoErrors())
//       .andExpect(redirectedUrl("list"));


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