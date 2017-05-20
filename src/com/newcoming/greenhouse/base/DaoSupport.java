package com.newcoming.greenhouse.base;

import java.util.List;

import com.newcoming.greenhouse.domain.PageBean;
import com.newcoming.greenhouse.util.QueryHelper;

public interface DaoSupport<T> {

	/**
	 * 保存实体
	 * @param entity
	 */
	void save(T entity);

	/**
	 * 删除实体
	 * @param id
	 */
	void delete(Long id);

	/**
	 * 更新实体
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 按id查询
	 * @param id
	 * @return
	 */
	
	T getById(Long id);
	/**
	 * 按name查询
	 * @param id
	 * @return
	 */
	T getByName(String name);

	/**
	 * 按name或简码查询
	 * @param name
	 * @return
	 */
	List<T> getByNameOrPy(String name);
	
	/**
	 * 按id查询
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);

	/**
	 * 查询所有
	 * @return
	 */
	List<T> findAll();

	/**
	 * 公共的查询分页信息的方法（最终版）
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param queryHelper
	 *            HQL语句与参数列表
	 * @return
	 */
	PageBean getPageBean(int pageNum, int pageSize, QueryHelper queryHelper);
	
}
