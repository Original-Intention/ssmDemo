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

public class MybatisTest3 {

    @Test
    public void insertUsers() throws IOException { 
    	//Mapper�ӿڿ�������ֻ��Ҫ����Ա��дMapper�ӿڣ��൱��Dao�ӿڣ�����Mybatis��ܸ��ݽӿڶ��崴���ӿڵĶ�̬�������
        String resource="cn/test/mybatis/mybatis-config.xml"; 
        //�������ļ�
        InputStream in=Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder= new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        SqlSession sqlSession=factory.openSession();  
        //������ʹ�����ַ�ʽ�����п���������ݣ����븴���Ըߣ���ȥ�ܶ��ظ��������롣
        try {
        	UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        	List<User> users = new ArrayList<User>();
        	for(int i=0;i<5;i++) {
        		User user=new User();
        		user.setUsername("����"+i);
        		user.setBirthday(new Date()); 
        		user.setSex("��");
        		user.setAddress("���Ի���ɽ"+i);
        		users.add(user);
        		//userMapper.insertUser(user);        		
        	}
        	userMapper.insertUsers(users);
        	sqlSession.commit();
        }finally {
        	sqlSession.close();
        }
    }
}
