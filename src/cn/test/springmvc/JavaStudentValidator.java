package cn.test.springmvc;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class JavaStudentValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub

	}
}
