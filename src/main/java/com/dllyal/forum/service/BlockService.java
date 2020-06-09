package com.dllyal.forum.service;

import java.util.List;

import com.dllyal.forum.model.Block;

public interface BlockService {
	
	/**
	 * 读取全部板块信息,不含隐藏
	 * @return
	 */
	public List<Block> getBlocks();
	
	/**
	 * 读取全部板块信息
	 * @return
	 */
	public List<Block> getAllBlock();
	
	/**
	 * 读取板块信息byBid
	 * @param bid
	 * @return
	 */
	public Block getBlockByBid(Integer bid);
	
	/**
     * 更新板块信息
     * @param record
     * @return
     */
    public int updateBlock(Block record);
    
    /**
     * 添加板块
     * @param record
     * @return
     */
    public int setSelective(Block record);
    
    /**
	 * 软删除板块
	 * @param bid
	 * @return
	 */
	public int delBlockByBid(Integer bid);
	
	/**
	 * 恢复软删除的板块
	 * @param bid
	 * @return
	 */
	public int reBlockByBid(Integer bid);
}
