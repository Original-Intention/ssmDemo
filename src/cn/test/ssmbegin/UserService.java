package cn.test.ssmbegin;

import java.util.List;

import cn.test.mybatis.vo.User;

public interface UserService {

	 List<User> findAllUser();
}
