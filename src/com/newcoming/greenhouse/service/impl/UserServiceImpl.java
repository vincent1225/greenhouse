package com.newcoming.greenhouse.service.impl;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newcoming.greenhouse.base.DaoSupportImpl;
import com.newcoming.greenhouse.domain.User;
import com.newcoming.greenhouse.service.UserService;

@Service
@Transactional
@SuppressWarnings("unchecked")
public class UserServiceImpl extends DaoSupportImpl<User> implements
		UserService {

	public User findByLoginNameAndPassword(String loginName, String password) {
		// 使用密码的MD5摘要进行对比
		String md5Digest = DigestUtils.md5Hex(password);
		return (User) getSession().createQuery(//
				"FROM User u WHERE u.loginName=? AND u.password=?")//
				.setParameter(0, loginName)//
				.setParameter(1, md5Digest)//
				.uniqueResult();
	}
	
	/**
	 * 不使用md5加密的用户登录验证
	 */
	@Override
	public User findByLoginNameAndPasswordNoMd5(String loginName,
			String password) {
		return (User) getSession().createQuery(//
				"FROM User u WHERE u.loginName=? AND u.password=?")//
				.setParameter(0, loginName)//
				.setParameter(1, password)//
				.uniqueResult();
	}

	public User getbyLoginName(String loginName) {
		return (User) getSession().createQuery(//
				"FROM User u WHERE u.loginName=?")//
				.setParameter(0, loginName)//
				.uniqueResult();
	}

	public List<User> getChargers() {
		return (List<User>) getSession()
				.createQuery(//
						"SELECT u FROM User u join u.roles r WHERE r.id=5 or r.id=11854")//
				.list();
	}

}
