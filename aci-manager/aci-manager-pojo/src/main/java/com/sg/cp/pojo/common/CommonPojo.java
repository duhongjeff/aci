package com.sg.cp.pojo.common;

import java.io.Serializable;
import java.util.Date;

public class CommonPojo implements Serializable {

	private String remark;

	private String status;

	private Date credate;

	private Date lupdate;

	private String creby;

	private String lupby;

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

	public Date getCredate() {
		return credate;
	}

	public void setCredate(Date credate) {
		this.credate = credate;
	}

	public Date getLupdate() {
		return lupdate;
	}

	public void setLupdate(Date lupdate) {
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
}