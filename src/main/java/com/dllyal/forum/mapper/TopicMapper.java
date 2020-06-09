package com.dllyal.forum.mapper;

import java.util.List;

import com.dllyal.forum.model.Topic;
import org.springframework.stereotype.Service;

@Service("topicMapper")
public interface TopicMapper {
	
	/**
	 * 发表新的主题帖
	 * @param topic
	 * @return
	 */
	public int insertNewTopic(Topic topic);
	
    /**
     * 用户的主题帖//不含隐藏,即state=0
     * @param uid
     * @return
     */
    public List<Topic> selectTopicsByUid(Integer uid);
    
    /**
     * 用户的主题帖含隐藏
     * @param uid
     * @return
     */
    public List<Topic> selectAllTopicsByUid(Integer uid);
    
    /**
	 * 更新题帖子 时间
	 * @param tid
	 * @return
	 */
	public int updateTopictimeByTid(Integer tid);
	
	/**
	 * view+1
	 * @param tid
	 * @return
	 */
	public int updateTopicViewByTid(Integer tid);
    
    /**
	 * 软删除主题帖子 
	 * @param tid
	 * @return
	 */
	public int updateDelTopicByTid(Integer tid);
	
	/**
	 * 恢复软删除主题帖子 
	 * @param tid
	 * @return
	 */
	public int updateReTopicByTid(Integer tid);
}