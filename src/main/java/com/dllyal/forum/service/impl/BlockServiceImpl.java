package com.dllyal.forum.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dllyal.forum.mapper.BlockMapper;
import com.dllyal.forum.model.Block;
import com.dllyal.forum.service.BlockService;

@Service("blockService")
public class BlockServiceImpl implements BlockService{
	
	@Resource(name="blockMapper")
	private BlockMapper blockMapper;

	@Override
	public List<Block> getBlocks() {
		return blockMapper.selectBlocks();
	}
	
	@Override
	public List<Block> getAllBlock() {
		return blockMapper.selectAllBlock();
	}

	@Override
	public Block getBlockByBid(Integer bid) {
		return blockMapper.selectBlockByBid(bid);
	}

	@Override
	public int updateBlock(Block record) {
		int result = 0;
		result = blockMapper.updateByPrimaryKeySelective(record);
		return result;
	}

	@Override
	public int setSelective(Block record) {
		int result = 0;
		result = blockMapper.insertSelective(record);
		return result;
	}

	@Override
	public int delBlockByBid(Integer bid) {
		int result = 0;
		result = blockMapper.updateDelBlockByBid(bid);
		return result;
	}

	@Override
	public int reBlockByBid(Integer bid) {
		int result = 0;
		result = blockMapper.updateReBlockByBid(bid);
		return result;
	}

}
