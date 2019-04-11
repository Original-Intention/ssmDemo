package cn.test.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.test.mybatis.vo.User;

public interface UserMapper {
	/**
	 * @author zwh
	 * @param id 主键
	 * @date 2019-3-26 16:22:03
	 * @return 单个用户信息
	 */
	public User findUserById(int id);
	/**
	 * @author zwh
	 * @param username 用户名
	 * @date 2019-3-26 16:22:03
	 * @return 用户信息集合
	 */
	public List<User> findUserByUsername(String username);
	/**
	 * @author zwh
	 * @date 2019-3-26 16:22:03
	 * @param user 用户信息
	 */
	public void insertUser(User user);
	/**
	 * @author zwh
	 * @date 2019-3-26 16:22:03
	 * @param users 用户信息集合
	 */
	public void insertUsers(List<User> users);
	/**
	 * @author zwh
	 * @date 2019-3-26 16:22:03
	 * @param id 主键
	 */
	public void deleteUser(Integer id);
	
	/**
	 * @author zwh
	 * @date 2019-3-26 16:22:03
	 * @param id 主键
	 * @description 字符串替换
	 */
	@Select("select * from user where ${column} = #{value}")
	public List<User> findUserByParams(@Param("column") String column, @Param("value") String value);
}
