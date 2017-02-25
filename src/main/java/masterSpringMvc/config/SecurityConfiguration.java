package masterSpringMvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{



	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/profile")
			.and()
			.logout().logoutSuccessUrl("/login")
			.and()
			.authorizeRequests()
			.antMatchers("/webjars/**", "/login", "/signin/**", "/signup").permitAll()
			.anyRequest().authenticated();
			
	}
	
	
	@Bean
	public SpringSecurityDialect springSecurityDialect() {
		SpringSecurityDialect dialect = new SpringSecurityDialect();
		return dialect;
	}
	
	
	
	
	
	
}
