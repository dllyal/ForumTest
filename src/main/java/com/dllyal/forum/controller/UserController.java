package com.dllyal.forum.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dllyal.forum.model.User;
import com.dllyal.forum.service.UserService;

@Controller
@SessionAttributes({ "user" })
@RequestMapping(value = "user/")
public class UserController {

	@Resource(name = "userService")
	public UserService userService;

	// 跳转到登录
	@RequestMapping("tologin")
	public String tologin(Model model) {
		return "login";
	}

	// 跳转到注册
	@RequestMapping("toregister")
	public String toregister(Model model) {

		return "register";
	}

	// 登录
	@RequestMapping("login")
	public String login(String account, String password, Model model) {

		User user = null;

		user = userService.login(account);

		if (user == null) {
			model.addAttribute("msg", "登录失败--请确定账号和密码正确");
			return "login";
		}

		if (password.equals(user.getPassword())) {
			model.addAttribute("user", user);
			return "index";
		} else {
			model.addAttribute("msg", "登录失败--请确定账号和密码正确");
			return "login";
		}

	}

	public boolean findSession(HttpServletRequest request) {
		try {
			if (request.getSession(false).getAttribute("user") == null) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 注册
	@RequestMapping("register")
	public String register(User user, Model model) {

		int result = userService.setUser(user);

		model.addAttribute("result", result);

		return "index";
	}

	// 异步检查账号重复
	@RequestMapping(value = "AccountCount")
	public void backs(String account, HttpServletResponse response) throws IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		int countnum = userService.getAccountCount(account);

		//String aa = JsonUtil.object2json(countnum);

		/**
		 * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
		 * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
		 * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
		 * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
		 * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。
		 * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。
		 */
		ObjectMapper mapper = new ObjectMapper();
		String aa = mapper.writeValueAsString(countnum);


		System.out.println(aa);

		PrintWriter out = response.getWriter();
		out.println(aa);
		out.flush();
		out.close();
	}

}
