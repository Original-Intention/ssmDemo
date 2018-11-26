package cn.test.mybatis;

import java.util.List;

public interface UserMapper {

	public User findUserById(int id);

	public List<User> findUserByUsername(String username);

	public void insertUser(User user);

	public void deleteUser(Integer id);
}
