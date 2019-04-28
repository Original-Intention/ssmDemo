package cn.test.spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.sql.Timestamp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.test.spring.proxy.DynamicProxy;
import cn.test.spring.proxy.Subject;
import cn.test.spring.proxy.SubjectImpl;

public class HelloProgram {
	 
	public static void main(String[] args) {
         
	        @SuppressWarnings("resource")
			ApplicationContext context = new ClassPathXmlApplicationContext("cn/test/spring/beans.xml");
	         
	        HelloWorldService service = (HelloWorldService) context.getBean("helloWorldService");
	          
	        HelloWorld hw= service.getHelloWorld();
	         
	        hw.sayHello();
	        HelloSpringDAO hellospring = (HelloSpringDAO) context.getBean("helloSpring");
	        User user = new User("yiibai","��","�Ϻ���",new Timestamp(System.currentTimeMillis()));
	        hellospring.insertUser(user);
	    	
	        User User1 = hellospring.findUserById(1);
	        System.out.println(User1);
	        
	        Custom custom = (Custom) context.getBean("custom");
	    }
	
	@Test
	public void testDynamicProxy() {
//	    ����Ҫ�������ʵ����
        Subject subjectimpl = new SubjectImpl();

        //    ����Ҫ�����ĸ���ʵ���󣬾ͽ��ö��󴫽�ȥ�������ͨ������ʵ�����������䷽����
        InvocationHandler handler = new DynamicProxy(subjectimpl);

        /*
         * ͨ��Proxy��newProxyInstance�������������ǵĴ��������������������������
         * ��һ������ handler.getClass().getClassLoader() ����������ʹ��handler������ClassLoader�������������ǵĴ������
         * �ڶ�������realSubject.getClass().getInterfaces()����������Ϊ��������ṩ�Ľӿ�����ʵ������ʵ�еĽӿڣ���ʾ��Ҫ������Ǹ���ʵ���������Ҿ��ܵ�������ӿ��еķ�����
         * ����������handler�� �������ｫ������������������Ϸ��� InvocationHandler ���������
         */
        Subject subject = (Subject)Proxy.newProxyInstance(handler.getClass().getClassLoader(), subjectimpl
                .getClass().getInterfaces(), handler);        
        System.out.println(subject.getClass().getName());
        subject.rent();
        subject.hello("world");
	}
}
