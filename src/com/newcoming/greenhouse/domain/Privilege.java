package com.newcoming.greenhouse.domain;

import java.util.HashSet;
import java.util.Set;
/**
 * 权限表
 * @author Administrator
 *
 */
public class Privilege implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String url;
	private String name; // 权限名称
	private Set<Role> roles = new HashSet<Role>();
	private Privilege parent; // 上级权限
	private Set<Privilege> children = new HashSet<Privilege>(); // 下级权限
	private Long del;				//删除标识
	public Privilege() {
	}

	
	
	public Privilege(Long id, String url, String name, Set<Role> roles,
			Privilege parent, Set<Privilege> children, Long del) {
		super();
		this.id = id;
		this.url = url;
		this.name = name;
		this.roles = roles;
		this.parent = parent;
		this.children = children;
		this.del = del;
	}



	public Long getDel() {
		return del;
	}



	public void setDel(Long del) {
		this.del = del;
	}



	public Privilege(String name, String url, Privilege parent) {
		this.name = name;
		this.url = url;
		this.parent = parent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Privilege getParent() {
		return parent;
	}

	public void setParent(Privilege parent) {
		this.parent = parent;
	}

	public Set<Privilege> getChildren() {
		return children;
	}

	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}

}
