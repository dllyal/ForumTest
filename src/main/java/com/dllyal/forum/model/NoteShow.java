package com.dllyal.forum.model;

import java.util.Date;

public class NoteShow {
	private int nid;
	private int uid;
	private String uname;
	private String upicsrc="img/defaultuserpic.jpg";
	private String sign;
	private String name;
	private String ncontext;
	private Date createtime;
	private Date modifytime;
	private int floor;
	private int fathernid;
	private int fatheruid;
	private String fatheruname;
	private int tid;
	private int backnum;
	private int state;
	
	public NoteShow() {
		super();
	}

	

	public NoteShow(int nid, int uid, String uname, String upicsrc, String sign, String name, String ncontext,
			Date createtime, Date modifytime, int floor, int fathernid, int fatheruid, String fatheruname, int tid,
			int backnum, int state) {
		super();
		this.nid = nid;
		this.uid = uid;
		this.uname = uname;
		this.upicsrc = upicsrc;
		this.sign = sign;
		this.name = name;
		this.ncontext = ncontext;
		this.createtime = createtime;
		this.modifytime = modifytime;
		this.floor = floor;
		this.fathernid = fathernid;
		this.fatheruid = fatheruid;
		this.fatheruname = fatheruname;
		this.tid = tid;
		this.backnum = backnum;
		this.state = state;
	}



	public int getState() {
		return state;
	}



	public void setState(int state) {
		this.state = state;
	}



	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpicsrc() {
		return upicsrc;
	}

	public void setUpicsrc(String upicsrc) {
		this.upicsrc = upicsrc;
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

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getFathernid() {
		return fathernid;
	}

	public void setFathernid(int fathernid) {
		this.fathernid = fathernid;
	}

	public int getFatheruid() {
		return fatheruid;
	}

	public void setFatheruid(int fatheruid) {
		this.fatheruid = fatheruid;
	}

	public String getFatheruname() {
		return fatheruname;
	}

	public void setFatheruname(String fatheruname) {
		this.fatheruname = fatheruname;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getBacknum() {
		return backnum;
	}

	public void setBacknum(int backnum) {
		this.backnum = backnum;
	}



	@Override
	public String toString() {
		return "NoteShow [nid=" + nid + ", uid=" + uid + ", uname=" + uname + ", upicsrc=" + upicsrc + ", sign=" + sign
				+ ", name=" + name + ", ncontext=" + ncontext + ", createtime=" + createtime + ", modifytime="
				+ modifytime + ", floor=" + floor + ", fathernid=" + fathernid + ", fatheruid=" + fatheruid
				+ ", fatheruname=" + fatheruname + ", tid=" + tid + ", backnum=" + backnum + ", state=" + state + "]";
	}
	
	
	
}
