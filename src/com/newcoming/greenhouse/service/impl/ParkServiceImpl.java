package com.newcoming.greenhouse.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newcoming.greenhouse.base.DaoSupportImpl;
import com.newcoming.greenhouse.base.SysConstants;
import com.newcoming.greenhouse.domain.Park;
import com.newcoming.greenhouse.service.ParkService;

@Service
@Transactional
public class ParkServiceImpl extends DaoSupportImpl<Park> implements ParkService {
	/*
	 * 通过用户id查找园区数量
	 */
	public Long getParkNums(Long userId) {
		return (Long) getSession().createQuery(//
				"SELECT COUNT(DISTINCT p) FROM Park p join p.greenhouses g join g.users u WHERE u.id=?")
				.setParameter(0, userId)//
				.uniqueResult();
	}
	/**
	 * 通过园区编号查找园区
	 */
	public Park findParkByParkId(String parkId) {
		return (Park) getSession()
				.createQuery("from Park where parkId=? and del=?")
				.setParameter(0, parkId)
				.setParameter(1, SysConstants.DEL_NO).uniqueResult();
	}
	/**
	 * 通过用户id查找关联的所有园区
	 */
	@SuppressWarnings("unchecked")
	public List<Park> getAllParks(Long userId){
		return (List<Park>) getSession().createQuery(//
				"SELECT DISTINCT p FROM Park p " +
				"join p.greenhouses g join g.users u WHERE u.id=? AND p.del=?")
				.setParameter(0, userId)//
				.setParameter(1, SysConstants.DEL_NO)
				.list();
	}
	/*
	 * 通过用户id查找关联的所有园区,分页显示
	 */
	@SuppressWarnings("unchecked")
	public List<Park> getParks(Long userId, Park model,int pageSize,int pageNum) {
			if(model.getName() == null){
			return (List<Park>) getSession().createQuery(//
					"SELECT DISTINCT p FROM Park p " +
					"join p.greenhouses g join g.users u WHERE u.id=? AND p.del=?")
					.setParameter(0, userId)//
					.setParameter(1, SysConstants.DEL_NO)
					.setFirstResult((pageNum-1)*pageSize)// 指定从哪一个对象开始查询
					.setMaxResults(pageSize)
					.list();

			}
				return (List<Park>) getSession().createQuery(//
						"SELECT DISTINCT p FROM Park p " +
						"join p.greenhouses g join g.users u WHERE u.id=? AND p.del=? AND p.name = ?")
						.setParameter(0, userId)//
						.setParameter(1, (long)0)
						.setFirstResult((pageNum-1)*pageSize)
						.setMaxResults(pageSize)
						.setParameter(2, model.getName())
						.list();
	}
}

