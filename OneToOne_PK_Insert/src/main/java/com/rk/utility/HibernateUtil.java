package com.rk.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory factory;
	
	static {
		Configuration cfg=null;
		StandardServiceRegistryBuilder builder=null;
		ServiceRegistry registry=null;
		try {
			
			//boot strap hibernate
			 cfg=new Configuration();
			 cfg.configure("com/rk/cfgs/hibernate.cfg.xml");
			 
			System.out.println("cfgs is complted");
			 
			//add Hibernate mapping files
		      cfg.addResource("com/rk/entity/Student.hbm.xml");
		      cfg.addResource("com/rk/entity/LibraryMembership.hbm.xml");
		    System.out.println("mapping file completed"); 
		    
	         //build ServiceRegistry
			 builder=new StandardServiceRegistryBuilder();
			
			 //create ServiceRegistry
			 registry=builder.applySettings(cfg.getProperties()).build();
			 
			 //build SessionFactory
			 factory=cfg.buildSessionFactory(registry);
		}//try
		catch(HibernateException he) {
			System.out.println("session is not created");
			he.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("session is not created");
			e.printStackTrace();
		}
	}//static
	
	public static  Session getSession() {
		Session ses=null;
		if(factory!=null)
			ses=factory.getCurrentSession();
		System.out.println("session is created completly");
		return ses;
	}
	
	public  static void   closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}

}//class
