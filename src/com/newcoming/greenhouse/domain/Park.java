package com.newcoming.greenhouse.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 园区表
 * Park entity. @author MyEclipse Persistence Tools
 */

public class Park implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamePY() {
		return namePY;
	}

	public void setNamePY(String namePY) {
		this.namePY = namePY;
	}

	private Long id; //自增主键
	private String parkId; //园区编号
	private String name; //用户显示园区名字
	private String namePY;//用户显示园区名字拼音
	private String gps; //园区位置信息
	private String topIp; //上位机ip地址
	private User addBy; //添加人
	private User chaBy; //修改人
	private User delBy; //删除人
	private Long del;  //删除标识
	private String remark; //备注
	
	private Set<Greenhouse> greenhouses = new HashSet<Greenhouse>();

	// Constructors

	/** default constructor */
	public Park() {
	}

	/** minimal constructor */
	public Park(Long id) {
		this.id = id;
	}

	

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParkId() {
		return this.parkId;
	}

	public void setParkId(String parkId) {
		this.parkId = parkId;
	}

	public String getGps() {
		return this.gps;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}

	public String getTopIp() {
		return this.topIp;
	}

	public void setTopIp(String topIp) {
		this.topIp = topIp;
	}

	public Long getDel() {
		return this.del;
	}

	public void setDel(Long del) {
		this.del = del;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public Set<Greenhouse> getGreenhouses() {
		return this.greenhouses;
	}

	public void setGreenhouses(Set<Greenhouse> greenhouses) {
		this.greenhouses = greenhouses;
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


	
	

}