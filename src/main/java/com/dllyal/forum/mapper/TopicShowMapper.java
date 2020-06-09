package com.dllyal.forum.mapper;

import java.util.List;

import com.dllyal.forum.model.TopicShow;
import org.springframework.stereotype.Service;

@Service("topicShowMapper")
public interface TopicShowMapper {
  
    /**
     * 根据tid获取话题信息
     * @param tid
     * @return
     */
    public TopicShow selectTopicByTid(Integer tid);
    
    /**
     * 根据bid获取话题列表
     * @param bid
     * @return
     */
    public List<TopicShow> selectTopicsByBid(Integer bid);
    
}