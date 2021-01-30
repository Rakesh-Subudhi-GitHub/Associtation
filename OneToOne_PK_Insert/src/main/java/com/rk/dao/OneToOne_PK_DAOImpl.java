package com.rk.dao;

import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.LibraryMembership;
import com.rk.entity.Student;
import com.rk.utility.HibernateUtil;

public class OneToOne_PK_DAOImpl implements OneToOne_PK_DAO {

	@Override
	public void saveDataUsingParent() {
		
		//get Session object
		Session ses=HibernateUtil.getSession();
		
		//prepare objects
		//parent data store 
		Student st=new Student("raja","hyd");
		
		//child data store
		LibraryMembership lib=new LibraryMembership("gold",
						                                                                            LocalDate.of(2011, 11, 20),
						                                                                            LocalDate.of(2031,11,20));
		
		//add fk value
		st.setLibraryDetails(lib);
		lib.setStudentDetails(st);
				
		
		Transaction tx=null;
		boolean flag=false;
				
	try {
		if(!ses.getTransaction().isActive())
		{	
			tx=ses.beginTransaction();
		
			//save the parent to
			 ses.save(st);
			 
			flag=true;
		}//if
	}//try
	catch(HibernateException he) {
	flag=false;
	he.printStackTrace();
	}
	catch(Exception e) {
	flag=false;
	e.printStackTrace();
	}
	
	finally {
		if(flag) {
				tx.commit();
				System.out.println("Objects are saved");
				}
		else {
			tx.rollback();
			System.out.println("Objects are not saved");
			}
			
		//close SessionFactory
			HibernateUtil.closeSessionFactory();
		
	}//finally
		
	}//method

	@Override
	public void saveDataUsingChild() {
		
		//get Session object
		Session ses=HibernateUtil.getSession();
				
		//prepare objects
		Student st=new Student("ramesh","hyd");
		
		//child
		LibraryMembership lib=new LibraryMembership("silver",
						                                                                            LocalDate.of(2015, 11, 20),
						                                                                            LocalDate.of(2035,11,20));
		//fk column
		st.setLibraryDetails(lib);
		lib.setStudentDetails(st);
				
		Transaction tx=null;
		boolean flag=false;
				
	try {
		if(!ses.getTransaction().isActive())
		tx=ses.beginTransaction();
	
		//save the child 
		ses.save(lib);
		flag=true;
		
	}//try
	catch(HibernateException he) {
	flag=false;
	he.printStackTrace();
		}
	catch(Exception e) {
	flag=false;
	e.printStackTrace();
	}
	
	finally {
		if(flag) {
			tx.commit();
				System.out.println("Objects are saved");
			}
	else {
		tx.rollback();
		System.out.println("Objects are not saved");
		}
	
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
		
	}//finally
	
	}//method
}//class
