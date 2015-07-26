import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders

import com.example.App2;
import com.example.repository.CustomerRepository;
import com.example.service.ContentService;
import com.example.service.CustomerService;
import com.example.web.ContentController

import spock.lang.Specification
import static org.hamcrest.Matchers.*
import static org.hamcrest.CoreMatchers.*;
import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringApplicationConfiguration(classes = App2.class)
@WebAppConfiguration
@IntegrationTest("server.port:9999")
class SpockControllerTest extends Specification {
  def contentController = new ContentController()
  @Autowired
  def contentService = Mock(ContentService)
//  @Autowired
//  def ContentService contentService
  
   MockMvc mockMvc;
   
   @Autowired
   CustomerService customerService;
   
   @Autowired
   CustomerRepository customerRepository;
   
 
    def setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(contentController).build()
        contentController.contentService = contentService
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

//ResultActions ra = mvc
//.perform(get(url).with(user("user2").password("pass").roles("USER","ADMIN")))
//.andExpect(status().isOk())
//.andExpect(model().attributeExists("contents"))
//.andExpect(model().size(3))
//.andExpect(view().name("content/contentList"))
//.andExpect(view().name(containsString("content")));