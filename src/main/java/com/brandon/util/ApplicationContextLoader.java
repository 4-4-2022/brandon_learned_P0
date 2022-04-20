package com.brandon.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextLoader {

	private static ApplicationContext context;
	
	public static ApplicationContext grabContext() {
		
		if (context == null) {
			context = new ClassPathXmlApplicationContext("applicationContext.xml");
		}
		
		return context;
	}
	
}
