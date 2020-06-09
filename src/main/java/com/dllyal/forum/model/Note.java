package com.dllyal.forum.model;

import java.util.Date;

public class Note {
 
    private Integer nid;

    private String name;

    private String ncontext;

    private Date createtime;

    private Date modifytime;

    private Integer uid;

    private Integer tid;

    private Integer fathernid;

    private Integer fatheruid;

    private Integer floor;

    private Integer state;

	public Note() {
		super();
	}

	public Note(Integer nid, String name, String ncontext, Date createtime, Date modifytime, Integer uid, Integer tid,
			Integer fathernid, Integer fatheruid, Integer floor, Integer state) {
		super();
		this.nid = nid;
		this.name = name;
		this.ncontext = ncontext;
		this.createtime = createtime;
		this.modifytime = modifytime;
		this.uid = uid;
		this.tid = tid;
		this.fathernid = fathernid;
		this.fatheruid = fatheruid;
		this.floor = floor;
		this.state = state;
	}

	public Integer getNid() {
		return nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNcontext() {
		return ncontext;
	}

	public void setNcontext(String ncontext) {
		this.ncontext = ncontext;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getFathernid() {
		return fathernid;
	}

	public void setFathernid(Integer fathernid) {
		this.fathernid = fathernid;
	}

	public Integer getFatheruid() {
		return fatheruid;
	}

	public void setFatheruid(Integer fatheruid) {
		this.fatheruid = fatheruid;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Note [nid=" + nid + ", name=" + name + ", ncontext=" + ncontext + ", createtime=" + createtime
				+ ", modifytime=" + modifytime + ", uid=" + uid + ", tid=" + tid + ", fathernid=" + fathernid
				+ ", fatheruid=" + fatheruid + ", floor=" + floor + ", state=" + state + "]";
	}

    
}