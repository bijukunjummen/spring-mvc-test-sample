package mvcsample.repo;

import javax.sql.DataSource;

import mvcsample.config.RootConfiguration;
import mvcsample.repositories.MemberRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class MemberRepoTest {

	@Autowired
	private MemberRepository memberRepository;

	@Test
	public void testTryMemberRepo() {
		System.out.println(this.memberRepository.count());
	}

	@Configuration
	@Import(RootConfiguration.class)
	public static class SpringConfig {

		@Bean
		public DataSource dataSource() {
			EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
			return builder.setType(EmbeddedDatabaseType.H2).build();
		}
	}

}
