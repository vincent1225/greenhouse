package com.newcoming.greenhouse.view.action;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.newcoming.greenhouse.base.BaseAction;
import com.newcoming.greenhouse.domain.Equipment;
import com.newcoming.greenhouse.domain.Greenhouse;
import com.newcoming.greenhouse.domain.Park;
import com.newcoming.greenhouse.domain.SensorData;
import com.newcoming.greenhouse.util.DateUtil;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class HistoryAction extends BaseAction<Greenhouse> {

	private Long park_id;
	private Long greenhouse_id;
	private int equipmentKind;
	private List<Park> parks;
	private List<Greenhouse> greenhouses;
	private List<List<SensorData>> historyLine= new ArrayList<List<SensorData>>();
	private int dataKind;
	private List<String> ticksX = new ArrayList<String>();
	
	/** 首页 */
	public String index() throws Exception {
		parks = parkService.getAllParks(getCurrentUser().getId());
		greenhouses = greenhouseService.getAllGreenhouses(getCurrentUser().getId());
		return "index";
	}
	
	/** 列表 */
	public String list() throws Exception{	
		if(this.getPark_id() == null){
			this.setGreenhouse_id((long)1);
			this.setEquipmentKind(1);
			this.setDataKind(1);
		}		
		String dateNow = DateUtil.currentTime(DateUtil.DEFAULT_DATETIME_FORMAT_HOUR);	
		for(int i = 0;i<24;i++){
			dateNow = DateUtil.dateGeter(dateNow, this.getDataKind());
			ticksX.add(dateNow);
		}
		dateNow = DateUtil.currentTime(DateUtil.DEFAULT_DATETIME_FORMAT_HOUR);	
		List <Equipment> liste = 
				equipmentService.findEquipmentsBygreenhouseIdAndEtype(this.getGreenhouse_id(), (long)this.getEquipmentKind());
		for(Equipment e :liste){
			//装载每个传感器的24条数据
			List<SensorData> currentLine = sensorDataService.getHistorySensorData(e.getId(),dateNow,this.getDataKind());
			System.out.println(currentLine.size()+"currentLine");
			//装载同一类型传感器的数据
			historyLine.add(currentLine);
		}
		System.out.println(historyLine.size()+"historyLine");
		return "list";
	}

	/** 删除 */
	public String delete() throws Exception {
		return "toList";
	}
	
	/** 添加 */
	public String add() throws Exception {
		
			return "toList";
	}

	public Long getPark_id() {
		return park_id;
	}

	public void setPark_id(Long park_id) {
		this.park_id = park_id;
	}

	public Integer getEquipmentKind() {
		return equipmentKind;
	}

	public void setEquipmentKind(int equipmentKind) {
		this.equipmentKind = equipmentKind;
	}

	public List<Park> getParks() {
		return parks;
	}


	public List<List<SensorData>> getHistoryLine() {
		return historyLine;
	}

	public void setHistoryLine(List<List<SensorData>> historyLine) {
		this.historyLine = historyLine;
	}

	public void setParks(List<Park> parks) {
		this.parks = parks;
	}


	public List<Greenhouse> getGreenhouses() {
		return greenhouses;
	}

	public void setGreenhouses(List<Greenhouse> greenhouses) {
		this.greenhouses = greenhouses;
	}

	public Integer getDataKind() {
		return dataKind;
	}

	public void setDataKind(int dataKind) {
		this.dataKind = dataKind;
	}

	public Long getGreenhouse_id() {
		return greenhouse_id;
	}

	public void setGreenhouse_id(Long greenhouse_id) {
		this.greenhouse_id = greenhouse_id;
	}
	

	public List<String> getTicksX() {
		return ticksX;
	}

	public void setTicksX(List<String> ticksX) {
		this.ticksX = ticksX;
	}
	
}
