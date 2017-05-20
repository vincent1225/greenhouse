package com.newcoming.greenhouse.service;

import java.util.List;

import com.newcoming.greenhouse.base.DaoSupport;
import com.newcoming.greenhouse.domain.Park;

public interface ParkService extends DaoSupport<Park> {
	/*
	 * 通过用户id查找园区数量
	 */
	public Long getParkNums(Long userId);
	/**
	 * 通过园区编号查找园区
	 */
	public Park findParkByParkId(String parkId);
	/*
	 * 通过用户id查找关联的所有园区
	 */
	public List<Park> getAllParks(Long userId);
	/*
	 * 通过用户id查找关联的所有园区,分页显示
	 */
	public List<Park> getParks(Long userId,Park model,int pageSize,int pageNum);

}
