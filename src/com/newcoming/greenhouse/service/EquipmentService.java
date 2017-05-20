package com.newcoming.greenhouse.service;

import java.util.List;

import com.newcoming.greenhouse.base.DaoSupport;
import com.newcoming.greenhouse.domain.Equipment;
/**
 * 
 * @author Administrator
 * 	设备的Server接口  Equipment
 */
public interface EquipmentService extends DaoSupport<Equipment> {
	/**
	 * 通过设备编号查找设备
	 */
	Equipment findEquipmentByEquipmentId(String equipmentId);
	
	/**
	 * 通过园区，大棚，设备类型查找通道数量
	 */
	Long findPassagewayCount(String likeEquipmentId);
	
	/**
	 * 通过没有通道的设备编查找设备
	 */
	Equipment findEquipmentByLikeEquipmentId(String likeEquipmentId);
	
	/**
	 * 通过大棚主键和设备类型查找设备
	 * 
	 */
	List<Equipment> findEquipmentsBygreenhouseIdAndEtype(Long greenhouse_id,Long equipmentType);
	
	
	/**
	 * 通过没有通道的设备编号查找到这个园区这个大棚所有的同类型设备来设置阈值的
	 */
	List<Equipment> findEquipmentListByLikeEquipmentId(String likeEquipmentId);
	
	
}
