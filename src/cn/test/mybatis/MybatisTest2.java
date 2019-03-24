package cn.test.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MybatisTest2 {

    @Test
    public void test() throws IOException { 
    	//Mapper接口开发方法只需要程序员编写Mapper接口（相当于Dao接口），由Mybatis框架根据接口定义创建接口的动态代理对象。
        String resource="cn/test/mybatis/mybatis-config.xml"; 
        //加配置文件
        InputStream in=Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder= new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        SqlSession sqlSession=factory.openSession();  
        //开发中使用这种方式来进行开发，简便快捷，代码复用性高，免去很多重复繁琐代码。
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user=userMapper.findUserById(10);
        System.out.println(user);
        sqlSession.close();     
    }
}
