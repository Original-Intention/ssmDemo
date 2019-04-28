package cn.test.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

    //�������������Ҫ�������ʵ����
    private Object subject;
    
    //    ���췽����������Ҫ�������ʵ���󸳳�ֵ
    public DynamicProxy(Object subject)
    {
        this.subject = subject;
    }
    
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //�����ڴ�����ʵ����ǰ���ǿ������һЩ�Լ��Ĳ���        
        System.out.println("Method:" + method);
        
        //    ��������������ʵ����ķ���ʱ������Զ�����ת��������������handler�����invoke���������е���
        method.invoke(subject, args);
        
        //�����ڴ�����ʵ���������Ҳ�������һЩ�Լ��Ĳ���
        System.out.println("after rent house");
        
		return null;
	}

}
