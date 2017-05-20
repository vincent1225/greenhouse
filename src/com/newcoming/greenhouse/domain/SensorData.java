package com.newcoming.greenhouse.domain;

import java.util.Date;

/**
 * 设备数据表
 * SensorData entity. @author MyEclipse Persistence Tools
 */

public class SensorData implements java.io.Serializable {
	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;  //自增主键
	private Equipment equipment;  //设备id外键
	private Date time;			//时间戳
	private Double value;		//设备记录值
	private Long valueType;		//记录值类型,是否是压缩过得数据
	private String remark;   //备注
	private Long del;				//删除标识
	// Constructors

	/** default constructor */
	public SensorData() {
	}

	/** minimal constructor */
	public SensorData(Long id) {
		this.id = id;
	}

	/** full constructor */
	

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public SensorData(Long id, Equipment equipment, Date time, Double value,
			Long valueType, String remark, Long del) {
		super();
		this.id = id;
		this.equipment = equipment;
		this.time = time;
		this.value = value;
		this.valueType = valueType;
		this.remark = remark;
		this.del = del;
	}

	public Long getDel() {
		return del;
	}

	public void setDel(Long del) {
		this.del = del;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Equipment getEquipment() {
		return this.equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Double getValue() {
		return this.value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Long getValueType() {
		return this.valueType;
	}

	public void setValueType(Long valueType) {
		this.valueType = valueType;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}