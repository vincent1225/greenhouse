package com.newcoming.greenhouse.pojo;


public class SensorDataForAndroid {
	private String time;
	private Double value;		//设备记录值
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public SensorDataForAndroid(String time, Double value) {
		super();
		this.time = time;
		this.value = value;
	}
	public SensorDataForAndroid() {
	}
	
	
}
