package com.ms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login.htm").setViewName("login");
		registry.addViewController("/csr-dashboard.htm").setViewName("csr-dashboard");
		registry.addViewController("/admin-dashboard.htm").setViewName("admin-dashboard");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
	registry.jsp("/WEB-INF/jsp/", ".jsp");	
	
	}

	
	
}
