package com.ms.handler;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
		String role =null;
		
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) authentication.getAuthorities();
		
		for(GrantedAuthority authority : authorities) {
		  role = authority.getAuthority();
		  
		  if(role.equals("admin")) {
			 response.sendRedirect("/multisecurity/admin-dashboard.htm");
		  }else if(role.equals("csr")) {
			  response.sendRedirect("/multisecurity/csr-dashboard.htm");
		  }
		}
		
		super.onAuthenticationSuccess(request, response, authentication);
	}

	
}
