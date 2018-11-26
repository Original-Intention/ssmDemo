package cn.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AFilter implements Filter {

	public void init(FilterConfig fc) throws ServletException{
		System.out.println("拦截器被创建！");
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("A过滤器执行拦截!");
		arg2.doFilter(arg0, arg1);
		System.out.println("A过滤器拦截完成!");
		
	}
	public void destory() {
		System.out.println("拦截器被销毁!");
	}

}
