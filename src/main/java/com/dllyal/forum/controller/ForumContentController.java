package com.dllyal.forum.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dllyal.forum.model.Block;
import com.dllyal.forum.model.Note;
import com.dllyal.forum.model.NoteShow;
import com.dllyal.forum.model.Topic;
import com.dllyal.forum.model.TopicShow;
import com.dllyal.forum.model.User;
import com.dllyal.forum.service.BlockService;
import com.dllyal.forum.service.NoteService;
import com.dllyal.forum.service.TopicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value = "forum/")
public class ForumContentController {

	@Resource(name = "blockService")
	public BlockService blockService;
	
	@Resource(name="topicService")
	public TopicService topicService;
	
	@Resource(name="noteService")
	public NoteService noteService;

	/**
	 * // 异步获取全部，不含隐藏
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "getblocks")
	public void getBlocks(HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		List<Block> list = blockService.getBlocks();
		//String list_String = JsonUtil.list2json(list);
		ObjectMapper mapper = new ObjectMapper();
		String list_String = mapper.writeValueAsString(list);
		System.out.println(list_String);
		PrintWriter out = response.getWriter();
		out.println(list_String);
		out.flush();
		out.close();
	}

	/**
	 * // 异步获取全部,含隐藏
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "getallblock")
	public void getAllBlock(HttpServletResponse response) throws IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		List<Block> list = blockService.getAllBlock();

		//String list_String = JsonUtil.list2json(list);
		ObjectMapper mapper = new ObjectMapper();
		String list_String = mapper.writeValueAsString(list);

		System.out.println(list_String);

		PrintWriter out = response.getWriter();
		out.println(list_String);
		out.flush();
		out.close();
	}

	
	/****************************/
	
	/**
	 * 读某板块的所有主题,不含隐藏,得到TopicShow的类型集合
	 * @param bid
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("getTopics")
	public String getTopics(String bid, @RequestParam(required=true,defaultValue="1") Integer page , Model model){
		int bidnum = Integer.parseInt(bid);
		//这段代码表示，程序开始分页了，（页码，每页条数）
		//每页记录数可以自定义
		PageHelper.startPage(page, 6);	
		List<TopicShow> topics = topicService.getTopicsByBid(bidnum);
		PageInfo<TopicShow> pageInfo = new PageInfo<TopicShow>(topics); //将集合封装到PageInfo
		//绑定数据，返回给页面
		model.addAttribute("p", pageInfo);
		try {
			Block block = new Block();
			block = blockService.getBlockByBid(Integer.parseInt(bid));
			model.addAttribute("block", block);
		} catch (Exception e) {
			model.addAttribute("msg", "读取出错");
		}
		model.addAttribute("bid", bid);
		return "jsp/forum/topics";
	}
	
	/**
	 * 发表新的主题帖子
	 * @param tname
	 * @param editor
	 * @param bid
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("setnewtopic")
	public void setNewTopic(String tname,String editor,String bid,HttpServletResponse response,HttpServletRequest request) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String outString = "0";
		if (!findSession(request)) {
			//("msg", "请先登录");
			outString = "1";
		}else {
			int bidnum = 0;
			Topic topic = new Topic();
			try {
				bidnum = Integer.parseInt(bid);
				User user = (User) request.getSession(false).getAttribute("user");
				int uid = user.getUid();
				topic.setTname(tname);
				topic.setTcontext(editor);
				topic.setBid(bidnum);
				topic.setUid(uid);
			} catch (Exception e) {
				//("msg", "出现错误");
				outString = "2";
			}
			int result = 0;
			try {
				result = topicService.setNewTopic(topic);
			} catch (Exception e) {
				//("msg", "出现错误");
				outString = "2";
			}
			if (result==0) {
				//("msg", "失败");
				outString = "2";
			}
		}
		PrintWriter out = response.getWriter();
		out.println(outString);
		out.flush();
		out.close();
	}
	
	/***************************/
	
