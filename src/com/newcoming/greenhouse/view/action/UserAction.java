package com.newcoming.greenhouse.view.action;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.newcoming.greenhouse.base.BaseAction;
import com.newcoming.greenhouse.domain.Park;
import com.newcoming.greenhouse.domain.Role;
import com.newcoming.greenhouse.domain.User;
import com.newcoming.greenhouse.util.QueryHelper;
import com.newcoming.greenhouse.util.TextUtil;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

//	private Long departmentId;
//	private Long[] greenhousesIds;
//	private Long[] roleIds;
	
	/** 首页 */
	public String index() throws Exception {
		return "index";
	}
	
	/** 列表 */
	public String list() throws Exception {
		// 准备分页信息
		new QueryHelper(User.class, "u")//
					.addCondition(!TextUtil.isEmpty(model.getLoginName()), "u.loginName like ?", model.getLoginName())
					.addCondition(!TextUtil.isEmpty(model.getName()), "u.name like ?", model.getName())
					.addCondition("u.loginName!='admin'")
					.addOrderProperty("u.id", false)         
					.preparePageBean(userService, pageNum, pageSize);
		return "list";
	}
	/** 备注*/
	public String remark() throws Exception {
		return "remark";
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
		// 封装到对象中（当model是实体类型时，也可以使用model，但要设置未封装的属性）
		
				User user = userService.getbyLoginName(model.getLoginName());
				if(user!=null){
					returnDialog("登录用户名已经存在，请重新输入");
					return null;
				}else{
//					// >> 设置关联的角色
//					List<Role> roleList = roleService.getByIds(roleIds);
//					model.setRoles(new HashSet<Role>(roleList));
//					// >> 设置默认密码为1234（要使用MD5摘要）
					String md5Digest = DigestUtils.md5Hex("1234");
					model.setPassword(md5Digest);
					model.setAddBy(getCurrentUser());//设置当前操作员
					//(getCurrentUser().getId());//设置当前操作员
					model.setUserTime(new Date(System.currentTimeMillis()));
			
					// 保存到数据库
					userService.save(model);
					return "toList";
				}
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		return "saveUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		return "toList";
	}
	/** 登录页面 */
	public String loginUI() throws Exception {
		return "loginUI";
	}

	/** 登录 */
	public String login() throws Exception {
		User user = userService.findByLoginNameAndPassword(model.getLoginName().trim(), model.getPassword());
		if (user == null) {
			addFieldError("password", "用户名或密码不正确！");
			return "loginUI";
		} else {
			// 登录用户
			ActionContext.getContext().getSession().put("user", user);
			return "toIndex";
		}
	}

	/** 注销 */
	public String logout() throws Exception {
		ActionContext.getContext().getSession().remove("user");
		return "logout";
	}

}
