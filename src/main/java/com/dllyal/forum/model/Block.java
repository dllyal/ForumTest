package com.dllyal.forum.model;

import java.util.Date;

public class Block {
    private Integer bid;

    private String bname;

    private String bcontext;

    private String bpicsrc;

    private Date createtime;

    private Date modifytime;

    private String note;

    private Integer state;
    
    

    public Block() {
		super();
	}
    
    

	public Block(Integer bid, String bname, String bcontext, String bpicsrc, Date createtime, Date modifytime,
			String note, Integer state) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.bcontext = bcontext;
		this.bpicsrc = bpicsrc;
		this.createtime = createtime;
		this.modifytime = modifytime;
		this.note = note;
		this.state = state;
	}



	public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBcontext() {
        return bcontext;
    }

    public void setBcontext(String bcontext) {
        this.bcontext = bcontext;
    }

    public String getBpicsrc() {
        return bpicsrc;
    }

    public void setBpicsrc(String bpicsrc) {
        this.bpicsrc = bpicsrc;
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
		return "Block [bid=" + bid + ", bname=" + bname + ", bcontext=" + bcontext + ", bpicsrc=" + bpicsrc
				+ ", createtime=" + createtime + ", modifytime=" + modifytime + ", note=" + note + ", state=" + state
				+ "]";
	}
    
    
}