package com.dllyal.forum.service;

import java.util.List;

import com.dllyal.forum.model.Topic;
import com.dllyal.forum.model.TopicShow;

public interface TopicService {
	
	/**
	 * 根据tid获取楼的信息
	 * @return
	 */
	public TopicShow getTopicByTid(int tid);
	
	/**
	 * 根据bid获取板块内所有话题,以TopicShow类型返回,不含隐藏(删除)
	 * @return
	 */
	public List<TopicShow> getTopicsByBid(int bid);
    
    /**
     * 用户的主题帖//不含隐藏(删除)
     * @param uid
     * @return
     */
    public List<Topic> getTopicsByUid(int uid);
    
    /**
     * 用户的主题帖含隐藏
     * @param uid
     * @return
     */
    public List<Topic> getAllTopicsByUid(int uid);
    
    /**
	 * 软删除主题帖子 
	 * @param nid
	 * @return
	 */
	public int deleteTopicByTid(int tid);
	
	/**
	 * 恢复软删除主题帖子 
	 * @param nid
	 * @return
	 */
	public int reTopicByTid(int tid);
	
	/**
	 * 发表新的主题帖
	 * @param topic
	 * @return
	 */
	public int setNewTopic(Topic topic);
	
	/**
	 * 更新题帖子 时间
	 * @param nid
	 * @return
	 */
	public int updateTopictimeByTid(int tid);
	
	/**
	 * view+1
	 * @param nid
	 * @return
	 */
	public int updateTopicViewByTid(int tid);
}
