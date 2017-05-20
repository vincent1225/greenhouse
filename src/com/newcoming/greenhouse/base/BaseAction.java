package com.newcoming.greenhouse.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.newcoming.greenhouse.domain.User;
import com.newcoming.greenhouse.service.EquipmentService;
import com.newcoming.greenhouse.service.GreenhouseService;
import com.newcoming.greenhouse.service.ParkService;
import com.newcoming.greenhouse.service.PrivilegeService;
import com.newcoming.greenhouse.service.RoleService;
import com.newcoming.greenhouse.service.SensorDataService;
import com.newcoming.greenhouse.service.UserService;
import com.newcoming.greenhouse.util.Pinyin4jUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings({ "unchecked", "serial" })
public abstract class BaseAction<T> extends ActionSupport implements
		ModelDriven<T>, ServletRequestAware, ServletResponseAware {

	protected HttpServletRequest request = null;
	protected HttpServletResponse response = null;

	public void setServletRequest(HttpServletRequest req) {
		this.request = req;
	}

	public void setServletResponse(HttpServletResponse res) {
		this.response = res;
	}

	// =============== ModelDriven的支持 ==================

	protected T model;

	public BaseAction() {
		try {
			// 通过反射获取model的真实类型
			ParameterizedType pt = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
			// 通过反射创建model的实例
			model = clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public T getModel() {
		return model;
	}

	// =============== Service实例的声明 ==================
	@Resource
	protected RoleService roleService;
	@Resource
	protected UserService userService;
	@Resource
	protected PrivilegeService privilegeService;
	@Resource
	protected ParkService parkService;
	@Resource
	protected GreenhouseService greenhouseService;
	@Resource
	protected EquipmentService equipmentService;
	@Resource
	protected SensorDataService sensorDataService;

	/**
	 * 获取当前登录的用户
	 * 
	 * 
	 * @return
	 */
	protected User getCurrentUser() {
		return (User) ActionContext.getContext().getSession().get("user");
	}

	/** 获取汉字拼音简码 */
	public String getPinYin() throws Exception {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
			String chinese = request.getParameter("chinese");
			String py = Pinyin4jUtil.getPinyinJianPin(chinese);
			PrintWriter out = response.getWriter();
			out.println(py);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/** 存在重复数据,提示对话框 */
	protected void returnDialog(String msg) throws IOException {
		//
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script>alert('" + msg + "');history.go(-1);</script>");
		out.flush();
		out.close();
	}

	// ============== 分页用的参数 =============

	protected int pageNum = 1; // 当前页
	protected int pageSize = 16; // 每页显示多少条记录

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
