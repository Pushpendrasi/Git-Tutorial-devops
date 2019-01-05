package com.ms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.ms.bo.RoleBo;
import com.ms.bo.UserBo;

@Repository
public class UserDao {

	public final String GET_USERNO_FROM_USERNAME ="select u.*,r.*,ur.* from users u inner join user_role ur on u.user_id=ur.user_id inner join role r on ur.role_id=r.role_id where u.username=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	 @Autowired
	    public void setJdbcTemplate( JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }
	
	public UserBo getUserInfo(String userName) {
		
				System.out.println("UserDao  :"+userName);
		
	return	jdbcTemplate.queryForObject(GET_USERNO_FROM_USERNAME, new RowMapper<UserBo>() {

			@Override
			public UserBo mapRow(ResultSet rs, int size) throws SQLException {
				
				System.out.println(userName);
				
				UserBo bo = null;
				RoleBo roleBo = null;
				
				bo = new UserBo();
				bo.setUserName(rs.getString("u.username"));
				bo.setPassword(rs.getString("u.password"));
				
				roleBo = new RoleBo();
				roleBo.setRoleName(rs.getString("r.role_name"));
				
				bo.setBo(roleBo);
				
				System.out.println(bo);
				return bo;
			}
		
		},userName);
	}
}
