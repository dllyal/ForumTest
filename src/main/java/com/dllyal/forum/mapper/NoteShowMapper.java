package com.dllyal.forum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dllyal.forum.model.NoteShow;
import org.springframework.stereotype.Service;

@Service("noteShowMapper")
public interface NoteShowMapper {
  
    /**
     * 根据tid获取整楼帖内容
     * @param tid
     * @return
     */
    public List<NoteShow> selectMainNotesByTid(Integer tid);
    
    /**
     * 根据tid和floor获取指定樓層的回復
     * @param tid , floor
     * @return
     */
    public List<NoteShow> selectBacksByTidAndFloor(@Param("tid") Integer tid, @Param("floor") Integer floor);
    
    /**
     * 根据uid获取user的普通发帖,不含本用户信息,state=0
     * @param uid
     * @return
     */
    public List<NoteShow> selectOnlyNotesByUid(Integer uid);
    
    /**
     * 根据uid获取user的普通发帖,不含本用户信息
     * @param uid
     * @return
     */
    public List<NoteShow> selectAllNotesByUid(Integer uid);
    
}