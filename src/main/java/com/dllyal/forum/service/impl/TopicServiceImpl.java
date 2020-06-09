package com.dllyal.forum.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dllyal.forum.mapper.TopicMapper;
import com.dllyal.forum.mapper.TopicShowMapper;
import com.dllyal.forum.model.Topic;
import com.dllyal.forum.model.TopicShow;
import com.dllyal.forum.service.TopicService;

@Service("topicService")
public class TopicServiceImpl implements TopicService{
	
	@Resource(name="topicShowMapper")  //通过注解扫描获得接口对象  - 代替了getMapper
	private TopicShowMapper topicShowMapper;
	
	@Resource(name="topicMapper")
	private TopicMapper topicMapper;
	
	@Override
	public TopicShow getTopicByTid(int tid) {
		return topicShowMapper.selectTopicByTid(tid);
	}

	@Override
	public List<TopicShow> getTopicsByBid(int bid) {
		return topicShowMapper.selectTopicsByBid(bid);
	}

	@Override
	public List<Topic> getTopicsByUid(int uid) {
		return topicMapper.selectTopicsByUid(uid);
	}
	
	@Override
	public List<Topic> getAllTopicsByUid(int uid) {
		return topicMapper.selectAllTopicsByUid(uid);
	}

	@Override
	public int deleteTopicByTid(int tid) {
		return topicMapper.updateDelTopicByTid(tid);
	}
	
	@Override
	public int reTopicByTid(int tid) {
		return topicMapper.updateReTopicByTid(tid);
	}

	@Override
	public int setNewTopic(Topic topic) {
		return topicMapper.insertNewTopic(topic);
	}

	@Override
	public int updateTopictimeByTid(int tid) {
		return topicMapper.updateTopictimeByTid(tid);
	}

	@Override
	public int updateTopicViewByTid(int tid) {
		return topicMapper.updateTopicViewByTid(tid);
	}

}
