package cn.test.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloProgram {
	 
	public static void main(String[] args) {
         
	        ApplicationContext context = new ClassPathXmlApplicationContext("cn/test/spring/beans.xml");
	         
	        HelloWorldService service = (HelloWorldService) context.getBean("helloWorldService");
	          
	        HelloWorld hw= service.getHelloWorld();
	         
	        hw.sayHello();
	    }
}
