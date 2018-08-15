package net.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginC {
	@Autowired
	private LoginDao dao;

	// 普通登录
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(String username, String pwd) {
		String me = "登录失败";
		Login login = new Login();
		login.setUsername(username);
		login.setPwd(pwd);
		login = dao.login(login);
		ModelAndView modelAndView = new ModelAndView();
		if (login == null) {
			me = "登录失败！";
			modelAndView.setViewName("failed");// 跳转页面
		} else {
			me = "登录成功！";
			modelAndView.setViewName("success");// 跳转页面
		}
		modelAndView.addObject("message", me);
		return modelAndView;
	}

	// jquery登录
	@RequestMapping(value = "/loginJquery")
	public ModelAndView loginJquery(String username, String pwd) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("jquery");// 跳转页面
		modelAndView.addObject("message", "ok");
		modelAndView.addObject("message2", "qwe");
		return modelAndView;
	}
}
