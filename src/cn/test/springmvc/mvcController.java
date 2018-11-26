package cn.test.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
public class mvcController {

	@RequestMapping("/hello")
	public String hello(){        
	   return "hello";
	}
	@RequestMapping("/success")
	public String success(){        
	   return "success";
	}
	@RequestMapping("/error")
	public String error(){        
	   return "error";
	}
}
