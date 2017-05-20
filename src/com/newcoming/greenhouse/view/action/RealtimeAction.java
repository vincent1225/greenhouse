package com.newcoming.greenhouse.view.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.newcoming.greenhouse.base.BaseAction;
import com.newcoming.greenhouse.base.SysConstants;
import com.newcoming.greenhouse.domain.Equipment;
import com.newcoming.greenhouse.domain.Greenhouse;
import com.newcoming.greenhouse.domain.PageBean;
import com.newcoming.greenhouse.domain.Park;
import com.newcoming.greenhouse.domain.SensorData;
import com.newcoming.greenhouse.util.AssemblyEquipmentNumber;
import com.newcoming.greenhouse.util.MapsUtil;
import com.newcoming.greenhouse.util.QueryHelper;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class RealtimeAction extends BaseAction<SensorData> {

//	private Long departmentId;
//	private Long[] greenhousesIds;
//	private Long[] roleIds;
	private Long park_id;
	private Long greenhouse_id;
	private int equipmentKind;
	List<Park> parks ;
	List<Greenhouse> greenhouses;
	List<SensorData> sensorDatas = new ArrayList<SensorData>();
	

	/** 首页 */
	public String index() throws Exception {
		parks = parkService.getAllParks(getCurrentUser().getId());
		greenhouses = greenhouseService.getAllGreenhouses(getCurrentUser().getId());
		return "index";
	}
	
	/** 列表 */
	public String list() throws Exception {
		if(this.getPark_id() == null){
			this.setGreenhouse_id((long)1);
			this.setEquipmentKind(1);
		}
		List <Equipment> equipmentList = 
				equipmentService.findEquipmentsBygreenhouseIdAndEtype(this.getGreenhouse_id(), (long)this.getEquipmentKind());
		for(Equipment e :equipmentList){
			 SensorData sensorData = sensorDataService.getRealtimeDataByEquipId(e.getId());
			 if(sensorData != null){
				 sensorDatas.add(sensorData);
			 }
		}
		return "list";
	}

	/** 查询界面 */
	public String queryUI() throws Exception {
		return "queryUI";
	}
	
	
	/** 删除 */
	public String delete() throws Exception {
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {

		return "saveUI";
	}

	
	/** 添加 */
	public String add() throws Exception {
			return "toList";
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		return "saveUI";
	}

	/** 修改 */
	public String edit() throws Exception {

		return "toList";
	}
	
	public int getEquipmentKind() {
		return equipmentKind;
	}

	public void setEquipmentKind(int equipmentKind) {
		this.equipmentKind = equipmentKind;
	}


	public List<Greenhouse> getGreenhouses() {
		return greenhouses;
	}

	public void setGreenhouses(List<Greenhouse> greenhouses) {
		this.greenhouses = greenhouses;
	}

	public List<Park> getParks() {
		return parks;
	}

	public void setParks(List<Park> parks) {
		this.parks = parks;
	}

	

	public Long getPark_id() {
		return park_id;
	}

	public void setPark_id(Long park_id) {
		this.park_id = park_id;
	}

	public Long getGreenhouse_id() {
		return greenhouse_id;
	}

	public void setGreenhouse_id(Long greenhouse_id) {
		this.greenhouse_id = greenhouse_id;
	}

	public List<SensorData> getSensorDatas() {
		return sensorDatas;
	}

	public void setSensorDatas(List<SensorData> sensorDatas) {
		this.sensorDatas = sensorDatas;
	}


//	}
	
	// -----------------------------
	

}
