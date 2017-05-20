package com.newcoming.greenhouse.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 设备表
 * Equipment entity. @author MyEclipse Persistence Tools
 */

public class Equipment implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;  //自增主键
	private Greenhouse greenhouse; //大棚id外键
	private String equipmentId;  //设备编号
	private Long ctrlOrSample;  //控制或是采集设备的标识
	private Long type;         //设备类型，表示什么传感器
	private Long status;       //设备状态，开关，或者损坏
	private String name;  //用户自定义设备名称
	private String namePY; // 用户自定义设备拼音
	private Double valueYzMax;		//预警最大值
	private Double valueYzMin;      //预警最小值
	private Double valueMax;        //设备量程最大值
	private Double valueMin;        //设备量程最小值
	private User addBy;			//添加人
	private User chaBy;			//修改人
	private User delBy;			//删除人
	private Long del;				//删除标识
	private String remark;			//备注
	private Set<EquipmentCmd> equipmentCmds = new HashSet<EquipmentCmd>();
	private Set<SensorData> sensorDatas = new HashSet<SensorData>();

	// Constructors

	/** default constructor */
	public Equipment() {
	}

	/** minimal constructor */
	public Equipment(Long id) {
		this.id = id;
	}

	

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Greenhouse getGreenhouse() {
		return this.greenhouse;
	}

	public void setGreenhouse(Greenhouse greenhouse) {
		this.greenhouse = greenhouse;
	}

	public String getEquipmentId() {
		return this.equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public Long getCtrlOrSample() {
		return this.ctrlOrSample;
	}

	public void setCtrlOrSample(Long ctrlOrSample) {
		this.ctrlOrSample = ctrlOrSample;
	}

	public Long getType() {
		return this.type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}



	public Double getValueYzMax() {
		return this.valueYzMax;
	}

	public void setValueYzMax(Double valueYzMax) {
		this.valueYzMax = valueYzMax;
	}

	public Double getValueYzMin() {
		return this.valueYzMin;
	}

	public void setValueYzMin(Double valueYzMin) {
		this.valueYzMin = valueYzMin;
	}

	public Double getValueMax() {
		return this.valueMax;
	}

	public void setValueMax(Double valueMax) {
		this.valueMax = valueMax;
	}

	public Double getValueMin() {
		return this.valueMin;
	}

	public void setValueMin(Double valueMin) {
		this.valueMin = valueMin;
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

	public Set<EquipmentCmd> getEquipmentCmds() {
		return this.equipmentCmds;
	}

	public void setEquipmentCmds(Set<EquipmentCmd> equipmentCmds) {
		this.equipmentCmds = equipmentCmds;
	}

	public Set<SensorData> getSensorDatas() {
		return this.sensorDatas;
	}

	public void setSensorDatas(Set<SensorData> sensorDatas) {
		this.sensorDatas = sensorDatas;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	

}