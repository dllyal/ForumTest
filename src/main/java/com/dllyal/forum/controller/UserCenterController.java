package com.dllyal.forum.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dllyal.forum.model.Note;
import com.dllyal.forum.model.NoteShow;
import com.dllyal.forum.model.Topic;
import com.dllyal.forum.model.User;
import com.dllyal.forum.service.NoteService;
import com.dllyal.forum.service.TopicService;
import com.dllyal.forum.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@SessionAttributes({ "user" })
@RequestMapping(value = "theuser/")
public class UserCenterController {

	@Resource(name = "userService")
	public UserService userService;

	@Resource(name = "noteService")
	public NoteService noteService;

	@Resource(name = "topicService")
	public TopicService topicService;

	public List<Note> getNotesByUid(int uid) {
		List<Note> notes = null;
		notes = noteService.getNotesByUid(uid);
		return notes;
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

	@RequestMapping("userhome")
	public String userHome(HttpServletRequest request, Model model) {

		if (!findSession(request)) {
			model.addAttribute("msg", "请登录");
			return "login";
		}

		User user = (User) request.getSession(false).getAttribute("user");
		int uid = user.getUid();
		System.out.println("****************");
		System.out.println(uid);

		// 最近主题帖
		List<Topic> lastNotes = null;

		int page = 1;

		System.out.println("-----执行pagehelper分页控制器-----");

		PageHelper.startPage(page, 5);

		lastNotes = topicService.getTopicsByUid(uid);

		PageInfo<Topic> pageInfo = new PageInfo<Topic>(lastNotes); 

		model.addAttribute("p", pageInfo);

		return "jsp/user/userHome";
	}

	@RequestMapping("usernotes")
	public String userNotesHome(HttpServletRequest request,
			@RequestParam(required = true, defaultValue = "1") Integer page, Model model) {

		if (!findSession(request)) {
			model.addAttribute("msg", "请登录");
			return "login";
		}

		User user = (User) request.getSession(false).getAttribute("user");
		int uid = user.getUid();

		List<NoteShow> lastNotes = null;

		System.out.println("-----执行pagehelper分页控制器-----");

		PageHelper.startPage(page, 6);

		lastNotes = noteService.getOnlyNotesByUid(uid);
		PageInfo<NoteShow> pageInfo = new PageInfo<NoteShow>(lastNotes); // 将集合封装到PageInfo
		// 绑定数据，返回给页面
		model.addAttribute("p", pageInfo);

		return "jsp/user/userNoteManage";
	}

	// 异步删除帖子
	@RequestMapping(value = "userdelnote")
	public void userDelNote(String nidStr, HttpServletResponse response, HttpServletRequest request)
			throws IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		String aa = "0";

		if (!findSession(request)) {
			aa = "1";
		}

		int result = 0;
		int nid = 0;

		try {
			nid = Integer.parseInt(nidStr);
			result = noteService.deleteNoteByNid(nid);
			if (result != 0) {
				aa = "2";
			}
		} catch (Exception e) {
			//
		}
		PrintWriter out = response.getWriter();
		out.println(aa);
		out.flush();
		out.close();
	}

	// 异步恢复删除帖子
	@RequestMapping(value = "userrenote")
	public void userReNote(String nidStr, HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		String aa = "0";

		if (!findSession(request)) {
			aa = "1";
		}

		int result = 0;
		int nid = 0;

		try {
			nid = Integer.parseInt(nidStr);
			result = noteService.reNoteByNid(nid);
			if (result != 0) {
				aa = "2";
			}
		} catch (Exception e) {
			//
		}
		PrintWriter out = response.getWriter();
		out.println(aa);
		out.flush();
		out.close();
	}

	@RequestMapping("usertopics")
	public String userTopicsHome(HttpServletRequest request,
			@RequestParam(required = true, defaultValue = "1") Integer page, Model model) {

		if (!findSession(request)) {
			model.addAttribute("msg", "请登录");
			return "login";
		}

		User user = (User) request.getSession(false).getAttribute("user");
		int uid = user.getUid();

		List<Topic> Topics = null;

		System.out.println("-----执行pagehelper分页控制器-----");

		PageHelper.startPage(page, 6);

		Topics = topicService.getTopicsByUid(uid);

		PageInfo<Topic> pageInfo = new PageInfo<Topic>(Topics); // 将集合封装到PageInfo
		// 绑定数据，返回给页面
		model.addAttribute("p", pageInfo);

		return "jsp/user/userTopicManage";
	}

