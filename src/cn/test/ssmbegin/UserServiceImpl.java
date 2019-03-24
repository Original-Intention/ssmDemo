package cn.test.ssmbegin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.test.mybatis.User;
import cn.test.mybatis.UserMapper;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    public UserMapper userMapper;
    @Override
    public List<User> findAllUser() {
        // TODO Auto-generated method stub
        List<User> findAllUser = userMapper.findUserByUsername("");
        return findAllUser;
        
    }
}
