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

import com.dllyal.forum.model.Block;
import com.dllyal.forum.model.NoteShow;
import com.dllyal.forum.model.Topic;
import com.dllyal.forum.model.User;
import com.dllyal.forum.service.BlockService;
import com.dllyal.forum.service.NoteService;
import com.dllyal.forum.service.TopicService;
import com.dllyal.forum.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value = "admin/")
public class AdminCenterController {

	@Resource(name = "userService")
	public UserService userService;

	@Resource(name = "noteService")
	public NoteService noteService;

	@Resource(name = "topicService")
	public TopicService topicService;
	
	@Resource(name = "blockService")
	public BlockService blockService;
	
	@RequestMapping("adminhome")
	public String adminHome(HttpServletRequest request, Model model) {

		if (!findSession(request)) {
			model.addAttribute("msg", "请登录");
			return "login";
		}

		User user = (User) request.getSession(false).getAttribute("user");
		int role = user.getRole();
		
		if (role<=0) {
			model.addAttribute("msg", "权限不足");
			return "index";
		}

		return "jsp/admin/adminHome";
	}
	
	@RequestMapping("adminuser")
	public String adminUser(String words,HttpServletRequest request,@RequestParam(required = true, defaultValue = "1") Integer page, Model model) {

		if (!findSession(request)) {
			model.addAttribute("msg", "请登录");
			return "login";
		}

		User user = (User) request.getSession(false).getAttribute("user");
		int role = user.getRole();
		
		if (role<=0) {
			model.addAttribute("msg", "权限不足");
			return adminUser("", request, 1, model);
		}
		if (words==null) {
			words="%%";
		}else {
			words = "%"+words+"%";
		}
		
		
		List<User> list = null;
		model.addAttribute("userlist", list);

		//这段代码表示，程序开始分页了，page默认值是1，每页记录数（pageSize）默认是3，意思是从第1页开始，每页显示3条记录
		//每页记录数可以自定义
		PageHelper.startPage(page, 8);
		
		list = userService.getByLikeNameAccount(words);
		
		
		PageInfo<User> pageInfo = new PageInfo<User>(list); //将集合封装到PageInfo
		//绑定数据，返回给页面
		model.addAttribute("p", pageInfo);
		

		return "jsp/admin/adminUser";
	}
	
	@RequestMapping("adminuserinfo")
	public String adminUserInfo(HttpServletRequest request,@RequestParam(required = true, defaultValue = "0") Integer userid, Model model) {

		if (!findSession(request)) {
			model.addAttribute("msg", "请登录");
			return "login";
		}

		User user = (User) request.getSession(false).getAttribute("user");
		int role = user.getRole();
		
		if (role<=0) {
			model.addAttribute("msg", "权限不足");
			return adminUser("", request, 1, model);
		}
		
		if (userid==0) {
			model.addAttribute("msg", "出现错误");
			return adminUser("", request, 1, model);
		}
		
		User theUser = new User();
		theUser = userService.getByUid(userid);
		
		
		model.addAttribute("theuser", theUser);
		

		return "jsp/admin/adminUserManage";
	}
	
	
	
	@RequestMapping("adminusernote")
	public String adminUserNote(HttpServletRequest request, String uid,
			@RequestParam(required = true, defaultValue = "1") Integer page, Model model) {
		if (!findSession(request)) {
			model.addAttribute("msg", "请登录");
			return "login";
		}
		User user = (User) request.getSession(false).getAttribute("user");
		int role = user.getRole();
		if (role<=0) {
			model.addAttribute("msg", "权限不足");
			return adminUser("", request, 1, model);
		}
		int uidnum = 0;
		try {
			uidnum = Integer.parseInt(uid);
		} catch (Exception e) {
			model.addAttribute("msg", "出现错误");
			return adminUser("", request, 1, model);
		}
		List<NoteShow> lastNotes = null;
		System.out.println("-----执行pagehelper分页控制器-----");
		PageHelper.startPage(page, 5);
		lastNotes = noteService.getAllNotesByUid(uidnum);
		try {
			String uname= userService.getByUid(uidnum).getUname();
			model.addAttribute("theusername", uname);			
		} catch (Exception e) {
			model.addAttribute("msg", "出现错误");
			return adminUser("", request, 1, model);
		}
		System.out.println(lastNotes);
		PageInfo<NoteShow> pageInfo = new PageInfo<NoteShow>(lastNotes); // 将集合封装到PageInfo
		// 绑定数据，返回给页面
		model.addAttribute("p", pageInfo);
		model.addAttribute("uid", uid);
		return "jsp/admin/adminUserNote";
	}
	
