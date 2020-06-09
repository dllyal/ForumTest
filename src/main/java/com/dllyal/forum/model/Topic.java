package com.dllyal.forum.model;

import java.util.Date;

public class Topic {
    private Integer tid;

    private String tname;

    private String tcontext;

    private Date createtime;

    private Date modifytime;
    
    private Integer bid;

    private Integer uid;

    private Integer viewnum;

    private String note;

    private Integer state;

    public Topic() {
		super();
	}

	public Topic(Integer tid, String tname, String tcontext, Date createtime, Date modifytime, Integer bid, Integer uid,
			Integer viewnum, String note, Integer state) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tcontext = tcontext;
		this.createtime = createtime;
		this.modifytime = modifytime;
		this.bid = bid;
		this.uid = uid;
		this.viewnum = viewnum;
		this.note = note;
		this.state = state;
	}
	
	

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTcontext() {
        return tcontext;
    }

    public void setTcontext(String tcontext) {
        this.tcontext = tcontext;
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

    public Integer getViewnum() {
        return viewnum;
    }

    public void setViewnum(Integer viewnum) {
        this.viewnum = viewnum;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

	@Override
	public String toString() {
		return "Topic [tid=" + tid + ", tname=" + tname + ", tcontext=" + tcontext + ", createtime=" + createtime
				+ ", modifytime=" + modifytime + ", bid=" + bid + ", uid=" + uid + ", viewnum=" + viewnum + ", note="
				+ note + ", state=" + state + "]";
	}
    
    
    
}