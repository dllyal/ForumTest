package com.dllyal.forum.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dllyal.forum.mapper.NoteMapper;
import com.dllyal.forum.mapper.NoteShowMapper;
import com.dllyal.forum.model.Note;
import com.dllyal.forum.model.NoteShow;
import com.dllyal.forum.service.NoteService;

@Service("noteService")
public class NoteServiceImpl implements NoteService{
	
	@Resource(name="noteMapper")
	private NoteMapper noteMapper;
	
	@Resource(name="noteShowMapper")
	private NoteShowMapper noteShowMapper;

	@Override
	public List<NoteShow> getMainNotesByTid(Integer tid) {
		return noteShowMapper.selectMainNotesByTid(tid);
	}

	@Override
	public List<NoteShow> getBacksByTidAndFloor(Integer tid, Integer floor) {
		return noteShowMapper.selectBacksByTidAndFloor(tid, floor);
	}

	@Override
	public List<Note> getNotesByUid(int uid) {
		return noteMapper.selectNotesByUid(uid);
	}

	@Override
	public List<NoteShow> getOnlyNotesByUid(int uid) {
		return noteShowMapper.selectOnlyNotesByUid(uid);
	}

	@Override
	public int deleteNoteByNid(int nid) {
		int result = 0;
		try {
			result = noteMapper.updateDelNoteByNid(nid);
		} catch (Exception e) {
			
		}
		return result;
	}
	
	@Override
	public int reNoteByNid(int nid) {
		int result = 0;
		try {
			result = noteMapper.updateReNoteByNid(nid);
		} catch (Exception e) {
			
		}
		return result;
	}

	@Override
	public int setMainNote(Note note) {
		int result = 0;
		try {
			result = noteMapper.insertMainNote(note);
		} catch (Exception e) {
			
		}
		return result;
	}

	@Override
	public int setNoteBack(Note note) {
		int result = 0;
		try {
			result = noteMapper.insertNoteBack(note);
		} catch (Exception e) {
			
		}
		return result;
	}

	@Override
	public List<NoteShow> getAllNotesByUid(Integer uid) {
		return noteShowMapper.selectAllNotesByUid(uid);
	}
	
	
}
