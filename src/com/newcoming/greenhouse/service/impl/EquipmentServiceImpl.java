package com.newcoming.greenhouse.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newcoming.greenhouse.base.DaoSupportImpl;
import com.newcoming.greenhouse.base.SysConstants;
import com.newcoming.greenhouse.domain.Equipment;
import com.newcoming.greenhouse.service.EquipmentService;

@Service
@Transactional
public class EquipmentServiceImpl extends DaoSupportImpl<Equipment> implements
		EquipmentService {

	@Override
	public Equipment findEquipmentByEquipmentId(String equipmentId) {

		return (Equipment) getSession()
				.createQuery("from Equipment where equipmentId=? and del=?")
				.setParameter(0, equipmentId)
				.setParameter(1, SysConstants.DEL_NO).uniqueResult();

	}

	@Override
	public Long findPassagewayCount(String likeEquipmentId) {
		//查询通道个数
		return (Long) getSession().createQuery("SELECT COUNT(*) FROM Equipment e WHERE e.equipmentId like ? and e.del=?")
				.setParameter(0, likeEquipmentId)
				.setParameter(1, SysConstants.DEL_NO).uniqueResult();
						
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Equipment>findEquipmentsBygreenhouseIdAndEtype(Long greenhouse_id,Long equipmentType) {
	return getSession().createQuery("SELECT e from Equipment e "
						+ "join e.greenhouse g "
						+ "where g.id = ? "
						+ "and e.type = ? "
						+ "and e.del = ? ")
				.setParameter(0,greenhouse_id)
				.setParameter(1, equipmentType)
				.setParameter(2, SysConstants.DEL_NO)
				.list();
	}

	@Override
	public Equipment findEquipmentByLikeEquipmentId(String likeEquipmentId) {
		return (Equipment) getSession()
				.createQuery("SELECT e from Equipment e where e.equipmentId like ? and del=?")
				.setParameter(0, likeEquipmentId)
				.setParameter(1, SysConstants.DEL_NO)
				.list()
				.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Equipment> findEquipmentListByLikeEquipmentId(
			String likeEquipmentId) {
		List<Equipment> list = getSession().createQuery("SELECT e from Equipment e where e.equipmentId like ? and del=?")
						.setParameter(0, likeEquipmentId)
						.setParameter(1, SysConstants.DEL_NO)
						.list();
		return list;
	}


	
	
}
