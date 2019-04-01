package cn.test.spring;

import cn.test.spring.User;

public interface HelloSpringDAO {
	
	public void insertUser(User user);
	
	public User findUserById(int custId);
}
