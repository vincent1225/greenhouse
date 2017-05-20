package com.newcoming.greenhouse.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newcoming.greenhouse.base.DaoSupportImpl;
import com.newcoming.greenhouse.domain.SensorData;
import com.newcoming.greenhouse.service.SensorDataService;
import com.newcoming.greenhouse.util.DateUtil;

@Service
@Transactional
public class SensorDataServiceImpl extends DaoSupportImpl<SensorData> implements
		SensorDataService {

	@SuppressWarnings("unchecked")
	@Override
	public SensorData getRealtimeDataByEquipId(Long equipment_id) {
		SensorData sensorData = null;
		List<SensorData> sensorDataList= 
				getSession().createQuery("select s from SensorData s " +
						"join s.equipment e where e.id = ? " +
						"and s.del = 0 " +
						"order by s.time desc limit 0,1")
				.setParameter(0,equipment_id)
				.list();
		if(sensorDataList.size()>0){
			sensorData =  sensorDataList.get(0);
		}
		return sensorData;
	}

	@Override
	public List<SensorData> getHistorySensorData(Long equipment_id, String date,
			Integer days) throws Exception {
		List<SensorData> list = new ArrayList<>();
		for(int i = 0;i<24;i++){
			date = DateUtil.dateGeter(date, days);
			String currentDate = date+"%";
			Query query = 
					getSession().createQuery("SELECT s FROM SensorData s  "
							+ "join s.equipment e "
							+ "WHERE e.id=? "
							+ "and  to_char(s.time,'YYYY-MM-DD HH24:MI:SS') like ? "
							+ "and e.del=0 "
							)		
					.setParameter(0,equipment_id)
					.setParameter(1, currentDate);
			List<SensorData> currentlist = query.list();
			if(currentlist.size()>0)
			list.add(currentlist.get(0));		
	}
		return list;
}
	
	public List<SensorData> getAllHistorySensorData(String equipmentId, String date,Integer days) throws Exception {
		List<SensorData> list = new ArrayList<>();
		for(int i = 0;i<24;i++){
			date = DateUtil.dateGeter(date, days);
			String currentDate = date+"%";
			Query query = 
					getSession().createQuery("SELECT s FROM SensorData s  "
							+ "join s.equipment e "
							+ "WHERE e.equipmentId=? "
							+ "and  to_char(s.time,'YYYY-MM-DD HH24:MI:SS') like ? "
							+ "and e.del=0 "
							)		
					.setParameter(0,equipmentId)
					.setParameter(1, currentDate);
			@SuppressWarnings("unchecked")
			List<SensorData> currentlist = query.list();
			if(currentlist.size()>0)
			list.add(currentlist.get(0));			
	}
		return list;
  }
}
