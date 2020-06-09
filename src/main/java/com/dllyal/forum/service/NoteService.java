package com.dllyal.forum.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dllyal.forum.model.Note;
import com.dllyal.forum.model.NoteShow;

public interface NoteService {
	
	/**
     * 根据uid获取user的普通发帖,不含本用户信息
     * @param uid
     * @return
     */
    public List<NoteShow> getAllNotesByUid(Integer uid);
	
	/**
	 * 某用户的普通帖子 
	 * @param uid
	 * @return
	 */
	public List<Note> getNotesByUid(int uid);
	
	/**
     * 根据tid获取主楼内容
     * @param tid
     * @return
     */
    public List<NoteShow> getMainNotesByTid(Integer tid);
    
    /**
     * 根据tid和floor获取指定樓層的回復
     * @param tid , floor
     * @return
     */
    public List<NoteShow> getBacksByTidAndFloor(@Param("tid") Integer tid, @Param("floor") Integer floor);
	
	/**
     * 根据uid获取user的普通发帖,不含本用户信息
     * @param uid
     * @return
     */
    public List<NoteShow> getOnlyNotesByUid(int uid);
    
    /**
	 * 软删除帖子 
	 * @param nid
	 * @return
	 */
	public int deleteNoteByNid(int nid);
	
	/**
	 * 恢复软删除帖子 
	 * @param nid
	 * @return
	 */
	public int reNoteByNid(int nid);
	
	/**
	 * 添加主贴回复
	 * @param note
	 * @return
	 */
	public int setMainNote(Note note);
	
	/**
	 * 添加回复to回复
	 * @param record
	 * @return
	 */
	public int setNoteBack(Note note);
}
