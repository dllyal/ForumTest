package com.dllyal.forum.mapper;

import java.util.List;

import com.dllyal.forum.model.Note;
import org.springframework.stereotype.Service;

@Service("noteMapper")
public interface NoteMapper {
	
	/**
	 * 添加主贴回复,即新楼层
	 * @param record
	 * @return
	 */
	public int insertMainNote(Note record);
	
	/**
	 * 添加回复to回复
	 * @param record
	 * @return
	 */
	public int insertNoteBack(Note record);
	
	/**
	 * 某用户的普通帖子 
	 * @param uid
	 * @return
	 */
	public List<Note> selectNotesByUid(Integer uid);
    
    /**
     * 根据tid获取楼内所有内容
     * @param tid
     * @return
     */
    public List<Note> selectNotesByTid(Integer tid);
    
    /**
     * 根据tid获取楼内所有回復内容
     * @param tid
     * @return
     */
    public List<Note> selectBacksByTid(Integer tid);
    
	/**
	 * 软删除帖子 
	 * @param nid
	 * @return
	 */
	public int updateDelNoteByNid(Integer nid);
	
	/**
	 * 恢复软删除帖子 
	 * @param nid
	 * @return
	 */
	public int updateReNoteByNid(Integer nid);
    
}