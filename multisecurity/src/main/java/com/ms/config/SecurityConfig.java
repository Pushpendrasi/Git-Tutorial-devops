package com.ms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.ms.handler.SuccessHandler;
import com.ms.security.beans.UserDetailService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)

@ComponentScan(basePackages= {"com.ms.security.beans","com.ms.handler"})
public class SecurityConfig extends WebSecurityConfigurerAdapter{
  
	@Autowired
	public SuccessHandler successHandler;
	
	@Autowired
	public UserDetailService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/csr-dashboard.htm").hasAuthority("csr").antMatchers("/admin-dashboard.htm").hasAuthority("admin").and().formLogin().usernameParameter("j_user").passwordParameter("j_password").loginProcessingUrl("/j_user_check").successHandler(successHandler);

	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	
	/*auth.inMemoryAuthentication().withUser("john").password("welcome1").roles("USER");*/
	
	
}
