package com.newcoming.greenhouse.pojo;

import java.util.List;

public class HistorySensorData {
	private List<SensorDataForAndroid> oneday;
	private List<SensorDataForAndroid> threeday;
	private List<SensorDataForAndroid> oneweek;
	public List<SensorDataForAndroid> getOneday() {
		return oneday;
	}
	public void setOneday(List<SensorDataForAndroid> oneday) {
		this.oneday = oneday;
	}
	public List<SensorDataForAndroid> getThreeday() {
		return threeday;
	}
	public void setThreeday(List<SensorDataForAndroid> threeday) {
		this.threeday = threeday;
	}
	public List<SensorDataForAndroid> getOneweek() {
		return oneweek;
	}
	public void setOneweek(List<SensorDataForAndroid> oneweek) {
		this.oneweek = oneweek;
	}
	public HistorySensorData(List<SensorDataForAndroid> oneday,
			List<SensorDataForAndroid> threeday,
			List<SensorDataForAndroid> oneweek) {
		super();
		this.oneday = oneday;
		this.threeday = threeday;
		this.oneweek = oneweek;
	}
	public HistorySensorData() {
	}
	
	
	
}
