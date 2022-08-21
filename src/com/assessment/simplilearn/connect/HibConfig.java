package com.assessment.simplilearn.connect;

import java.util.Properties;


import com.assessment.simplilearn.entity.student;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibConfig {
	private static SessionFactory sessionFactory;
public static SessionFactory getSessionFactory() {
	if(sessionFactory==null)
	try {	
	Configuration configuration=new Configuration();
	configuration.setProperties(hibernateProperties());
	
	configuration.addAnnotatedClass(student.class);
	//configuration.addAnnotatedClass(course.class);
	//configuration.addAnnotatedClass(subject.class);
	//configuration.addAnnotatedClass(teacher.class);
		
	ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	sessionFactory= configuration.buildSessionFactory(serviceRegistry);
	
    return sessionFactory;
	}catch (Exception e)
	{
	e.printStackTrace();
	}
	return sessionFactory;
}

private static Properties hibernateProperties() {
	// TODO Auto-generated method stub
	Properties properties=new Properties();
	properties.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
	properties.put(Environment.URL, "jdbc:mysql://localhost:3306/studentData");
	properties.put(Environment.USER, "root");
	properties.put(Environment.PASS,"12345");
	properties.put(Environment.SHOW_SQL,true);
	properties.put(Environment.FORMAT_SQL,true);
	properties.put(Environment.HBM2DDL_AUTO,"update");
	properties.put(Environment.DIALECT,"org.hibernate.dialect.MySQL8Dialect");
	properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
	return properties;
}
}
