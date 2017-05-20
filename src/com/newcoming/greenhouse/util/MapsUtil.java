package com.newcoming.greenhouse.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.newcoming.greenhouse.domain.*;

public class MapsUtil {
	public static  Map<Integer,SensorData> SensorDataMap(List<SensorData> p){
		Map<Integer,SensorData> maps = new HashMap<Integer, SensorData>();
		for(SensorData s:p){
			maps.put(s.getId().intValue(), s);
		}
		return maps;
	}
	public static  Map<String,String> greenhouseDataMap(List<Greenhouse> p){
		Map<String,String> maps = new HashMap<String,String>();
		for(Greenhouse s:p){
			maps.put(s.getGreenhouseId(), s.getName());
		}
		return maps;
	}
	public static Map<Integer,Map<Integer,SensorData>> historyMap(Map<Integer,Map<Integer,SensorData>> father,Map<Integer,SensorData> map,int key)
	{
		father.put(key, map);
		return father;
	}

}
