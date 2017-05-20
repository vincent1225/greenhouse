package com.newcoming.greenhouse.view.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.newcoming.greenhouse.base.BaseAction;
import com.newcoming.greenhouse.domain.Privilege;
import com.newcoming.greenhouse.domain.Role;
import com.newcoming.greenhouse.util.QueryHelper;
import com.newcoming.greenhouse.util.TextUtil;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {

//	private Long departmentId;
//	private Long[] greenhousesIds;
//	private Long[] roleIds;
	private Long[] privilegeIds;
	
	/** 首页 */
	public String index() throws Exception {
		return "index";
	}
	
	/** 列表 */
	public String list() throws Exception {

		// 准备分页信息
		new QueryHelper(Role.class, "r")//
		.addCondition(!TextUtil.isEmpty(model.getName()),
					"h.name LIKE ? ", "%" + model.getName() + "%")//
		.preparePageBean(roleService, pageNum, pageSize);
		return "list";
	}
	/** 查询界面 */
	public String queryUI() throws Exception {
		return "queryUI";
	}
	
	
	/** 删除 */
	public String delete() throws Exception {
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		
		return "saveUI";
	}

	
	/** 添加 */
	public String add() throws Exception {
		// 获取Role对象
				Role role = roleService.getByName(model.getName());
				if (role != null) {
					returnDialog("角色名称已经存在,请重新输入");
					return null;
				} else {
					model.setUserID(getCurrentUser());//设置当前操作员ID
					model.setUserTime(new Date(System.currentTimeMillis()));
					roleService.save(model);
					return "toList";
				}
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		return "saveUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		
		Role role = roleService.getByName(model.getId(),model.getName());
		if(role!=null){
			returnDialog("角色名称已经存在,请重新输入");
			return null;
		}else{
			// 1，从数据库中获取原对象
			role = roleService.getById(model.getId());
	
			// 2，设置要修改的属性
			role.setName(model.getName());
			role.setRemark(model.getRemark());
			role.setUserID(getCurrentUser());//设置当前操作员ID
			role.setUserTime(new Date(System.currentTimeMillis()));
			// 3，更新到数据库
			roleService.update(role);
	
			return "toList";
		}
	}
	/** 设置权限页面 */
	public String setPrivilegeUI() throws Exception {
		// 准备回显的数据
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);

		if (role.getPrivileges() != null) {
			privilegeIds = new Long[role.getPrivileges().size()];
			int index = 0;
			for (Privilege priv : role.getPrivileges()) {
				privilegeIds[index++] = priv.getId();
			}
			
		}

		// 准备数据 privilegeList
		List<Privilege> privilegeList = privilegeService.findAll();
		ActionContext.getContext().put("privilegeList", privilegeList);

		return "setPrivilegeUI";
	}

	/** 设置权限 */
	public String setPrivilege() throws Exception {
		// 1，从数据库中获取原对象
		Role role = roleService.getById(model.getId());

		// 2，设置要修改的属性
		List<Privilege> privilegeList = privilegeService.getByIds(privilegeIds);
		role.setPrivileges(new HashSet<Privilege>(privilegeList));

		// 3，更新到数据库
		roleService.update(role);

		return "index";
	}

	/** 检查角色名称是否唯一存在 */
	public String checkUnique() throws Exception {
		try {
			String status = "";
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
			Long id = model.getId();
			String name = request.getParameter("name");
			Role role = roleService.getByName(id, name);
			if (role != null) {
				status = "1"; // 换热站名称存在
			} else {
				status = "0";
			}
			PrintWriter out = response.getWriter();
			out.println(status);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	//////////////////////******************/
	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

}
