package masterSpringMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=MasterSpringMvcApplication.class)
@WebAppConfiguration
public class HomeControllerTest {

	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		this.mockMvc=MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void should_redirect_to_profile() throws Exception{
		this.mockMvc.perform(get("/"))
			.andDo(print())
			.andExpect(status().isFound())
			.andExpect(redirectedUrl("/profile"));
	}
	
	@Test
	public void should_redirect_to_tastes() throws Exception{
		MockHttpSession session = new SessionBuilder().userTastes("spring","java").build();
		
		this.mockMvc.perform(get("/").session(session))
				.andExpect(status().isFound())
				.andExpect(redirectedUrl("/search/mixed;keywords=spring,java"));
	}
	
}
