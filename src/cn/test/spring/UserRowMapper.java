package cn.test.spring;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<Object> {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setUsername(rs.getString("username"));
		user.setSex(rs.getString("sex"));
		user.setBirthday(rs.getTimestamp("birthday"));
		user.setAddress(rs.getString("address"));
		return user;
	}

}
