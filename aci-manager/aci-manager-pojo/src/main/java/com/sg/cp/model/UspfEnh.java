package com.sg.cp.model;

import java.io.Serializable;
import java.util.List;

public class UspfEnh implements Serializable{
	
    private String userid;
    private String reporterid;
    private String realname;
    private String gender;
    private String email;
    private String telno;
    private String wechatno;
    private String addr;
    private Integer dob;
    private Integer expirydate;
    private String designation;
    private String status;
    private Long terminationdate;
    private Long credate;
    private Long lupdate;
    private String remark;
    private String creby;
    private String lupby;
    
    /*Below is desc part displayed in frontend*/
    private String usergroupdesc;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getReporterid() {
		return reporterid;
	}

	public void setReporterid(String reporterid) {
		this.reporterid = reporterid;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getWechatno() {
		return wechatno;
	}

	public void setWechatno(String wechatno) {
		this.wechatno = wechatno;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Integer getDob() {
		return dob;
	}

	public void setDob(Integer dob) {
		this.dob = dob;
	}

	public Integer getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(Integer expirydate) {
		this.expirydate = expirydate;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getTerminationdate() {
		return terminationdate;
	}

	public void setTerminationdate(Long terminationdate) {
		this.terminationdate = terminationdate;
	}

	public Long getCredate() {
		return credate;
	}

	public void setCredate(Long credate) {
		this.credate = credate;
	}

	public Long getLupdate() {
		return lupdate;
	}

	public void setLupdate(Long lupdate) {
		this.lupdate = lupdate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreby() {
		return creby;
	}

	public void setCreby(String creby) {
		this.creby = creby;
	}

	public String getLupby() {
		return lupby;
	}

	public void setLupby(String lupby) {
		this.lupby = lupby;
	}

	public String getUsergroupdesc() {
		return usergroupdesc;
	}

	public void setUsergroupdesc(String usergroupdesc) {
		this.usergroupdesc = usergroupdesc;
	}

	@Override
	public String toString() {
		return "UspfEnh [userid=" + userid + ", realname=" + realname + "]";
	}
	
	
}