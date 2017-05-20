package com.newcoming.greenhouse.service;

import java.util.List;

import com.newcoming.greenhouse.base.DaoSupport;
import com.newcoming.greenhouse.domain.User;

public interface UserService extends DaoSupport<User> {

	/**
	 * 根据登录名与密码查询用户
	 * 
	 * @param loginName
	 * @param password
	 *            明文密码
	 * @return
	 */
	User findByLoginNameAndPassword(String loginName, String password);

	User findByLoginNameAndPasswordNoMd5(String loginName, String password);

	User getbyLoginName(String loginName);

	List<User> getChargers();

}
