package com.newcoming.greenhouse.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.newcoming.greenhouse.base.BaseAction;
import com.newcoming.greenhouse.domain.EquipmentCmd;
import com.newcoming.greenhouse.domain.Park;
import com.newcoming.greenhouse.util.QueryHelper;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class EquipmentAction extends BaseAction<EquipmentCmd> {

//	private Long departmentId;
//	private Long[] greenhousesIds;
//	private Long[] roleIds;
	
	/** 首页 */
	public String index() throws Exception {
		return "index";
	}
	
	/** 列表 */
	public String list() throws Exception {
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
			return "toList";
//		}
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		return "saveUI";
	}

	/** 修改 */
	public String edit() throws Exception {

		return "toList";
	}

}
