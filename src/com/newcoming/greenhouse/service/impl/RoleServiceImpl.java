package com.newcoming.greenhouse.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newcoming.greenhouse.base.DaoSupportImpl;
import com.newcoming.greenhouse.domain.Role;
import com.newcoming.greenhouse.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl extends DaoSupportImpl<Role> implements RoleService {

	public Role getByName(long id, String name) {
		return (Role) getSession().createQuery( //
				"FROM Role r WHERE r.id != ? and r.name=?") //
				.setParameter(0, id) //
				.setParameter(1, name) //
				.uniqueResult();
	}


}
