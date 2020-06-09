package com.dllyal.forum.model;

import java.util.Date;

public class User {
    private Integer uid;

    private String account;

    private String password;

    private String uname;

    private String upicsrc;

    private String sex;

    private Date birthday;

    private String phone;

    private Date createtime;

    private String sign;

    private String note;

    private Integer role = 0;

    private Integer state = 0;
    
    

    public User() {
		super();
	}

	public User(Integer uid, String account, String password, String uname, String upicsrc, String sex, Date birthday,
			String phone, Date createtime, String sign, String note, Integer role, Integer state) {
		super();
		this.uid = uid;
		this.account = account;
		this.password = password;
		this.uname = uname;
		this.upicsrc = upicsrc;
		this.sex = sex;
		this.birthday = birthday;
		this.phone = phone;
		this.createtime = createtime;
		this.sign = sign;
		this.note = note;
		this.role = role;
		this.state = state;
	}

	public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

	@Override
	public String toString() {
		return "User [uid=" + uid + ", account=" + account + ", password=" + password + ", uname=" + uname
				+ ", upicsrc=" + upicsrc + ", sex=" + sex + ", birthday=" + birthday + ", phone=" + phone
				+ ", createtime=" + createtime + ", sign=" + sign + ", note=" + note + ", role=" + role + ", state="
				+ state + "]";
	}
    
    
}