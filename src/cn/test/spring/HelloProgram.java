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
	        User user = new User("yiibai","男","上海市",new Timestamp(System.currentTimeMillis()));
	        hellospring.insertUser(user);
	    	
	        User User1 = hellospring.findUserById(1);
	        System.out.println(User1);
	        
	        Custom custom = (Custom) context.getBean("custom");
	    }
	
	@Test
	public void testDynamicProxy() {
//	    我们要代理的真实对象
        Subject subjectimpl = new SubjectImpl();

        //    我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler = new DynamicProxy(subjectimpl);

        /*
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
         * 第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         */
        Subject subject = (Subject)Proxy.newProxyInstance(handler.getClass().getClassLoader(), subjectimpl
                .getClass().getInterfaces(), handler);        
        System.out.println(subject.getClass().getName());
        subject.rent();
        subject.hello("world");
	}
}
