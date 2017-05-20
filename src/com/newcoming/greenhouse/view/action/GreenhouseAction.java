package com.newcoming.greenhouse.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.newcoming.greenhouse.base.BaseAction;
import com.newcoming.greenhouse.domain.Greenhouse;
import com.newcoming.greenhouse.domain.PageBean;
import com.newcoming.greenhouse.domain.Park;
import com.newcoming.greenhouse.util.QueryHelper;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class GreenhouseAction extends BaseAction<Greenhouse> {

//	private Long departmentId;
//	private Long[] greenhousesIds;
//	private Long[] roleIds;
	private Long parkId;
	private Long greenhouseId;
	private int    equipmentKind;
	List<Park> parks ;
	List<Greenhouse> greenhouses;
	/** 首页 */
	public String index() throws Exception {
		return "index";
	}
	
	/** 列表 */
	public String list() throws Exception {

		// 准备分页信息
		ActionContext.getContext().getValueStack().push(new PageBean(pageNum, pageSize,greenhouseService.getGreenhouseNums(getCurrentUser().getId()).intValue(), greenhouseService.getGreenhouses(getCurrentUser().getId(),model,pageSize,pageNum)));
		return "list";
	}

	/** 查询界面 */
	public String queryUI() throws Exception {
		return "queryUI";
	}
	
	
	/** 删除 */
	public String delete() throws Exception {
//		userService.delete(model.getId());
		Greenhouse greenhouse = greenhouseService.getById(model.getId());
		greenhouse.setDel((long) 0);
		greenhouseService.update(greenhouse);
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {

		return "saveUI";
	}

	
	/** 添加 */
	public String add() throws Exception {
	
			return "toList";
//		}
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		return "saveUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		// 1，从数据库中取出原对象
		Greenhouse greenhouse = greenhouseService.getById(model.getId());

		// 2，设置要修改的属性
		greenhouse.setName(model.getName());
		greenhouse.setChaBy(getCurrentUser());
		greenhouse.setRemark(model.getRemark());
		greenhouseService.update(greenhouse);
		return "toList";
	}




//	}
	
	// -----------------------------


}
