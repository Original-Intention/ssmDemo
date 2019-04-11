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
        //�������ļ�
        InputStream in=Resources.getResourceAsStream(resource);
        //����SqlSessionFactoryBuilder����������������
        SqlSessionFactoryBuilder builder= new SqlSessionFactoryBuilder();
        //��������
        SqlSessionFactory factory=builder.build(in); 
        //����Session
        SqlSession sqlSession=factory.openSession(); 
        //���е�һ�β�ѯ
        System.out.println("��ѯ�û�BYID");
        User user_select=(User)sqlSession.selectOne("cn.test.mybatis.UserMapper.findUserById",1);
        System.out.println(user_select);
        //���еڶ��β�ѯ
        System.out.println("��ѯ�û�BYUsername");
        List<User> users=sqlSession.selectList("cn.test.mybatis.UserMapper.findUserByUsername","��");
        for(User user_byname:users) {
            System.out.println(user_byname);
        }
        //�����Ա
        System.out.println("��ʼ�����Ա�������ʥ");
        User user=new User();
        user.setUsername("�����ʥ");
        user.setBirthday(new Date()); 
        user.setSex("��");
        user.setAddress("����ɽ");
        sqlSession.insert("cn.test.mybatis.UserMapper.insertUser", user);
        sqlSession.commit();
        //������Ա��Ϣ
        System.out.println("��ʼ������Ա��Ϣ�������ʥ -> ����Ԫ˧");
        user.setId(27);
        user.setUsername("����Ԫ˧");
        user.setBirthday(new Date()); 
        user.setSex("Ů");
        user.setAddress("����");
        sqlSession.update("cn.test.mybatis.UserMapper.updateUser", user);
        sqlSession.commit();
        //ִ��ɾ������
        System.out.println("ɾ����Ա��id=27");
        sqlSession.delete("cn.test.mybatis.UserMapper.deleteUser", 27);
        sqlSession.close();
               
    }
    
    @Test
    public void testMapperIn() throws IOException { 
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
        	User user=userMapper.findUserById(10);
        	System.out.println(user);
        }finally {
        	sqlSession.close();
        }
    }
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
        	//������������
        	List<User> users = new ArrayList<User>();
        	/*       	
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
        	*/
        	//�����ַ����滻
        	users = userMapper.findUserByParams("username", "����0");
        	for(User us : users) {
        		System.out.println(us);
        	}
        }finally {
        	sqlSession.close();
        }
    }
}
