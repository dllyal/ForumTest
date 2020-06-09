package com.dllyal.forum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dllyal.forum.model.User;
import org.springframework.stereotype.Service;

@Service("userMapper")
public interface UserMapper {
    
    /**
     * 添加用户
     * @param record
     * @return
     */
	public int insertUser(User record);
    
    /**
     * 根据账号或昵称查找返回user
     * @param words
     * @return
     */
    public List<User> selectByLikeNameAccount(@Param("words") String words);
    
    /**
     * 查找账号个数
     * @param account
     * @return
     */
    public int selectAccountCount(@Param("account") String account);
    
    /**
     * 根据账号查找返回user
     * @param account
     * @return
     */
    public User selectUserByAccount(@Param("account") String account);
    
    /**
     * 根据uid查找返回user
     * @param uid
     * @return
     */
    public User selectByUid(Integer uid);
    
    /**
     * 更新
     * @param record
     * @return
     */
    public int updateByPrimaryKeySelective(User record);

}