package com.newcoming.greenhouse.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.newcoming.greenhouse.base.BaseAction;
import com.newcoming.greenhouse.domain.Equipment;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class ThresholdAction extends BaseAction<Equipment> {
	
	/** 首页 */
	public String index() throws Exception {
		return "index";
	}
	
	/** 列表 */
	public String list() throws Exception {
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

	/** 修改页面 */
	public String editUI() throws Exception {
		return "saveUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		return "toList";
	}

}
