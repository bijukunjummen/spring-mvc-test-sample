package mvcsample.bpp;

import static org.junit.Assert.*;

import mvcsample.domain.Address;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestBpp {

	@Autowired Address address1;
	@Test
	public void test() {
		System.out.println(address1);
	}
	
	@Configuration
	public static class AConfiguration{
		@Bean
		public TestBeanPostProcessor beanPostProcessor1(){
			return new TestBeanPostProcessor();
		}
		
		@Bean
		public Address address1(){
			return new Address();
		}
	}

}
