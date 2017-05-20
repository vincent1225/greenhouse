package com.newcoming.greenhouse.service;

import java.util.List;

import com.newcoming.greenhouse.base.DaoSupport;
import com.newcoming.greenhouse.domain.Greenhouse;

public interface GreenhouseService extends DaoSupport<Greenhouse> {
	/*
	 * 通过用户id查找大棚数量
	 */
	public Long getGreenhouseNums(Long userId);
	/*
	 * 通过用户id查找关联的所有大棚
	 */
	public List<Greenhouse> getAllGreenhouses(Long userId);
	/*
	 * 通过用户id查找关联的所有大棚，分页查询
	 */
	public List<Greenhouse> getGreenhouses(Long userId,Greenhouse model,int pageSize,int pageNum);	
	/**
	 * 通过大棚编号查找大棚
	 */
	public Greenhouse findGreenhouseByGreenhouseId(String GreenhouseId);
	
	/**
	 *通过大棚编号和，园区id来查找大棚 
	 */
	public Greenhouse findGreenhouseByGreenhouseIdAndpid(Long parkid,String GreenhouseId);
	
	
}