	// 异步删除主题帖
	@RequestMapping(value = "userdeltopic")
	public void userDelTopic(String tidStr, HttpServletResponse response, HttpServletRequest request)
			throws IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		String aa = "0";

		if (!findSession(request)) {
			aa = "1";
		}

		int result = 0;
		int tid = 0;

		try {
			tid = Integer.parseInt(tidStr);
			result = topicService.deleteTopicByTid(tid);

			System.out.println("****************************" + result);
			if (result != 0) {
				aa = "2";
			}
		} catch (Exception e) {
			//
		}
		PrintWriter out = response.getWriter();
		out.println(aa);
		out.flush();
		out.close();
	}

	// 异步恢复主题帖
	@RequestMapping(value = "userretopic")
	public void userReTopic(String tidStr, HttpServletResponse response, HttpServletRequest request)
			throws IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		String aa = "0";

		if (!findSession(request)) {
			aa = "1";
		}

		int result = 0;
		int tid = 0;

		try {
			tid = Integer.parseInt(tidStr);
			result = topicService.reTopicByTid(tid);

			System.out.println("****************************" + result);
			if (result != 0) {
				aa = "2";
			}
		} catch (Exception e) {
			//
		}
		PrintWriter out = response.getWriter();
		out.println(aa);
		out.flush();
		out.close();
	}

	@RequestMapping("userinfo")
	public String userInfo(HttpServletRequest request, Model model) {

		if (!findSession(request)) {
			model.addAttribute("msg", "请登录");
			return "login";
		}

		return "jsp/user/userInfoManage";
	}

	@RequestMapping("userupdate")
	public String userUpdate(HttpServletRequest request, String upicsrc, String uname, String sex, Date birthday,
			String phone, String sign, String note, Model model) {

		if (!findSession(request)) {
			model.addAttribute("msg", "请登录");
			return "login";
		}
		User olduser = (User) request.getSession(false).getAttribute("user");
		String account = olduser.getAccount();

		User newuser = olduser;
		newuser.setUpicsrc(upicsrc);
		newuser.setUname(uname);
		newuser.setSex(sex);
		newuser.setBirthday(birthday);
		newuser.setPhone(phone);
		newuser.setSign(sign);
		newuser.setNote(note);

		int result = 0;

		try {
			result = userService.updateUserInfo(newuser);
			if (result == 1) {
				olduser = userService.login(account);
				model.addAttribute("msg", "ok");
				return "jsp/user/userInfoManage";
			} else {
				model.addAttribute("msg", "出现错误");
			}
		} catch (Exception e) {
			model.addAttribute("msg", "出现错误");
		}

		return "jsp/user/userInfoManage";
	}

	@RequestMapping("pwdupdate")
	public String pwdUpdate(HttpServletRequest request, String oldpassword, String newpassword1, String newpassword2,
			Model model) {

		if (!findSession(request)) {
			model.addAttribute("msg", "请登录");
			return "login";
		}
		User olduser = (User) request.getSession(false).getAttribute("user");

		String sessionpwd = olduser.getPassword();

		if (!sessionpwd.equals(oldpassword)) {
			model.addAttribute("msg", "原密码错误");
			return "jsp/user/userInfoManage";
		}

		if ((newpassword1.equals(null)) || (!newpassword1.equals(newpassword2))) {
			model.addAttribute("msg", "输入错误");
			return "jsp/user/userInfoManage";
		}

		User user = olduser;

		user.setPassword(newpassword1);

		int result = 0;

		try {
			result = userService.updateUserInfo(user);
			if (result == 1) {
				model.addAttribute("msg", "成功，请重新登录");
				request.getSession(false).removeAttribute("user");
				return "login";
			} else {
				model.addAttribute("msg", "出现错误");
			}
		} catch (Exception e) {
			model.addAttribute("msg", "出现错误");
		}

		return "jsp/user/userInfoManage";
	}

	// 注销
	@RequestMapping("logout")
	public String logout(HttpServletRequest request, Model model) {
		model.addAttribute("msg", "已退出");
		request.getSession(false).removeAttribute("user");
		return "index";
	}

	@InitBinder
	public void initBinder(WebDataBinder databinder) {
		databinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
