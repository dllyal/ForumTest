package com.dllyal.forum.mapper;

import java.util.List;

import com.dllyal.forum.model.Block;
import org.springframework.stereotype.Service;

@Service("blockMapper")
public interface BlockMapper {
	
    /**
     * 添加
     * @param record
     * @return
     */
    public int insertSelective(Block record);
	
	/**
	 * 读取全部板块信息,不含隐藏
	 * @return
	 */
	public List<Block> selectBlocks();
	
	/**
	 * 读取全部板块信息
	 * @return
	 */
	public List<Block> selectAllBlock();
	
	/**
	 * 读取板块信息byBid
	 * @param bid
	 * @return
	 */
	public Block selectBlockByBid(Integer bid);
    
    /**
	 * 软删除板块
	 * @param bid
	 * @return
	 */
	public int updateDelBlockByBid(Integer bid);
	
	/**
	 * 恢复软删除的板块
	 * @param bid
	 * @return
	 */
	public int updateReBlockByBid(Integer bid);
    
    /**
     * 更新
     * @param record
     * @return
     */
    public int updateByPrimaryKeySelective(Block record);

}