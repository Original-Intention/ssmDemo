package cn.test.fanshe;

public class Fanshe {
	
	public static void main(String[] args) {
		//��һ�ַ�ʽ��ȡClass����  
		Student stu1 = new Student();//��һnew ����һ��Student����һ��Class����
		Class stuClass = stu1.getClass();//��ȡClass����
		System.out.println(stuClass.getName());
		
		//�ڶ��ַ�ʽ��ȡClass����
		Class stuClass2 = Student.class;
		System.out.println(stuClass == stuClass2);//�жϵ�һ�ַ�ʽ��ȡ��Class����͵ڶ��ַ�ʽ��ȡ���Ƿ���ͬһ��
		
		//�����ַ�ʽ��ȡClass����
		try {
			Class stuClass3 = Class.forName("cn.test.fanshe.Student");//ע����ַ�����������ʵ·�������Ǵ���������·��������.����
			System.out.println(stuClass3 == stuClass2);//�ж����ַ�ʽ�Ƿ��ȡ����ͬһ��Class����
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
