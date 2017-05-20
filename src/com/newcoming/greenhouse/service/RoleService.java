package com.newcoming.greenhouse.service;

import com.newcoming.greenhouse.base.DaoSupport;
import com.newcoming.greenhouse.domain.Role;

public interface RoleService extends DaoSupport<Role> {

	Role getByName(long id, String name);
}
