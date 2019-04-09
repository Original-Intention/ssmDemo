package cn.test.spring;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.test.spring.User;

public class HelloProgram {
	 
	public static void main(String[] args) {
         
	        @SuppressWarnings("resource")
			ApplicationContext context = new ClassPathXmlApplicationContext("cn/test/spring/beans.xml");
	         
	        HelloWorldService service = (HelloWorldService) context.getBean("helloWorldService");
	          
	        HelloWorld hw= service.getHelloWorld();
	         
	        hw.sayHello();
	        HelloSpringDAO hellospring = (HelloSpringDAO) context.getBean("helloSpring");
	        User user = new User("yiibai","ÄÐ","ÉÏº£ÊÐ",new Timestamp(System.currentTimeMillis()));
	        hellospring.insertUser(user);
	    	
	        User User1 = hellospring.findUserById(1);
	        System.out.println(User1);
	        
	        Custom custom = (Custom) context.getBean("custom");
	    }
}