	/**
	 * 读话题整楼,根据tid
	 * @param tid
	 * @param view
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("readfloors")
	public String getFloors(String tid ,@RequestParam(required=true,defaultValue="1") String view,@RequestParam(required=true,defaultValue="1") Integer page , Model model){
		
		int tidnum = Integer.parseInt(tid);
		
		TopicShow topic = topicService.getTopicByTid(tidnum);
		
		if (view.equals("0")) {
			//阅读量+1
			topicService.updateTopicViewByTid(tidnum);
		}
		
		List<NoteShow> notes=null;
		
		System.out.println("-----执行pagehelper分页控制器-----");

		PageHelper.startPage(page, 8);
		
		notes = noteService.getMainNotesByTid(tidnum);
		System.out.println(notes);
		
		PageInfo<NoteShow> pageInfo = new PageInfo<NoteShow>(notes);

		model.addAttribute("p", pageInfo);

		model.addAttribute("topic", topic);
		
		model.addAttribute("tid", tid);
		
		return "jsp/forum/floors";
	}
	
	/**
	 * 添加新的主楼层ajax
	 * @param editor
	 * @param tid
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("setnewfloor")
	public void setNewFloor(String editor,String tid,HttpServletResponse response,HttpServletRequest request) throws IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String outString = "0";
		
		if (!findSession(request)) {
			//("msg", "请先登录");
			outString = "1";
		}else {
			int tidnum = 0;
			Note note = new Note();
			
			try {
				tidnum = Integer.parseInt(tid);
				
				User user = (User) request.getSession(false).getAttribute("user");
				int uid = user.getUid();

				note.setNcontext(editor);
				note.setUid(uid);
				note.setTid(tidnum);
				note.setFathernid(0);
				note.setFatheruid(uid);
				
			} catch (Exception e) {
				//("msg", "出现错误");
				outString = "2";
			}
	
			int result = 0;
			
			try {
				result = noteService.setMainNote(note);
				topicService.updateTopictimeByTid(tidnum);
			} catch (Exception e) {
				//("msg", "出现错误");
				outString = "2";
			}
			
			if (result==0) {
				//("msg", "失败");
				outString = "2";
			}
		}

		PrintWriter out = response.getWriter();
		out.println(outString);
		out.flush();
		out.close();
	}
	
	
	/**
	 * 异步获取某层回复,根据tidStr和floorStr定位楼层位置
	 * @param tidStr
	 * @param floorStr
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="getbacks")
	public void getBacks(String tidStr,String floorStr,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		int tid = Integer.parseInt(tidStr);
		int floor = Integer.parseInt(floorStr);
		List<NoteShow> list = noteService.getBacksByTidAndFloor(tid, floor);
		//String list_String = JsonUtil.list2json(list);
		ObjectMapper mapper = new ObjectMapper();
		String list_String = mapper.writeValueAsString(list);
		PrintWriter out = response.getWriter();
		out.println(list_String);
		out.flush();
		out.close();
	}
	
	/**
	 * 添加楼层内的回复
	 * @param editor
	 * @param tid
	 * @param fathernid
	 * @param fatheruid
	 * @param floor
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("setback")
	public void setBack(String editor,String tid,String fathernid,String fatheruid,String floor,HttpServletResponse response,HttpServletRequest request) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String outString = "0";
		if (!findSession(request)) {
			//("msg", "请先登录");
			outString = "1";
		}else {
			int tidnum = 0;
			int fathernidnum = 0;
			int fatheruidnum = 0;
			int floornum = 0;
			Note note = new Note();
			try {
				tidnum = Integer.parseInt(tid);
				fathernidnum = Integer.parseInt(fathernid);
				fatheruidnum = Integer.parseInt(fatheruid);
				floornum = Integer.parseInt(floor);	
				User user = (User) request.getSession(false).getAttribute("user");
				int uid = user.getUid();
				note.setNcontext(editor);
				note.setUid(uid);
				note.setTid(tidnum);
				note.setFathernid(fathernidnum);
				note.setFatheruid(fatheruidnum);
				note.setFloor(floornum);		
			} catch (Exception e) {
				//("msg", "出现错误");
				outString = "2";
			}
			int result = 0;
			try {
				if (tidnum==0||fathernidnum==0||fatheruidnum==0||floornum==0) {
					outString = "2";
				}else {
					result = noteService.setNoteBack(note);
					topicService.updateTopictimeByTid(tidnum);
				}
			} catch (Exception e) {
				//("msg", "出现错误");
				outString = "2";
			}
			if (result==0) {
				//("msg", "失败");
				outString = "2";
			}
		}
		PrintWriter out = response.getWriter();
		out.println(outString);
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

}
