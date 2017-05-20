package com.newcoming.greenhouse.util;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.newcoming.greenhouse.domain.Privilege;
import com.newcoming.greenhouse.domain.User;

@Component
public class Installer {
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Transactional
	public void install(){
		Session session = sessionFactory.getCurrentSession();
		
		// =============================================
		// 保存超级管理员用户
		User user = new User();
		user.setLoginName("admin");
		user.setPassword(DigestUtils.md5Hex("123456"));
		user.setName("超级管理员");
		session.save(user);
		
		// =============================================
		// 保存数据
		Privilege menu,menu1,menu2,menu3,menu4,menu5,menu6; 
		
		menu = new Privilege("基础信息管理",null,null);
		menu1 = new Privilege("园区信息管理","/park_index",menu);
		menu2 = new Privilege("大棚信息管理","/greenhouse_index",menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		
		session.save(new Privilege("园区信息查询","/park_query",menu1));
		session.save(new Privilege("园区信息添加","/park_add",menu1));
		session.save(new Privilege("园区信息修改","/park_edit",menu1));
		session.save(new Privilege("园区信息删除","/park_delete",menu1));
		
		session.save(new Privilege("大棚信息查询","/greenhouse_query",menu2));
		session.save(new Privilege("大棚信息添加","/greenhouse_add",menu2));
		session.save(new Privilege("大棚信息修改","/greenhouse_edit",menu2));
		session.save(new Privilege("大棚信息删除","/greenhouse_delete",menu2));
		
		// ---------------------------实时数据管理-------------
		menu = new Privilege("实时数据管理",null,null);
		menu1 = new Privilege("实时设备控制","/equipment_index",menu);
		menu2 = new Privilege("实时信息采集","/realtime_index",menu);
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		//--------------------------历史数据管理---------------
		menu = new Privilege("历史数据管理",null,null);
		menu1 = new Privilege("历史数据查看","/history_index",menu);
		session.save(menu);
		session.save(menu1);
	
		// -----------------------------系统管理-------------------------------------------------
		menu = new Privilege("系统管理",null,null);
		menu2 = new Privilege("角色管理","/role_index",menu);
		menu3 = new Privilege("用户管理","/user_index",menu);
		menu4 =  new Privilege("阈值管理","/threshold_index",menu);
		
		session.save(menu);
		session.save(menu1);
		session.save(menu2);
		session.save(menu3);
		session.save(menu4);
		session.save(new Privilege("角色添加","/role_add",menu2));
		session.save(new Privilege("角色修改","/role_edit",menu2));
		session.save(new Privilege("角色删除","/role_delete",menu2));
		session.save(new Privilege("设置权限","/role_setPrivilege",menu2));
		
		session.save(new Privilege("用户添加","/user_add",menu3));
		session.save(new Privilege("用户修改","/user_edit",menu3));
		session.save(new Privilege("用户删除","/user_delete",menu3));
		session.save(new Privilege("初始化密码","/user_initPassword",menu3));
		
		
		//session.save(menu4);
//		
//		// -----------------------------园区管理-------------------------------------------------
//		menu = new Privilege("园区管理",null,null);
//		menu1 = new Privilege("园区基本信息管理","/park_index",menu);
//		session.save(menu1);
//		session.save(menu);
//		session.save(new Privilege("园区列表", "/park_list", menu1));
//		session.save(new Privilege("园区添加", "/park_add", menu1));
//		session.save(new Privilege("园区修改", "/park_edit", menu1));
//		session.save(new Privilege("园区删除", "/park_delete", menu1));
//////		
////		// -----------------------------大棚管理-------------------------------------------------
//		menu = new Privilege("大棚管理",null,null);
//		menu1 = new Privilege("大棚基本信息管理","/greenhouse_index",menu);
//		session.save(menu1);
//		session.save(menu);
//		session.save(new Privilege("大棚列表", "/greenhouse_list", menu1));
//		session.save(new Privilege("大棚添加", "/greenhouse_add", menu1));
//		session.save(new Privilege("大棚修改", "/greenhouse_edit", menu1));
//		session.save(new Privilege("大棚删除", "/greenhouse_delete", menu1));
//////		
////		// -----------------------------实时管理-------------------------------------------------
////		menu = new Privilege("实时管理",null,null);
////		menu1 = new Privilege("实时基本数据管理","/realtime_index",menu);
////		session.save(menu1);
////		session.save(menu);
////		session.save(new Privilege("实时数据列表", "/park_list", menu1));
////		
//		/*
//	
//		*/
//	
////		
//		// -----------------------------系统管理-------------------------------------------------
//		menu = new Privilege("系统管理",null,null);
//		menu2 = new Privilege("角色管理","/role_index",menu);
//		session.save(menu);
//		menu3 = new Privilege("用户管理","/user_index",menu);
//		session.save(menu2);
//		session.save(menu3);
//		session.save(new Privilege("角色添加","/role_add",menu2));
//		session.save(new Privilege("角色修改","/role_edit",menu2));
//		session.save(new Privilege("角色删除","/role_delete",menu2));
//		session.save(new Privilege("设置权限","/role_setPrivilege",menu2));
//		
//		session.save(new Privilege("用户添加","/user_add",menu3));
//		session.save(new Privilege("用户修改","/user_edit",menu3));
//		session.save(new Privilege("用户删除","/user_delete",menu3));
//		session.save(new Privilege("初始化密码","/user_initPassword",menu3));
//	
	}
	
	/**
	 * 初始化系统数据，生命周期只有一次
	 */
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Installer installer = (Installer) ac.getBean("installer");
		installer.install();
	}
	
}