	@RequestMapping("adminusertopic")
	public String adminUserTopic(HttpServletRequest request, String uid,
			@RequestParam(required = true, defaultValue = "1") Integer page, Model model) {

		if (!findSession(request)) {
			model.addAttribute("msg", "请登录");
			return "login";
		}

		User user = (User) request.getSession(false).getAttribute("user");
		int role = user.getRole();
		
		if (role<=0) {
			model.addAttribute("msg", "权限不足");
			return adminUser("", request, 1, model);
		}
		
		int uidnum = 0;
		
		try {
			uidnum = Integer.parseInt(uid);
		} catch (Exception e) {
			model.addAttribute("msg", "出现错误");
			return adminUser("", request, 1, model);
		}
		
		List<Topic> listTopics = null;
		
		System.out.println("-----执行pagehelper分页控制器-----");
		// 这段代码表示，程序开始分页了，page默认值是1，每页记录数（pageSize）默认是3，意思是从第1页开始，每页显示3条记录
		// 每页记录数可以自定义
		PageHelper.startPage(page, 5);
		
		listTopics = topicService.getAllTopicsByUid(uidnum);
		
		try {
			String uname= userService.getByUid(uidnum).getUname();
			model.addAttribute("theusername", uname);			
		} catch (Exception e) {
			model.addAttribute("msg", "出现错误");
			return adminUser("", request, 1, model);
		}
		
		PageInfo<Topic> pageInfo = new PageInfo<Topic>(listTopics); // 将集合封装到PageInfo
		// 绑定数据，返回给页面
		model.addAttribute("p", pageInfo);
		model.addAttribute("uid", uid);

		return "jsp/admin/adminUserTopic";
	}

	
	@RequestMapping("adminuserupdate")
	public String adminUserUpdate(HttpServletRequest request,User theuser,Model model) {

		if (!findSession(request)) {
			model.addAttribute("msg", "请登录");
			return "login";
		}

		User user = (User) request.getSession(false).getAttribute("user");
		int role = user.getRole();
		
		if (role<=0) {
			model.addAttribute("msg", "权限不足");
			return adminUser("", request, 1, model);
		}
		
		int uid = theuser.getUid();
		String account = theuser.getAccount();
		if (uid<=0||account==null) {
			model.addAttribute("msg", "信息错误");
			model.addAttribute("theuser", theuser);
			return "jsp/admin/adminUserManage";
		}

		int result = 0;
		
		User newusUser = theuser;

		try {
			result = userService.updateUserInfo(theuser);
			if (result == 1) {
				newusUser = userService.login(account);			
				model.addAttribute("msg", "ok");
			} else {
				model.addAttribute("msg", "出现错误");
			}
		} catch (Exception e) {
			model.addAttribute("msg", "出现错误");
		}
		
		
		model.addAttribute("theuser", newusUser);
		model.addAttribute("user", user);
		
		return "jsp/admin/adminUserManage";
	}
	
	@RequestMapping("adminblock")
	public String adminBlock(HttpServletRequest request, Model model) {

		if (!findSession(request)) {
			model.addAttribute("msg", "请登录");
			return "login";
		}

		User user = (User) request.getSession(false).getAttribute("user");
		int role = user.getRole();
		
		if (role<=0) {
			model.addAttribute("msg", "权限不足");
			return "index";
		}

		return "jsp/admin/adminBlock";
	}
	
