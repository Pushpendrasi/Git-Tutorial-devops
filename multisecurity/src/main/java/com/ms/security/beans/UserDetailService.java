package com.ms.security.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ms.bo.RoleBo;
import com.ms.bo.UserBo;
import com.ms.dao.UserDao;

@Service
public class UserDetailService implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("UserDetailService :-"+username);
		
		UserBo bo = null;
		
		bo = userDao.getUserInfo(username);
		
		final String password = bo.getPassword();
		
		UserDetails details = new UserDetailsImpl();
		
	final	GrantedAuthority authority = new SimpleGrantedAuthority(bo.getBo().getRoleName());
		
						System.out.println("Authority :- "+authority.getAuthority());
			return new UserDetails() {
				
				@Override
				public boolean isEnabled() {
					// TODO Auto-generated method stub
					return true;
				}
				
				@Override
				public boolean isCredentialsNonExpired() {
					// TODO Auto-generated method stub
					return true;
				}
				
				@Override
				public boolean isAccountNonLocked() {
					// TODO Auto-generated method stub
					return true;
				}
				
				@Override
				public boolean isAccountNonExpired() {
					// TODO Auto-generated method stub
					return true;
				}
				
				@Override
				public String getUsername() {
					// TODO Auto-generated method stub
					return username;
				}
				
				@Override
				public String getPassword() {
					// TODO Auto-generated method stub
					return password;
				}
				
				@Override
				public Collection<? extends GrantedAuthority> getAuthorities() {
					// TODO Auto-generated method stub
					/*return (Collection<? extends GrantedAuthority>) authority;*/
					
					List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
					auths.add(new SimpleGrantedAuthority(authority.getAuthority()));
					return auths;
				}
			};
	}

}



/*GrantedAuthority authority = new SimpleGrantedAuthority("admin");
UserDetails userDetails = (UserDetails)new User("john", 
		"welcome1", Arrays.asList(authority));*/


/*	GrantedAuthority authority = new SimpleGrantedAuthority("admin");
UserDetails userDetails = (UserDetails)new User("john", 
		"welcome1", Arrays.asList(authority));*/