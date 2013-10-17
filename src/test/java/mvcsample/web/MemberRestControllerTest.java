package mvcsample.web;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@ContextConfiguration(locations={"classpath:/META-INF/spring/web/mvc-config.xml",  "classpath:/META-INF/spring/applicationContext.xml", "classpath:/META-INF/spring/applicationContext-jpa.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MemberRestControllerTest {
	private final String createJson = "{\"id\":%d,\"first\":\"%s\",\"last\":\"%s\",\"version\":%d}";
	private final String membersJson = "[{\"id\":1,\"first\":\"One\",\"last\":\"One\",\"version\":0},{\"id\":2,\"first\":\"Two\",\"last\":\"Two\",\"version\":0},{\"id\":3,\"first\":\"Three\",\"last\":\"Three\",\"version\":0}]";
	
	@Autowired
	private WebApplicationContext wac;
	
	
//	 @Autowired
//	 private FilterChainProxy springSecurityFilterChain;
	

	private MockMvc mockMvc;
	
	private SessionHolder sessionHolder = new SessionHolder();
	

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//				.addFilters(springSecurityFilterChain).build();
	}
	private static final String SEC_CONTEXT_ATTR = HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;
	@Test
	public void testAControllerFlow() throws Exception {
//		this.mockMvc.perform(post("/j_spring_security_check")
//				.param("j_username", "fred")
//				.param("j_password", "fredspassword"))
//				.andExpect(status().isMovedTemporarily())
//				.andDo(new ResultHandler() {
//					@Override
//					public void handle(MvcResult result) throws Exception {
//						sessionHolder.setSession(new SessionWrapper(result.getRequest().getSession()));
//					}
//				});
		
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
	
	private static final class SessionHolder{
		private SessionWrapper session;
		

		public SessionWrapper getSession() {
			return session;
		}

		public void setSession(SessionWrapper session) {
			this.session = session;
		}
	}
	
	private static class SessionWrapper extends MockHttpSession{
		private final HttpSession httpSession;
		
		public SessionWrapper(HttpSession httpSession){
			this.httpSession = httpSession;
		}

		@Override
		public Object getAttribute(String name) {
			return this.httpSession.getAttribute(name);
		}
		
	}
	
	
}


