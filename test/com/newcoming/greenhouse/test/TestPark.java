package com.newcoming.greenhouse.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.newcoming.greenhouse.domain.Equipment;
import com.newcoming.greenhouse.domain.Greenhouse;
import com.newcoming.greenhouse.domain.Park;
import com.newcoming.greenhouse.domain.SensorData;
import com.newcoming.greenhouse.domain.User;
import com.newcoming.greenhouse.util.DateUtil;
import com.newcoming.greenhouse.util.QueryHelper;
import com.newcoming.greenhouse.view.action.ParkAction;

public class TestPark {

	@Test
	public void test() throws Exception {
		Configuration config=new Configuration().configure();
		SessionFactory sessionFactory=config.buildSessionFactory();	
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		//更改控制设备的状态
	/*	Query query=session.createQuery("update Equipment e set status=0 where e.equipmentId = '1#01010101'");
		query.executeUpdate();
		ts.commit();*/

		Query query = 
		session.createQuery("select s from SensorData s " +
				"join s.equipment e where e.id = ? " +
				"and s.del = 0 " +
				"order by s.time desc limit 0,1");
		query.setParameter(0,(long)21);
		List<SensorData> list = query.list();
		System.out.println(list.get(0).getValue());
		System.out.println(list.get(1).getValue());
		
		/*
		List<SensorData> list = 
				session.createQuery("select s from SensorData s join s.equipment e where e.id = ? and s.del = 0 order by s.time desc limit 0,1").setParameter(0,(long)1).list();*/

		//实时查询传感器值
		//select * from tablename order by orderfield desc/asc limit 0,15
		//Query query = 
		//session.createQuery("select s from SensorData s join s.equipment e where e.equipmentId='1#01010102' and e.del=0 order by s.time desc limit 0,1");
		//List<SensorData> list = query.list();
		//SensorData sensorData = (SensorData) query.uniqueResult();
		//System.out.println(list.get(0).getTime());
		
		//查询通道个数
		
	//"SELECT u FROM User u join u.roles r WHERE r.id=5 or r.id=11854"
		//SELECT COUNT(*) FROM Park p join p.greenhouses g join g.users u WHERE u.id=26
		/*Query query = 
	session.createQuery("select s from SensorData s join s.equipment e where e.equipmentId='111211' and e.del=2");
		SensorData sensorData = (SensorData) query.uniqueResult();
		System.out.println(sensorData.getValue());*/
        
		
		
		//实时数据查询
		//select * from tablename order by orderfield desc/asc limit 0,15
        
/*//		Query query =session.createQuery("SELECT g FROM Greenhouse g join g.users u WHERE u.id=2");
//		System.out.println(((Greenhouse)query.list().get(0)).getGreenhouseName());
*/		
		
		/*
		 * from DevDeviceStop dds where dds.stpregdate >= to_date("
+ "'"+startdate+"','yyyy-mm-dd')"+" and dds.stpdate <= to_date('" + overdate + "','yyyy-mm-dd')"
		 */
	//
		
	/*	近一天
	Query query =
		session.createQuery("SELECT s FROM SensorData s WHERE s.time BETWEEN FROM_UNIXTIME((UNIX_TIMESTAMP(now())-86400),'%Y-%m-%d %h:%m:%s') AND now()");
	System.out.println(query.list().size());	
*/
	/*	String str = "2000-12-25 23";
		// public SimpleDateFormat(String pattern)
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH");
		// Date parse(String text, ParsePosition pos) 解析字符串的文本，		    生成 Date
	          Date date = s.parse(str);
	          System.out.println(date);*/
		/*SimpleDateFormat s = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
				String date = "2016-04-07 04";
//				String date1 = "2016-04-07 04:01:00";
//				Date dates = s.parse(date);
//				System.out.println(dates);
//				Date dates1 = s.parse(date1);
				for(int i = 0;i<24;i++){
					date = DateUtil.dateGeter(date, 1);
					String currentDate = date+"%";
					//if(currentDate.contains("00"))
						//currentDate = currentDate.substring(0,10)+currentDate.substring(13,14);
				//	System.out.println(currentDate);
					Query query = 
							session.createQuery("SELECT s FROM SensorData s  "
									+ "join s.equipment e "
									+ "WHERE e.equipmentId='1#01010102'"
//									+ "and s.time like to_date('2016-04-07','yyyy-mm-dd')"
									+ "and  to_char(s.time,'YYYY-MM-DD HH24:MI:SS') like ?"
									+ "and e.del=0 "
									);
					query.setParameter(0, currentDate);
				//	query.setParameter(1, date1);
					System.out.println(((SensorData)query.list().get(0)).getTime());*/
	}	

}
