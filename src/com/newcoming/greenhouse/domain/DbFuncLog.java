package com.newcoming.greenhouse.domain;

import java.util.Date;

/**
 * 
 * 操作日志表
 * DbFuncLog entity. @author MyEclipse Persistence Tools
 */

public class DbFuncLog implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id; //自增主键 
	private User user; //用户id外键
	private Date time;  //时间戳
	private String log; //数据库登陆记录
	
	private User delBy; //删除人
	private Long del;  //删除标识
	private String remark;  //备注

	// Constructors

	/** default constructor */
	public DbFuncLog() {
	}

	/** minimal constructor */
	public DbFuncLog(Long id) {
		this.id = id;
	}

	/** full constructor */
	

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getLog() {
		return this.log;
	}

	public void setLog(String log) {
		this.log = log;
	}


	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public DbFuncLog(Long id, User user, Date time, String log, User delBy,
			Long del, String remark) {
		super();
		this.id = id;
		this.user = user;
		this.time = time;
		this.log = log;
		this.delBy = delBy;
		this.del = del;
		this.remark = remark;
	}

	public User getDelBy() {
		return delBy;
	}

	public void setDelBy(User delBy) {
		this.delBy = delBy;
	}

	public Long getDel() {
		return del;
	}

	public void setDel(Long del) {
		this.del = del;
	}
	
	

}