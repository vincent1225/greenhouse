package com.newcoming.greenhouse.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.newcoming.greenhouse.base.SysConstants;
import com.newcoming.greenhouse.domain.Greenhouse;
import com.newcoming.greenhouse.domain.Park;
import com.newcoming.greenhouse.domain.SensorData;
import com.newcoming.greenhouse.domain.User;
import com.newcoming.greenhouse.util.DateUtil;
import com.newcoming.greenhouse.util.QueryHelper;
import com.newcoming.greenhouse.view.action.ParkAction;

public class Testdate {

	@Test
	public void test() throws Exception {
		Configuration config=new Configuration().configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
	//"SELECT u FROM User u join u.roles r WHERE r.id=5 or r.id=11854"
		//SELECT COUNT(*) FROM Park p join p.greenhouses g join g.users u WHERE u.id=26
/*	Query query = 
	session.createQuery("SELECT DISTINCT p FROM Park p join p.greenhouses g join g.users u WHERE u.id=26");
		List<Park> list = query.list();
		for(Park park:list){
			Set<Greenhouse> greenhouse=(Set<Greenhouse>) park.getGreenhouses();
			Iterator<Greenhouse> it = greenhouse.iterator();
			while(it.hasNext()){
				System.out.println(it.next().getGreenhouseId());
			}
		}*/
		
		/*Query query = 
				session.createQuery(//
				"SELECT g FROM Greenhouse g join g.users u WHERE u.id=26 AND g.del=?")
				.setParameter(0, SysConstants.DEL_NO);*/
        
       
        
        
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
		/*String needtime = null;
		Date d = new Date();
		SimpleDateFormat t = 
		new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		needtime = t.format(d);
		System.out.println(needtime);
		
		DateUtil du = new DateUtil();
		for(int i=0;i<24;i++){
			needtime = du.dateGeter(needtime, 1);
			System.out.println(needtime+"   "+i);
		}
		System.out.println(needtime);*/
		
		
		/*Query query =
				session.createQuery("SELECT s FROM SensorData s WHERE s.time ");*/
		
		/**
		 * SELECT * FROM 表名 A
		where a.CreateTime between to_date('2012-10-01 01:00:00','YYYY-MM-DD HH24:MI:SS')
		and to_date('2012-10-01 12:00:00','YYYY-MM-DD HH24:MI:SS')
		and to_char(CreateTime,'SS') = '00' 
		-- 秒位上数据为'00'的，这样非00秒比如05,10等其它的就过滤掉了
		 */
		
		/**
		 * DELIMITER $$
			DROP PROCEDURE IF EXISTS proc_HTAH01A_sampleData $$
			CREATE DEFINER=`root`@`localhost` PROCEDURE proc_HTAH01A_sampleData(IN timeBegin DATETIME, IN timeEnd DATETIME, IN timeInterval INT)
    		BEGIN
        	SET @time := '1000-01-01 00:00:00';
        	SET @interval := timeInterval;
        	SELECT * FROM HTAH01A
        	WHERE HTAH01A060 >= timeBegin AND HTAH01A060 <= timeEnd
        	AND TIMESTAMPDIFF( SECOND, @time, HTAH01A060 ) >= @interval
        	AND @time := htah01a060;
    		END$$
			DELIMITER ;
		 */
		/**
		 * MYSQL计算时间间隔——————TimeStampDiff()TIMESTAMPDIFF(unit,datetime_expr1,datetime_expr2)，
		 * 其中unit单位有如下几种:SECOND,MINUTE,HOUR,DAY,WEEK,MONTH,QUARTER,YEAR
		 */
		Query query =
				session.createQuery("SELECT s FROM SensorData s " +
						"WHERE s.time BETWEEN FROM_UNIXTIME((UNIX_TIMESTAMP(now())-86400)," +
						"'%Y-%m-%d %h:%m:%s') AND now()"+
						"AND TIMESTAMPDIFF( SECOND,'1000-01-01 00:00:00', s.time) >= 2");
		List<SensorData> list = query.list();
		System.out.println(list.size());
	
	}	
}
