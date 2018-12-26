package com.sg.cp.model;

import java.io.Serializable;

public class UsgpEnh implements Serializable {
    private Integer usgpid;
    private String usgpiddesc;
    private String usgpname;
    private String leaderid;
    private String remark;
    private String status;
    private Long credate;
    private Long lupdate;
    private String creby;
    private String lupby;
    public Integer getUsgpid() {
        return usgpid;
    }
    public void setUsgpid(Integer usgpid) {
        this.usgpid = usgpid;
    }
    public String getUsgpname() {
        return usgpname;
    }
    public void setUsgpname(String usgpname) {
        this.usgpname = usgpname == null ? null : usgpname.trim();
    }

    public String getLeaderid() {
		return leaderid;
	}

	public void setLeaderid(String leaderid) {
		this.leaderid = leaderid;
	}
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
    public String getCreby() {
        return creby;
    }
    public void setCreby(String creby) {
        this.creby = creby == null ? null : creby.trim();
    }
    public String getLupby() {
        return lupby;
    }
    public void setLupby(String lupby) {
        this.lupby = lupby == null ? null : lupby.trim();
    }
	public String getUsgpiddesc() {
		return usgpiddesc;
	}
	public void setUsgpiddesc(String usgpiddesc) {
		this.usgpiddesc = usgpiddesc;
	}
}