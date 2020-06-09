package com.dllyal.forum.model;

import java.util.Date;

public class TopicShow {
    private Integer tid;

    private String tname;

    private String tcontext;

    private Date createtime;

    private Date modifytime;
    
    private Integer bid;
    
    private Integer viewnum;
    
    private Integer backnum;
    
    private String note;

    private Integer uid;
    
    private String uname;
    
    private String upicsrc;
    
    private String sign;
    
    private Integer state;
    
    public TopicShow() {
		super();
	}
	
	public TopicShow(Integer tid, String tname, String tcontext, Date createtime, Date modifytime, Integer bid,
			Integer viewnum, Integer backnum, String note, Integer uid, String uname, String upicsrc, String sign,
			Integer state) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tcontext = tcontext;
		this.createtime = createtime;
		this.modifytime = modifytime;
		this.bid = bid;
		this.viewnum = viewnum;
		this.backnum = backnum;
		this.note = note;
		this.uid = uid;
		this.uname = uname;
		this.upicsrc = upicsrc;
		this.sign = sign;
		this.state = state;
	}




	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Integer getBacknum() {
		return backnum;
	}

	public void setBacknum(Integer backnum) {
		this.backnum = backnum;
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

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
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
		return "TopicShow [tid=" + tid + ", tname=" + tname + ", tcontext=" + tcontext + ", createtime=" + createtime
				+ ", modifytime=" + modifytime + ", bid=" + bid + ", viewnum=" + viewnum + ", backnum=" + backnum
				+ ", note=" + note + ", uid=" + uid + ", uname=" + uname + ", upicsrc=" + upicsrc + ", sign=" + sign
				+ ", state=" + state + "]";
	}

	
    
}