	@RequestMapping("adminblockinfo")
	public String adminBlockInfo(String bid,HttpServletRequest request, Model model) {

		if (!findSession(request)) {
			model.addAttribute("msg", "请登录");
			return "login";
		}

		User user = (User) request.getSession(false).getAttribute("user");
		int role = user.getRole();
		
		if (role<=0) {
			model.addAttribute("msg", "权限不足");
			return "index";
		}
		
		int bidnum=0;
		
		try {
			bidnum = Integer.parseInt(bid);
		} catch (Exception e) {
			model.addAttribute("msg", "出现错误");
			return "jsp/admin/adminBlock";
		}
		
		if (bidnum==0) {
			model.addAttribute("msg", "出现错误");
			return "jsp/admin/adminBlock";
		} else {
			Block block = null;
			block = blockService.getBlockByBid(bidnum);
			model.addAttribute("block", block);
		}

		return "jsp/admin/adminBlockManage";
	}
	
	@RequestMapping("adminblockupdate")
	public String adminBlockUpdate(HttpServletRequest request,Block theblock,Model model) {

		if (!findSession(request)) {
			model.addAttribute("msg", "请登录");
			return "login";
		}

		User user = (User) request.getSession(false).getAttribute("user");
		int role = user.getRole();
		
		if (role<=0) {
			model.addAttribute("msg", "权限不足");
			return adminUser("", request, 1, model);
		}
		
		int bid = theblock.getBid();
		String bname = theblock.getBname();
		String bcontext = theblock.getBcontext();
		if (bid<=0||bname==null||bcontext==null) {
			model.addAttribute("msg", "信息错误");
			model.addAttribute("block", theblock);
			return "jsp/admin/adminBlockManage";
		}

		int result = 0;

		try {
			result = blockService.updateBlock(theblock);
			if (result > 0) {
				model.addAttribute("msg", "ok");
			} else {
				model.addAttribute("msg", "出现错误");
			}
		} catch (Exception e) {
			model.addAttribute("msg", "出现错误");
		}
		
		model.addAttribute("block", theblock);
		
		return "jsp/admin/adminBlockManage";
	}
	
	@RequestMapping("adminblockadd")
	public String adminBlockAdd(HttpServletRequest request, Model model) {

		if (!findSession(request)) {
			model.addAttribute("msg", "请登录");
			return "login";
		}

		User user = (User) request.getSession(false).getAttribute("user");
		int role = user.getRole();
		
		if (role<=0) {
			model.addAttribute("msg", "权限不足");
			return "index";
		}

		return "jsp/admin/adminBlockNew";
	}
	
	@RequestMapping("adminblockaddsave")
	public String adminBlockAddSave(Block block,HttpServletRequest request, Model model) {

		if (!findSession(request)) {
			model.addAttribute("msg", "请登录");
			return "login";
		}

		User user = (User) request.getSession(false).getAttribute("user");
		int role = user.getRole();
		
		if (role<=0) {
			model.addAttribute("msg", "权限不足");
			return "index";
		}
		
		int result = 0;
		
		try {
			result = blockService.setSelective(block);
			if (result==0) {
				model.addAttribute("block", block);
				model.addAttribute("msg", "未成功");
				return "jsp/admin/adminBlockNew";
			} else {
				model.addAttribute("msg", "成功");
			}
		} catch (Exception e) {
			model.addAttribute("msg", "未成功");
			return "jsp/admin/adminBlockNew";
		}
		
		return "jsp/admin/adminBlock";
	}
	
	/**
	 * // 异步删除
	 * @param bidStr
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping(value = "admindelblock")
	public void adminDelBlock(String bidStr, HttpServletResponse response, HttpServletRequest request)
			throws IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		String aa = "0";

		if (!findSession(request)) {
			aa = "1";
		}

		int result = 0;
		int bid = 0;

		try {
			bid = Integer.parseInt(bidStr);
			result = blockService.delBlockByBid(bid);

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

	/**
	 * // 异步恢复
	 * @param bidStr
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping(value = "adminreblock")
	public void adminReBlock(String bidStr, HttpServletResponse response, HttpServletRequest request)
			throws IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		String aa = "0";

		if (!findSession(request)) {
			aa = "1";
		}

		int result = 0;
		int bid = 0;

		try {
			bid = Integer.parseInt(bidStr);
			result = blockService.reBlockByBid(bid);

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

	@InitBinder
	public void initBinder(WebDataBinder databinder) {
		databinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
