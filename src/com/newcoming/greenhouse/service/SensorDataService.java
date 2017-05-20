package com.newcoming.greenhouse.service;

import java.util.List;
import com.newcoming.greenhouse.base.DaoSupport;
import com.newcoming.greenhouse.domain.SensorData;

public interface SensorDataService extends DaoSupport<SensorData> {
	
	    //通过设备主键获取传感器的实时数据
		public SensorData getRealtimeDataByEquipId(Long equipment_id);
		
		//通过设备主键，当前时间和查询的天数获取传感器的历史数据
		public List<SensorData> getHistorySensorData(Long equipment_id,String date,Integer days) throws Exception;
		
		//通过设备编号，当前时间和查询的天数获取传感器的历史数据
		public List<SensorData> getAllHistorySensorData(String equipmentId, String date,Integer days) throws Exception;
}
