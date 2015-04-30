/**
 * 
 */
package com.jsoft.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsoft.service.TimesheetService;
import com.jsoft.util.DateTime;

/**
 * @author Sirimongkol
 *
 */
public class TimesheetTest {
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	private static TimesheetService timesheetService = (TimesheetService)ctx.getBean("timesheetService");
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(timesheetService.getReminds(DateTime.stringtoDate("2014-12-10 00:00:00", "yyyy-MM-dd HH:mm:ss")));
		System.out.println(timesheetService.getReminds(DateTime.stringtoDate(DateTime.dateNow() + " " +  DateTime.timeNow(), "yyyy-MM-dd HH:mm:ss")));

	}

}
