package com.newcoming.greenhouse.util;

/**
 * 
 * @author Administrator 拼接设备编号的类
 */
public class AssemblyEquipmentNumber {
	public static String assemblyequipmentnumber(Integer park_id,
			Integer greenhouse_id, Long ctrl_or_sample, Long type,
			Long passageway) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(park_id).append("#")
				.append(greenhouse_id < 10 ? "0" : "").append(greenhouse_id)
				.append(ctrl_or_sample < 10 ? "0" : "").append(ctrl_or_sample)
				.append(type < 10 ? "0" : "").append(type)
				.append(passageway < 10 ? "0" : "").append(passageway);

		return stringBuffer.toString().trim();
	}
	
	public static String equipmentnumber(Long park_id,
			Long greenhouse_id, Long ctrl_or_sample, Integer type,
			Long passageway) {
		if(park_id!=null&&greenhouse_id!=null&&ctrl_or_sample!=null&&type!=null&&passageway!=null){
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(park_id).append("#")
				.append(greenhouse_id < 10 ? "0" : "").append(greenhouse_id)
				.append(ctrl_or_sample < 10 ? "0" : "").append(ctrl_or_sample)
				.append(type < 10 ? "0" : "").append(type)
				.append(passageway < 10 ? "0" : "").append(passageway);

		return stringBuffer.toString().trim();
		}
		return null;
	}
	/**
	 * 查询通道数量专用
	 * @param park_id
	 * @param greenhouse_id
	 * @param ctrl_or_sample
	 * @param type
	 * @return
	 */
	public static String equipmentnumber(Long park_id,
			Long greenhouse_id, Long ctrl_or_sample, Integer type) {
		if(park_id!=null&&greenhouse_id!=null&&ctrl_or_sample!=null&&type!=null){
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(park_id).append("#")
				.append(greenhouse_id < 10 ? "0" : "").append(greenhouse_id)
				.append(ctrl_or_sample < 10 ? "0" : "").append(ctrl_or_sample)
				.append(type < 10 ? "0" : "").append(type)
				.append("__");
		return stringBuffer.toString().trim();
		}
		return null;
	}
}
