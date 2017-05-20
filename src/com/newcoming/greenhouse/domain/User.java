package com.newcoming.greenhouse.domain;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;

/**
 * 用户表
 * 
 * @author Administrator
 * 
 */
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Set<Role> roles = new HashSet<Role>();
	private Set<Greenhouse> greenhouses = new HashSet<Greenhouse>();

	private String loginName; // 登录名
	private String password; // 密码
	private String name; // 真实姓名
	private String gender; // 性别
	private String phoneNumber; // 电话号码
	private String email; // 电子邮件
	private User addBy; // 添加人
	private User chaBy; // 修改人
	private User delBy; // 删除人
	private Date userTime;// 操作时间

	private Long del; // 删除标识
	private String remark; // 备注

	/**
	 * 判断本用户是否有指定名称的权限
	 * 
	 * @param name
	 * @return
	 */
	public boolean hasPrivilegeByName(String name) {
		// 超级管理有所有的权限
		if (isAdmin()) {
			return true;
		}

		// 普通用户要判断是否含有这个权限
		for (Role role : roles) {
			for (Privilege priv : role.getPrivileges()) {
				if (priv.getName().equals(name)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 判断本用户是否有指定URL的权限
	 * @param privUrl
	 * @return
	 */
	public boolean hasPrivilegeByUrl(String privUrl) {
		// 超级管理有所有的权限
		if (isAdmin()) {
			return true;
		}

		// >> 去掉后面的参数
		int pos = privUrl.indexOf("?");
		if (pos > -1) {
			privUrl = privUrl.substring(0, pos);
		}
		// >> 去掉UI后缀
		if (privUrl.endsWith("UI")) {
			privUrl = privUrl.substring(0, privUrl.length() - 2);
		}

		// 如果本URL不需要控制，则登录用户就可以使用
		Collection<String> allPrivilegeUrls = (Collection<String>) ActionContext.getContext().getApplication().get("allPrivilegeUrls");
		if (!allPrivilegeUrls.contains(privUrl)) {
			return true;
		} else {
			// 普通用户要判断是否含有这个权限
			for (Role role : roles) {
				for (Privilege priv : role.getPrivileges()) {
					if (privUrl.equals(priv.getUrl())) {
						return true;
					}
				}
			}
			return false;
		}
	}

	/**
	 * 判断本用户是否是超级管理员
	 * @return
	 */
	public boolean isAdmin() {
		return "admin".equals(loginName);
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Greenhouse> getGreenhouses() {
		return greenhouses;
	}

	public void setGreenhouses(Set<Greenhouse> greenhouses) {
		this.greenhouses = greenhouses;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getAddBy() {
		return addBy;
	}

	public void setAddBy(User addBy) {
		this.addBy = addBy;
	}

	public User getChaBy() {
		return chaBy;
	}

	public void setChaBy(User chaBy) {
		this.chaBy = chaBy;
	}

	public User getDelBy() {
		return delBy;
	}

	public void setDelBy(User delBy) {
		this.delBy = delBy;
	}

	

	public Date getUserTime() {
		return userTime;
	}

	public void setUserTime(Date userTime) {
		this.userTime = userTime;
	}

	public Long getDel() {
		return del;
	}

	public void setDel(Long del) {
		this.del = del;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}



	public User(Long id, Set<Role> roles, Set<Greenhouse> greenhouses,
			String loginName, String password, String name, String gender,
			String phoneNumber, String email, User addBy, User chaBy,
			User delBy, Date userTime, Long del, String remark) {
		super();
		this.id = id;
		this.roles = roles;
		this.greenhouses = greenhouses;
		this.loginName = loginName;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.addBy = addBy;
		this.chaBy = chaBy;
		this.delBy = delBy;
		this.userTime = userTime;
		this.del = del;
		this.remark = remark;
	}

	public User() {
	}

	// ---------------------------------------------------

}
