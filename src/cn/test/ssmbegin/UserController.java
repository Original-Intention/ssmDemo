package cn.test.ssmbegin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.test.mybatis.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/findAllUser")
	public String findAllUser(HttpServletRequest request){
		List<User> listUser =  userService.findAllUser();
		request.setAttribute("listUser", listUser);
		return "/allUser";
	 }
}
