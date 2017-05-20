package com.newcoming.greenhouse.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色表
 * 
 */
public class Role  implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;

	private Set<User> users = new HashSet<User>();
	private Set<Privilege> privileges = new HashSet<Privilege>();//权限
	
	private String name;
	private String remark;//备注
	private User userID;//操作员ID
	private Date userTime;//操作时间
	private Long del;				//删除标识
	
	
	
	public Role(Long id, Set<User> users, Set<Privilege> privileges,
			String name, String remark, User userID, Date userTime, Long del) {
		super();
		this.id = id;
		this.users = users;
		this.privileges = privileges;
		this.name = name;
		this.remark = remark;
		this.userID = userID;
		this.userTime = userTime;
		this.del = del;
	}

	public Long getDel() {
		return del;
	}

	public void setDel(Long del) {
		this.del = del;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	

	public User getUserID() {
		return userID;
	}

	public void setUserID(User userID) {
		this.userID = userID;
	}

	public Date getUserTime() {
		return userTime;
	}

	public void setUserTime(Date userTime) {
		this.userTime = userTime;
	}

}
