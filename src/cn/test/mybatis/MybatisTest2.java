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
    	//Mapper�ӿڿ�������ֻ��Ҫ����Ա��дMapper�ӿڣ��൱��Dao�ӿڣ�����Mybatis��ܸ��ݽӿڶ��崴���ӿڵĶ�̬�������
        String resource="cn/test/mybatis/mybatis-config.xml"; 
        //�������ļ�
        InputStream in=Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder= new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        SqlSession sqlSession=factory.openSession();  
        //������ʹ�����ַ�ʽ�����п���������ݣ����븴���Ըߣ���ȥ�ܶ��ظ��������롣
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user=userMapper.findUserById(10);
        System.out.println(user);
        sqlSession.close();     
    }
}
