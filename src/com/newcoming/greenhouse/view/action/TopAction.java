package com.newcoming.greenhouse.view.action;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.Date;

import net.sf.json.JSONObject;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.newcoming.greenhouse.base.BaseAction;
import com.newcoming.greenhouse.base.SysConstants;
import com.newcoming.greenhouse.domain.Equipment;
import com.newcoming.greenhouse.domain.Greenhouse;
import com.newcoming.greenhouse.domain.Park;
import com.newcoming.greenhouse.domain.SensorData;
import com.newcoming.greenhouse.util.AssemblyEquipmentNumber;
import com.newcoming.greenhouse.util.DateUtil;
import com.newcoming.greenhouse.util.TextUtil;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class TopAction extends BaseAction<Object> {
	/**
* 
*/
	private static final long serialVersionUID = 1L;

	/*
	 * HttpServletRequest request; HttpServletResponse response;
	 * 
	 * public void setServletRequest(HttpServletRequest request) { this.request
	 * = request; }
	 * 
	 * public void setServletResponse(HttpServletResponse response) {
	 * this.response = response; }
	 */
	// =============== Service实例的声明 ==================

	public void login() {
		try {
			// HttpServletRequest request =ServletActionContext.getRequest();
			// HttpServletResponse response=ServletActionContext.getResponse();
			this.response.setContentType("text/html;charset=utf-8");
			this.response.setCharacterEncoding("UTF-8");
			if (this.request.getParameter("username").equals("123456")) {
				this.response.getWriter().write("真的很奇怪,日本人！");
			} else if (this.request.getParameter("username").equals("zhd")) {
				this.response.getWriter().write("没有错，我就是东子哥！");
			} else {
				this.response.getWriter().write("我就是东子哥！");
			}

			// 将要返回的实体对象进行json处理
			// JSONObject json=JSONObject.fromObject(this.getUsername());
			// 输出格式如：{"id":1, "username":"zhangsan", "pwd":"123"}
			// System.out.println(json);

			// this.response.getWriter().write(json.toString());
			/**
			 * JSONObject json=new JSONObject(); json.put("login", "login");
			 * response.setContentType("text/html;charset=utf-8");
			 * System.out.println(json); byte[] jsonBytes =
			 * json.toString().getBytes("utf-8");
			 * response.setContentLength(jsonBytes.length);
			 * response.getOutputStream().write(jsonBytes);
			 **/
			/**
			 * JSONObject json=new JSONObject(); json.put("login", "login");
			 * byte[] jsonBytes = json.toString().getBytes("utf-8");
			 * response.setContentType("text/html;charset=utf-8");
			 * response.setContentLength(jsonBytes.length);
			 * response.getOutputStream().write(jsonBytes);
			 * response.getOutputStream().flush();
			 * response.getOutputStream().close();
			 **/

		} catch (Exception e) {
			e.printStackTrace();
		}
		// return "login";
	}

	/**
	 * 实时数据接口
	 */
	public void realData() {
		String jsonstr = this.request.getParameter("json");
		System.out.println("realData" + jsonstr);
		if (!TextUtil.isEmpty(jsonstr)) {
			// 如果不为空进行操作
			JSONObject jsonObject = JSONObject.fromObject(jsonstr);
			Integer park_id = jsonObject.getInt("park_id");
			Integer greenhouse_id = jsonObject.getInt("greenhouse_id");
			Long ctrl_or_sample = jsonObject.getLong("ctrl_or_sample");
			Long type = jsonObject.getLong("type"); // 传感器类型
			Long passageway = jsonObject.getLong("passageway");// 通道
			Double value = jsonObject.getDouble("value");
			String equipmentId = AssemblyEquipmentNumber
					.assemblyequipmentnumber(park_id, greenhouse_id,
							ctrl_or_sample, type, passageway);
			// EquipmentService equipmentService = new EquipmentServiceImpl();
			Equipment equipment = equipmentService
					.findEquipmentByEquipmentId(equipmentId);
			
			if (equipment != null) {
				// 如果有这个设备就保存数据
				Equipment equipmentone = new Equipment();
				equipmentone.setId(equipment.getId());
				SensorData sensorData = new SensorData(null, equipment,
						new Date(), value, SysConstants.DATE_TYPE_REAL_TIME,
						"", SysConstants.DEL_NO);
				sensorDataService.save(sensorData);
				sucess();

			} else {
				// 返回0
				fail();
			}

		} else {
			// 返回0
			fail();
		}

	}

	private void sucess() {
		try {
			OutputStream outputStream = this.response.getOutputStream();
			outputStream.write("1".getBytes());
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 缓存数据接口
	 */

	public void historyData() {
		String jsonstr = this.request.getParameter("json");
		if (!TextUtil.isEmpty(jsonstr)) {
			// 如果不为空进行操作
			JSONObject jsonObject = JSONObject.fromObject(jsonstr);
			Integer park_id = jsonObject.getInt("park_id");
			Integer greenhouse_id = jsonObject.getInt("greenhouse_id");
			Long ctrl_or_sample = jsonObject.getLong("ctrl_or_sample");
			Long type = jsonObject.getLong("type"); // 传感器类型
			Long passageway = jsonObject.getLong("passageway");// 通道
			Double value = jsonObject.getDouble("value");
			String time = jsonObject.getString("time");
			String equipmentId = AssemblyEquipmentNumber
					.assemblyequipmentnumber(park_id, greenhouse_id,
							ctrl_or_sample, type, passageway);
			// EquipmentService equipmentService = new EquipmentServiceImpl();
			Equipment equipment = equipmentService
					.findEquipmentByEquipmentId(equipmentId);

			if (equipment != null) {
				// 如果有这个设备就保存数据
				Date date = null;
				try {
					date = DateUtil.parseDate(time, "yyyy-MM-dd HH:mm:ss");
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

				SensorData sensorData = new SensorData(null, equipment, date,
						value, SysConstants.DATE_TYPE_HISTORY_TIME, null,
						SysConstants.DEL_NO);
				sensorDataService.save(sensorData);
				sucess();

			} else {
				// 返回0
				fail();
			}

		} else {
			// 返回0
			fail();
		}

	}

	/**
	 * 压缩数据接口
	 */
	public void historyCompressData() {
		String jsonstr = this.request.getParameter("json");
		if (!TextUtil.isEmpty(jsonstr)) {
			// 如果不为空进行操作
			JSONObject jsonObject = JSONObject.fromObject(jsonstr);
			Integer park_id = jsonObject.getInt("park_id");
			Integer greenhouse_id = jsonObject.getInt("greenhouse_id");
			Long ctrl_or_sample = jsonObject.getLong("ctrl_or_sample");
			Long type = jsonObject.getLong("type"); // 传感器类型
			Long passageway = jsonObject.getLong("passageway");// 通道
			Double value = jsonObject.getDouble("value");
			String time = jsonObject.getString("time");
			String equipmentId = AssemblyEquipmentNumber
					.assemblyequipmentnumber(park_id, greenhouse_id,
							ctrl_or_sample, type, passageway);
			// EquipmentService equipmentService = new EquipmentServiceImpl();
			Equipment equipment = equipmentService
					.findEquipmentByEquipmentId(equipmentId);

			if (equipment != null) {
				// 如果有这个设备就保存数据
				Date date = null;
				try {
					date = DateUtil.parseDate(time, "yyyy-MM-dd HH:mm:ss");
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

				SensorData sensorData = new SensorData(null, equipment, date,
						value, SysConstants.DATE_TYPE_MONTH_TIME, null,
						SysConstants.DEL_NO);
				sensorDataService.save(sensorData);
				sucess();

			} else {
				// 返回0
				fail();
			}

		} else {
			fail();
		}

	}

	private void fail() {
		try {
			OutputStream outputStream = this.response.getOutputStream();
			outputStream.write("0".getBytes());
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设备状态接口
	 */
	public void equStatus() {
		String jsonstr = request.getParameter("json");
		if (!TextUtil.isEmpty(jsonstr)) {
			// 如果不为空进行操作
			JSONObject jsonObject = JSONObject.fromObject(jsonstr);
			Integer park_id = jsonObject.getInt("park_id");
			Integer greenhouse_id = jsonObject.getInt("greenhouse_id");
			Long ctrl_or_sample = jsonObject.getLong("ctrl_or_sample");
			Long type = jsonObject.getLong("type"); // 传感器类型
			Long passageway = jsonObject.getLong("passageway");// 通道
			Long status = jsonObject.getLong("status");
			String equipmentId = AssemblyEquipmentNumber
					.assemblyequipmentnumber(park_id, greenhouse_id,
							ctrl_or_sample, type, passageway);
			// EquipmentService equipmentService = new EquipmentServiceImpl();
			Equipment equipment = equipmentService
					.findEquipmentByEquipmentId(equipmentId);

			if (equipment != null) {
				// 如果有这个设备就保存状态
				equipment.setStatus(status);
				equipmentService.update(equipment);
				sucess();

			} else {
				fail();
			}

		} else {
			fail();
		}

	}
	
	/**
	 * 初始化园区接口
	 */
	public void initPark(){
		String parkid = request.getParameter("parkid");
		String gps = request.getParameter("gps");
		String ip = request.getParameter("ip");
		if ((!TextUtil.isEmpty(parkid))&&(!TextUtil.isEmpty(gps))&&(!TextUtil.isEmpty(ip))){
			Park park = parkService.findParkByParkId(parkid);
			if(park!=null){
				park.setGps(gps);
				park.setTopIp(ip);
				parkService.update(park);
				sucess();
			}else{
				park = new Park();
				park.setParkId(parkid);
				park.setGps(gps);
				park.setTopIp(ip);
				park.setDel(SysConstants.DEL_NO);
				parkService.save(park);
				sucess();
			}
		}else{
			fail();
		}
		
	}
	/**
	 * 初始化大棚的接口
	 */
	public void initGreenhous(){
		String parkid = request.getParameter("parkid");
		String greenhouseid = request.getParameter("greenhouseid");
		if ((!TextUtil.isEmpty(parkid))&&(!TextUtil.isEmpty(greenhouseid))){
			Park park = parkService.findParkByParkId(parkid);
			if(park!=null){
				Greenhouse greenhouse = greenhouseService.findGreenhouseByGreenhouseIdAndpid(park.getId(),greenhouseid);
				if(greenhouse!=null){
					sucess();
				}else{
					greenhouse = new Greenhouse();
					
					greenhouse.setPark(park);
					greenhouse.setGreenhouseId(greenhouseid);
					greenhouse.setDel(SysConstants.DEL_NO);
					greenhouseService.save(greenhouse);
					sucess();
				}
				
			}else{
				fail();
			}
			
		}else{
			fail();
		}
		
	}
	
	
	/**
	 * 初始化设备接口
	 */
	
	public void initEquipment(){
		String parkid = request.getParameter("parkid");
		String greenhouseid = request.getParameter("greenhouseid");
		String ctrlorsam = request.getParameter("ctrlorsam");
		String type = request.getParameter("type");
		String passway = request.getParameter("passway");
		if ((!TextUtil.isEmpty(parkid))&&(!TextUtil.isEmpty(greenhouseid))&&(!TextUtil.isEmpty(ctrlorsam))&&(!TextUtil.isEmpty(type))&&(!TextUtil.isEmpty(passway))){
			try{
				Long parkidnum = Long.parseLong(parkid);
				Long greenhouseidnum = Long.parseLong(greenhouseid);
				Long ctrlorsamnum = Long.parseLong(ctrlorsam);
				Integer typenum = Integer.parseInt(type);
				Long passwaynum = Long.parseLong(passway);
				
				
				Park park = parkService.findParkByParkId(parkid);
				if(park!=null){
					Greenhouse greenhouse = greenhouseService.findGreenhouseByGreenhouseIdAndpid(park.getId(),greenhouseid);
					if(greenhouse!=null){
						String equipmentid = AssemblyEquipmentNumber.equipmentnumber(parkidnum, greenhouseidnum, ctrlorsamnum, typenum,passwaynum);
						Equipment equipment = equipmentService.findEquipmentByEquipmentId(equipmentid);
						if(equipment!=null){
							sucess();
						}else{
							equipment = new Equipment();
							equipment.setGreenhouse(greenhouse);
							equipment.setEquipmentId(equipmentid);
							equipment.setCtrlOrSample(ctrlorsamnum);
							equipment.setType((long)typenum);
							equipment.setDel(SysConstants.DEL_NO);
							equipmentService.save(equipment);
						}
						
						
					}else{
						fail();
					}
					
				}else{
					fail();
				}
			}catch (NumberFormatException e) {
				fail();
			}
		}else{
			fail();
		}
		
	}
	
	
	
	

}
