package com.rk.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rk.entity.Doctor;
import com.rk.entity.Patient;
import com.rk.utility.HibernateUtil;

public class ManyToManyDAOImpl implements ManyToManyDAO{

	@Override
	public void deleteSpecificChildFromSpecifcParent() {
		
		//get Session
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
			
		try {
				if(!ses.getTransaction().isActive())
				{
					tx=ses.beginTransaction();
					
				//Load parent
				Doctor doctor=ses.get(Doctor.class,1);
	
				//get childs
				Set<Patient> childs=doctor.getPatients();
				
				//Load specific  child
				Patient patient=ses.get(Patient.class,3);
				childs.remove(patient);
				flag=true;
					
				}//if
		}//try
		
		catch(HibernateException he) {
		 he.printStackTrace();
		 flag=false;
		}
		catch(Exception e) {
		e.printStackTrace();
		}
		
		finally {
				if(flag) {
					tx.commit();
						System.out.println(" deleted specific child of that parent"); 
					}
					else {
						tx.rollback();
						System.out.println(" not deleted");
					}
				
					//close SessionFactory
					HibernateUtil.closeSessionFactory();
				
		}//finally
		
	}//method

	@Override
	public void deleteAllChildsOfAParent() 
	{
		
		//get Session
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		
		try {
				if(!ses.getTransaction().isActive())
					tx=ses.beginTransaction();
		
				//Load parent
				Doctor doctor=ses.get(Doctor.class,2);
				
				//get childs
				Set<Patient> childs=doctor.getPatients();
				childs.removeAll(childs);
				flag=true;
			
		}//try
		catch(HibernateException he) {
			 he.printStackTrace();
			 flag=false;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			if(flag) {
				tx.commit();
				System.out.println(" deleted"); 
			}
			else {
				tx.rollback();
				System.out.println(" not deleted");
			}
		
			//close SessionFactory
			HibernateUtil.closeSessionFactory();
		
		}//finally
		
	}//method
}//class
