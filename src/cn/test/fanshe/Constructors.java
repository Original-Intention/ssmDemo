package cn.test.fanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Constructors {

	public static void main(String[] args) throws Exception {
		//1.����Class����
		Class clazz = Class.forName("cn.test.fanshe.Student");
		
		
		//2.��ȡ���й��й��췽��
		System.out.println("**********************���й��й��췽��*********************************");
		Constructor[] conArray = clazz.getConstructors();
		for(Constructor c : conArray){
			System.out.println(c);
		}
		
		
		System.out.println("************���еĹ��췽��(������˽�С��ܱ�����Ĭ�ϡ�����)***************");
		conArray = clazz.getDeclaredConstructors();
		for(Constructor c : conArray){
			System.out.println(c);
		}
		
		System.out.println("*****************��ȡ���С��޲εĹ��췽��*******************************");
		Constructor con = clazz.getConstructor(null);
		//1>����Ϊ���޲εĹ��췽������������һ��null,��дҲ���ԣ�������Ҫ����һ�����������ͣ��м�������
		//2>�����ص�����������޲ι��캯���������
	
		System.out.println("con = " + con);
		//���ù��췽��
		Object obj = con.newInstance();
	//	System.out.println("obj = " + obj);
	//	Student stu = (Student)obj;
		
		System.out.println("******************��ȡ˽�й��췽����������*******************************");
		con = clazz.getDeclaredConstructor(char.class);
		System.out.println(con);
		//���ù��췽��
		con.setAccessible(true);//��������(���Ե��������η�)
		obj = con.newInstance('��');
		
		
		//3.��ȡ���й����ֶ�
		System.out.println("************��ȡ���й��е��ֶ�********************");
		Field[] fieldArray = clazz.getFields();
		for(Field f : fieldArray){
			System.out.println(f);
		}
		System.out.println("************��ȡ���е��ֶ�(����˽�С��ܱ�����Ĭ�ϵ�)********************");
		fieldArray = clazz.getDeclaredFields();
		for(Field f : fieldArray){
			System.out.println(f);
		}
		System.out.println("*************��ȡ�����ֶ�**������***********************************");
		Field f = clazz.getField("name");
		System.out.println(f);
		//��ȡһ������
		Object obj_filed = clazz.getConstructor().newInstance();//����Student����--��Student stu = new Student();
		//Ϊ�ֶ�����ֵ
		f.set(obj_filed, "���»�");//ΪStudent�����е�name���Ը�ֵ--��stu.name = "���»�"
		//��֤
		Student stu = (Student)obj_filed;
		System.out.println("��֤������" + stu.name);
		
		
		System.out.println("**************��ȡ˽���ֶ�****������********************************");
		f = clazz.getDeclaredField("phoneNum");
		System.out.println(f);
		f.setAccessible(true);// �������䣬���˽���޶�
		f.set(obj, "18888889999");
		System.out.println("��֤�绰��" + stu);

		
		// 4.��ȡ���й��з���
		System.out.println("***************��ȡ���еġ����С�����*******************");
		clazz.getMethods();
		Method[] methodArray = clazz.getMethods();
		for (Method m : methodArray) {
			System.out.println(m);
		}
		System.out.println("***************��ȡ���еķ���������˽�е�*******************");
		methodArray = clazz.getDeclaredMethods();
		for (Method m : methodArray) {
			System.out.println(m);
		}
		System.out.println("***************��ȡ���е�show1()����*******************");
		Method m = clazz.getMethod("show1", String.class);
		System.out.println(m);
		// ʵ����һ��Student����
		Object obj_method = clazz.getConstructor().newInstance();
		m.invoke(obj_method, "���»�");

		System.out.println("***************��ȡ˽�е�show4()����******************");
		m = clazz.getDeclaredMethod("show4", int.class);
		System.out.println(m);
		m.setAccessible(true);// ���˽���޶�
		Object result = m.invoke(obj_method, 20);// ��Ҫ����������һ����Ҫ���õĶ��󣨻�ȡ�з��䣩��һ����ʵ��
		System.out.println("����ֵ��" + result);
		
	}

}
