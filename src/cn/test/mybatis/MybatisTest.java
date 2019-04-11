package cn.test.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.test.mybatis.vo.User;

public class MybatisTest {

    @Test
    public void test() throws IOException { 

        String resource="cn/test/mybatis/mybatis-config.xml"; 
        //加配置文件
        InputStream in=Resources.getResourceAsStream(resource);
        //创建SqlSessionFactoryBuilder对象用来创建工厂
        SqlSessionFactoryBuilder builder= new SqlSessionFactoryBuilder();
        //创建工厂
        SqlSessionFactory factory=builder.build(in); 
        //创建Session
        SqlSession sqlSession=factory.openSession(); 
        //进行第一次查询
        System.out.println("查询用户BYID");
        User user_select=(User)sqlSession.selectOne("cn.test.mybatis.UserMapper.findUserById",1);
        System.out.println(user_select);
        //进行第二次查询
        System.out.println("查询用户BYUsername");
        List<User> users=sqlSession.selectList("cn.test.mybatis.UserMapper.findUserByUsername","五");
        for(User user_byname:users) {
            System.out.println(user_byname);
        }
        //添加人员
        System.out.println("开始添加人员：齐天大圣");
        User user=new User();
        user.setUsername("齐天大圣");
        user.setBirthday(new Date()); 
        user.setSex("男");
        user.setAddress("花果山");
        sqlSession.insert("cn.test.mybatis.UserMapper.insertUser", user);
        sqlSession.commit();
        //更新人员信息
        System.out.println("开始更新人员信息：齐天大圣 -> 天蓬元帅");
        user.setId(27);
        user.setUsername("天蓬元帅");
        user.setBirthday(new Date()); 
        user.setSex("女");
        user.setAddress("银河");
        sqlSession.update("cn.test.mybatis.UserMapper.updateUser", user);
        sqlSession.commit();
        //执行删除操作
        System.out.println("删除人员：id=27");
        sqlSession.delete("cn.test.mybatis.UserMapper.deleteUser", 27);
        sqlSession.close();
               
    }
    
    @Test
    public void testMapperIn() throws IOException { 
    	//Mapper接口开发方法只需要程序员编写Mapper接口（相当于Dao接口），由Mybatis框架根据接口定义创建接口的动态代理对象。
        String resource="cn/test/mybatis/mybatis-config.xml"; 
        //加配置文件
        InputStream in=Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder= new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        SqlSession sqlSession=factory.openSession();  
        //开发中使用这种方式来进行开发，简便快捷，代码复用性高，免去很多重复繁琐代码。
        try {
        	UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        	User user=userMapper.findUserById(10);
        	System.out.println(user);
        }finally {
        	sqlSession.close();
        }
    }
    @Test
    public void insertUsers() throws IOException { 
    	//Mapper接口开发方法只需要程序员编写Mapper接口（相当于Dao接口），由Mybatis框架根据接口定义创建接口的动态代理对象。
        String resource="cn/test/mybatis/mybatis-config.xml"; 
        //加配置文件
        InputStream in=Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder= new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        SqlSession sqlSession=factory.openSession();  
        //开发中使用这种方式来进行开发，简便快捷，代码复用性高，免去很多重复繁琐代码。
        try {
        	UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        	//测试批量插入
        	List<User> users = new ArrayList<User>();
        	/*       	
        	for(int i=0;i<5;i++) {
        		User user=new User();
        		user.setUsername("测试"+i);
        		user.setBirthday(new Date()); 
        		user.setSex("男");
        		user.setAddress("测试花果山"+i);
        		users.add(user);
        		//userMapper.insertUser(user);        		
        	}
        	userMapper.insertUsers(users);  
        	sqlSession.commit();      	
        	*/
        	//测试字符串替换
        	users = userMapper.findUserByParams("username", "测试0");
        	for(User us : users) {
        		System.out.println(us);
        	}
        }finally {
        	sqlSession.close();
        }
    }
}
