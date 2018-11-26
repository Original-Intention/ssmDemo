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

public class MybatisTest {

    @Test
    public void test() throws IOException { 

        String resource="cn/test/mybatis/sqlMapConfig.xml"; 
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
        User user_select=(User)sqlSession.selectOne("test.findUserById",1);
        System.out.println(user_select);
        //进行第二次查询
        System.out.println("查询用户BYUsername");
        List<User> users=sqlSession.selectList("test.findUserByUsername","五");
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
        sqlSession.insert("test.insertUser", user);
        sqlSession.commit();
        //更新人员信息
        System.out.println("开始更新人员信息：齐天大圣 -> 天蓬元帅");
        user.setId(27);
        user.setUsername("天蓬元帅");
        user.setBirthday(new Date()); 
        user.setSex("女");
        user.setAddress("银河");
        sqlSession.update("test.updateUser", user);
        sqlSession.commit();
        //执行删除操作
        System.out.println("删除人员：id=27");
        sqlSession.delete("test.deleteUser", 27);
        sqlSession.close();
               
    }
}
