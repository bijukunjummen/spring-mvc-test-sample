package mvcsample.web;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/mvc-config.xml", "classpath:/META-INF/spring/applicationContext.xml", "classpath:/META-INF/spring/applicationContext-jpa.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MemberJsonControllerTest {
	private final String createJson = "{\"id\":%d,\"first\":\"%s\",\"last\":\"%s\",\"version\":%d}";
	private final String membersJson = "[{\"id\":1,\"first\":\"One\",\"last\":\"One\",\"version\":0},{\"id\":2,\"first\":\"Two\",\"last\":\"Two\",\"version\":0},{\"id\":3,\"first\":\"Three\",\"last\":\"Three\",\"version\":0}]";
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void testAControllerFlow() throws Exception {
		this.mockMvc.perform(post("/membersjson").contentType(MediaType.APPLICATION_JSON).content(String.format(createJson, 1,"One","One", 0).getBytes()))
				.andExpect(status().isOk());
		this.mockMvc.perform(post("/membersjson").contentType(MediaType.APPLICATION_JSON).content(String.format(createJson, 2,"Two","Two", 0).getBytes()))
			.andExpect(status().isOk());
		this.mockMvc.perform(post("/membersjson").contentType(MediaType.APPLICATION_JSON).content(String.format(createJson, 3,"Three","Three", 0).getBytes()))
			.andExpect(status().isOk());		
		
		this.mockMvc.perform(get("/membersjson").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString(membersJson)));
		
		this.mockMvc.perform(put("/membersjson").contentType(MediaType.APPLICATION_JSON).content(String.format(createJson, 1,"One","OneUpdated", 0).getBytes()))
			.andExpect(status().isOk());
		
		mockMvc.perform(get("/membersjson").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].first").value("One"));
		
		mockMvc.perform(get("/membersjson/1").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("OneUpdated")));

	}
}


