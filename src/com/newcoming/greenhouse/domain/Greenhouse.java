package com.newcoming.greenhouse.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 大棚表
 * Greenhouse entity. @author MyEclipse Persistence Tools
 */

public class Greenhouse implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;  //自增主键
	private Park park;  //园区id外键
	private String greenhouseId; //大棚编号
	private String name;//用户定义大棚名称
	private String namePY; //用户定义大棚名称拼音
	
	private Long airTemperatureSensorNum;  //空气温度传感器个数
	private Long airHumiditySensorNum;		//空气湿度传感器个数
	private Long soilTemperatureSensorNum;	//土壤温度传感器个数
	private Long soilMoistureSensorNum;		//土壤湿度传感器个数
	private Long lightIntensitySensorNum;	//光照强度数据传感器个数
	private Long airCarbonDioxideSensorNum;	//空气二氧化碳个数
	private Long nitrogenAirSensorNum;		//空气氮气数据传感器个数
	private Long phsensor;					//ph值传感器
	
	private Long screen;					//卷帘个数
	private Long indoorLighting;			//室内灯光
	private Long artificialLighting;       //人工补光
	private Long dropper;					//滴灌
	private Long sprinklingIrrigation;		//喷灌
	private Long airVent;					//通风
	private User addBy; // 添加人
	private User chaBy; // 修改人
	private User delBy; // 删除人
	private Long del; // 删除标识
	private String remark;					//备注
	private Set<Equipment> equipments = new HashSet<Equipment>();
	private Set<User> users = new HashSet<User>();
	// Constructors

	
	
	/** default constructor */
	public Greenhouse() {
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	/** minimal constructor */
	public Greenhouse(Long id) {
		this.id = id;
	}

	

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Park getPark() {
		return this.park;
	}

	public void setPark(Park park) {
		this.park = park;
	}

	public String getGreenhouseId() {
		return this.greenhouseId;
	}

	public void setGreenhouseId(String greenhouseId) {
		this.greenhouseId = greenhouseId;
	}

	public Long getAirTemperatureSensorNum() {
		return this.airTemperatureSensorNum;
	}

	public void setAirTemperatureSensorNum(Long airTemperatureSensorNum) {
		this.airTemperatureSensorNum = airTemperatureSensorNum;
	}

	public Long getAirHumiditySensorNum() {
		return this.airHumiditySensorNum;
	}

	public void setAirHumiditySensorNum(Long airHumiditySensorNum) {
		this.airHumiditySensorNum = airHumiditySensorNum;
	}

	public Long getSoilTemperatureSensorNum() {
		return this.soilTemperatureSensorNum;
	}

	public void setSoilTemperatureSensorNum(Long soilTemperatureSensorNum) {
		this.soilTemperatureSensorNum = soilTemperatureSensorNum;
	}

	public Long getSoilMoistureSensorNum() {
		return this.soilMoistureSensorNum;
	}

	public void setSoilMoistureSensorNum(Long soilMoistureSensorNum) {
		this.soilMoistureSensorNum = soilMoistureSensorNum;
	}

	public Long getLightIntensitySensorNum() {
		return this.lightIntensitySensorNum;
	}

	public void setLightIntensitySensorNum(Long lightIntensitySensorNum) {
		this.lightIntensitySensorNum = lightIntensitySensorNum;
	}

	public Long getAirCarbonDioxideSensorNum() {
		return this.airCarbonDioxideSensorNum;
	}

	public void setAirCarbonDioxideSensorNum(
			Long airCarbonDioxideSensorNum) {
		this.airCarbonDioxideSensorNum = airCarbonDioxideSensorNum;
	}

	public Long getNitrogenAirSensorNum() {
		return this.nitrogenAirSensorNum;
	}

	public void setNitrogenAirSensorNum(Long nitrogenAirSensorNum) {
		this.nitrogenAirSensorNum = nitrogenAirSensorNum;
	}

	public Long getScreen() {
		return this.screen;
	}

	public void setScreen(Long screen) {
		this.screen = screen;
	}

	public Long getIndoorLighting() {
		return this.indoorLighting;
	}

	public void setIndoorLighting(Long indoorLighting) {
		this.indoorLighting = indoorLighting;
	}

	public Long getArtificialLighting() {
		return this.artificialLighting;
	}

	public void setArtificialLighting(Long artificialLighting) {
		this.artificialLighting = artificialLighting;
	}

	public Long getDropper() {
		return this.dropper;
	}

	public void setDropper(Long dropper) {
		this.dropper = dropper;
	}

	public Long getSprinklingIrrigation() {
		return this.sprinklingIrrigation;
	}

	public void setSprinklingIrrigation(Long sprinklingIrrigation) {
		this.sprinklingIrrigation = sprinklingIrrigation;
	}

	public Long getAirVent() {
		return this.airVent;
	}

	public void setAirVent(Long airVent) {
		this.airVent = airVent;
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

	public Set<Equipment> getEquipments() {
		return this.equipments;
	}

	public void setEquipments(Set<Equipment> equipments) {
		this.equipments = equipments;
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

	public Long getPhsensor() {
		return phsensor;
	}

	public void setPhsensor(Long phsensor) {
		this.phsensor = phsensor;
	}

	public Greenhouse(Long id, Park park, String greenhouseId,
			String name, String namePY,
			Long airTemperatureSensorNum, Long airHumiditySensorNum,
			Long soilTemperatureSensorNum, Long soilMoistureSensorNum,
			Long lightIntensitySensorNum, Long airCarbonDioxideSensorNum,
			Long nitrogenAirSensorNum, Long phsensor, Long screen,
			Long indoorLighting, Long artificialLighting, Long dropper,
			Long sprinklingIrrigation, Long airVent, User addBy, User chaBy,
			User delBy, Long del, String remark, Set<Equipment> equipments,
			Set<User> users) {
		super();
		this.id = id;
		this.park = park;
		this.greenhouseId = greenhouseId;
		this.name = name;
		this.namePY = namePY;
		this.airTemperatureSensorNum = airTemperatureSensorNum;
		this.airHumiditySensorNum = airHumiditySensorNum;
		this.soilTemperatureSensorNum = soilTemperatureSensorNum;
		this.soilMoistureSensorNum = soilMoistureSensorNum;
		this.lightIntensitySensorNum = lightIntensitySensorNum;
		this.airCarbonDioxideSensorNum = airCarbonDioxideSensorNum;
		this.nitrogenAirSensorNum = nitrogenAirSensorNum;
		this.phsensor = phsensor;
		this.screen = screen;
		this.indoorLighting = indoorLighting;
		this.artificialLighting = artificialLighting;
		this.dropper = dropper;
		this.sprinklingIrrigation = sprinklingIrrigation;
		this.airVent = airVent;
		this.addBy = addBy;
		this.chaBy = chaBy;
		this.delBy = delBy;
		this.del = del;
		this.remark = remark;
		this.equipments = equipments;
		this.users = users;
	}

	
	

}