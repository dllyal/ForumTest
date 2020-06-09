package com.dllyal.forum.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dllyal.forum.mapper.UserMapper;
import com.dllyal.forum.model.User;
import com.dllyal.forum.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource(name="userMapper")  //通过注解扫描获得接口对象  - 代替了getMapper
	private UserMapper userMapper;
	
	@Override
	public int setUser(User record) {
		int result = 0;
		try {
			result = userMapper.insertUser(record);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int getAccountCount(String account) {
		int result = 0;
		result = userMapper.selectAccountCount(account);
		return result;
	}

	@Override
	public User login(String account) {
		User user = null;
		user = userMapper.selectUserByAccount(account);
		return user;
	}

	@Override
	public int updateUserInfo(User user) {
		int result = 0;
		try {
			result = userMapper.updateByPrimaryKeySelective(user);
		} catch (Exception e) {
			
		}
		return result;
	}

	@Override
	public List<User> getByLikeNameAccount(String words) {
		List<User> list = null;
		list = userMapper.selectByLikeNameAccount(words);
		return list;
	}

	@Override
	public User getByUid(Integer uid) {
		User user = null;
		user = userMapper.selectByUid(uid);
		return user;
	}

}
