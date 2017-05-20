package com.newcoming.greenhouse.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newcoming.greenhouse.base.DaoSupportImpl;
import com.newcoming.greenhouse.base.SysConstants;
import com.newcoming.greenhouse.domain.Greenhouse;
import com.newcoming.greenhouse.domain.Park;
import com.newcoming.greenhouse.service.GreenhouseService;

@Service
@Transactional
public class GreenhouseServiceImpl extends DaoSupportImpl<Greenhouse> implements
		GreenhouseService {
	/*
	 * 通过用户id查找大棚数量
	 */
	@Override
	public Long getGreenhouseNums(Long userId) {
		return (Long) getSession()
				.createQuery(//
						"SELECT COUNT(*) FROM Greenhouse g join g.users u WHERE u.id=?")
				.setParameter(0, userId)//
				.uniqueResult();
	}

	/*
	 * 通过用户id查找关联的所有大棚，分页查询
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Greenhouse> getGreenhouses(Long userId, Greenhouse model,
			int pageSize, int pageNum) {
		if (model.getName() == null) {
			return (List<Greenhouse>) getSession()
					.createQuery(//
							"SELECT g FROM Greenhouse g "
									+ "join g.users u WHERE u.id=? AND g.del=?")
					.setParameter(0, userId)
					//
					.setParameter(1, SysConstants.DEL_NO)
					.setFirstResult((pageNum - 1) * pageSize)// 指定从哪一个对象开始查询
					.setMaxResults(pageSize).list();

		}
		return (List<Greenhouse>) getSession()
				.createQuery(//
						"SELECT g FROM Greenhouse g "
								+ "join g.users u WHERE u.id=? AND g.del=? AND g.name=?")
				.setParameter(0, userId)
				//
				.setParameter(1, (long) 0).setParameter(2, model.getName())
				.setFirstResult((pageNum - 1) * pageSize)// 指定从哪一个对象开始查询
				.setMaxResults(pageSize).list();
	}

	/**
	 * 通过大棚编号查找大棚
	 */
	@Override
	public Greenhouse findGreenhouseByGreenhouseId(String GreenhouseId) {
		return (Greenhouse) getSession()
				.createQuery("from Greenhouse where greenhouseId=? and del=?")
				.setParameter(0, GreenhouseId)
				.setParameter(1, SysConstants.DEL_NO).uniqueResult();
	}

	
	
	/*
	 * 通过用户id查找关联的所有大棚
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Greenhouse> getAllGreenhouses(Long userId) {
		return (List<Greenhouse>) getSession()
				.createQuery(//
						"SELECT g FROM Greenhouse g "
								+ "join g.users u WHERE u.id=? AND g.del=?")
				.setParameter(0, userId)//
				.setParameter(1, SysConstants.DEL_NO).list();
	}

	@Override
	public Greenhouse findGreenhouseByGreenhouseIdAndpid(Long parkid,
			String GreenhouseId) {
		return (Greenhouse) getSession()
				.createQuery("from Greenhouse where greenhouseId=? and park.id=? and del=?")
				.setParameter(0, GreenhouseId)
				.setParameter(1, parkid)
				.setParameter(2, SysConstants.DEL_NO).uniqueResult();
	}
	
	
	
}
