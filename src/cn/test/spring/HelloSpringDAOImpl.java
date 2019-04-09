package cn.test.spring;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.test.spring.User;

public class HelloSpringDAOImpl implements HelloSpringDAO {

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insertUser(User user) {
		String sql = "insert into user(username,birthday,sex,address) values (?, ?, ?, ?)";
		
		//使用jdbcTemplate代替传统JDBC代码
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);		
		jdbcTemplate.update(sql, new Object[] { user.getUsername(),
				(Timestamp) user.getBirthday(),
				user.getSex(),
				user.getAddress()
		});
		//使用传统JDBC代码插入数据
/*		Connection conn = null;		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setTimestamp(2, (Timestamp) user.getBirthday());
			ps.setString(3, user.getSex());
			ps.setString(4, user.getAddress());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}*/
}

	@Override
	public User findUserById(int id) {
		String sql = "SELECT * FROM user WHERE id = ?";	
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		User user = (User)jdbcTemplate.queryForObject(
				sql, new Object[] { id }, new UserRowMapper());
		return user;
/*		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, custId);
			User user = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {	
				user = new User(
					rs.getString("username"), 
					rs.getString("sex"),
					rs.getString("address"),
					rs.getTimestamp("birthday")
				);
			}
			rs.close();
			ps.close();
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}*/
	}
}
