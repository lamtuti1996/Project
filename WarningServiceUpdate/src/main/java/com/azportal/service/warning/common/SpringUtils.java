package com.azportal.service.warning.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtils {

	private static ApplicationContext springContext = null;
	private static String[] springConfigFiles = {"spring-dao-config.xml", "spring-common-config.xml"};
	
	public static ApplicationContext getSpringContext() {
		return springContext;
	}
	
	static {
		springContext = (ApplicationContext) new ClassPathXmlApplicationContext(springConfigFiles);
	}
	
	
	public static Object getBean(String name) {
		return springContext.getBean(name);
	}
	
	
//	ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao-config.xml");
	
//	ClassPathResource classPathResource = new ClassPathResource(
//	"spring-dao-config.xml");
//XmlBeanFactory beanFactory = new XmlBeanFactory(classPathResource);

//	userDao = (UserDAO) context.getBean("userDao");
	
}
