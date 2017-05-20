package com.newcoming.greenhouse.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.newcoming.greenhouse.base.BaseAction;
import com.newcoming.greenhouse.domain.PageBean;
import com.newcoming.greenhouse.domain.Park;
import com.newcoming.greenhouse.util.QueryHelper;
import com.newcoming.greenhouse.util.TextUtil;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class ParkAction extends BaseAction<Park> {

//	private Long departmentId;
//	private Long[] greenhousesIds;
//	private Long[] roleIds;
	
	/** 首页 */
	public String index() throws Exception {
		return "index";
	}
	
	/** 列表 */
	public String list() throws Exception {
//FROM Park p join p.greenhouses g join g.users u WHERE u.id=2
//getCurrentUser().getId()
		// 准备分页信息
		ActionContext.getContext().getValueStack().push(
				new PageBean(pageNum, pageSize, 
						parkService.getParkNums(getCurrentUser().getId()).intValue(), 
						parkService.getParks(getCurrentUser().getId(),model,
								pageSize,
								pageNum)));
		
//		new QueryHelper("Park", "p")
//			.addCondition("p.id", " select gh.parkid from greenhouse_user u , greenhouse_greenhouse gh,greenhouse_user_greenhouse ugh"
//					+ " where u.id=ugh.userid and gh.id=ugh.greenhouseid) ")
		
		
		return "list";
	}
	/** 查询界面 */
	public String queryUI() throws Exception {
		return "queryUI";
	}
	
	
	/** 删除 */
	public String delete() throws Exception {
//		userService.delete(model.getId());
		Park park = parkService.getById(model.getId());
		park.setDel((long)1);
		parkService.update(park);
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		return "saveUI";
	}

	
	/** 添加 */
	public String add() throws Exception {
		return "toList";
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		return "saveUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		// 1，从数据库中取出原对象
		Park park = parkService.getById(model.getId());

		// 2，设置要修改的属性
		park.setName(model.getName());
		park.setChaBy(getCurrentUser());
		park.setRemark(model.getRemark());
		parkService.update(park);

		return "toList";
	}




//	}
	
	// -----------------------------


}
