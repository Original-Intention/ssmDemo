package cn.test.mybatis;

import java.util.List;

public interface UserMapper {
	/**
	 * @author zwh
	 * @param id ����
	 * @date 2019-3-26 16:22:03
	 * @return �����û���Ϣ
	 */
	public User findUserById(int id);
	/**
	 * @author zwh
	 * @param username �û���
	 * @date 2019-3-26 16:22:03
	 * @return �û���Ϣ����
	 */
	public List<User> findUserByUsername(String username);
	/**
	 * @author zwh
	 * @date 2019-3-26 16:22:03
	 * @param user �û���Ϣ
	 */
	public void insertUser(User user);
	/**
	 * @author zwh
	 * @date 2019-3-26 16:22:03
	 * @param users �û���Ϣ����
	 */
	public void insertUsers(List<User> users);
	/**
	 * @author zwh
	 * @date 2019-3-26 16:22:03
	 * @param id ����
	 */
	public void deleteUser(Integer id);
}
