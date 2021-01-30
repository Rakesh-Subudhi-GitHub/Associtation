package com.rk.dao;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.Doctor;
import com.rk.entity.Patient;
import com.rk.utility.HibernateUtil;

public class ManyToManyDAOImpl implements ManyToManyDAO{

	@Override
	public void saveDataUsingParent()
	{
		
		//get session
		Session ses=HibernateUtil.getSession();
		
		//prepare obj
		//Doctor set value
		Doctor d1=new Doctor("raja","apollo","MD");
		Doctor d2=new Doctor("rajesh","KIMS","MD");
		
		//Patient obj
		Patient p1=new Patient("jani","heart");
		Patient p2=new Patient("anil","kidney");
		Patient p3=new Patient("anitha","cancer");
		Patient p4=new Patient("suresh","corona");
		
		//set patients to doctors (Doctor<--patient)
				//Doctors allocates patients
				d1.setPatients(Set.of(p1,p2));
				d2.setPatients(Set.of(p1,p2,p3,p4));
		
		//set doctors to patients(Doctor-->patients)
				//patients allocattes Doctors
				p1.setDoctors(Set.of(d1,d2));
				p2.setDoctors(Set.of(d1,d2));
				p3.setDoctors(Set.of(d2));
				p4.setDoctors(Set.of(d2));
		
				Transaction tx=null;
				boolean flag=false;
				
				try {
					if(!ses.getTransaction().isActive())
					{
						tx=ses.beginTransaction();
					
					//save objects (parent to child)
					ses.save(d1); 
					ses.save(d2);
					
					flag=true;
					
					}//if
				}//try
				
				catch(HibernateException he) {
					he.printStackTrace();
				}
				
				finally {
					//Transaction mgment
					if(flag) {
						tx.commit();
						System.out.println("Objects are saved useing parent");
					}
					else {
						tx.rollback();
						System.out.println("objects are not saved useing parent");
					}
				
					//close SessionFactory
					HibernateUtil.closeSessionFactory();
				
				}//finally
				
	}//method

	@Override
	public void saveDataUsingChild() {
		//get session
				Session ses=HibernateUtil.getSession();
				
				//prepare obj
				//Doctor set value
				Doctor d1=new Doctor("raja","apollo","MD");
				Doctor d2=new Doctor("rajesh","KIMS","MD");
				
				//Patient obj
				Patient p1=new Patient("jani","heart");
				Patient p2=new Patient("anil","kidney");
				Patient p3=new Patient("anitha","cancer");
				Patient p4=new Patient("suresh","corona");
				
				//set patients to doctors (Doctor<--patient)
						//Doctors allocates patients
						d1.setPatients(Set.of(p1,p2));
						d2.setPatients(Set.of(p1,p2,p3,p4));
				
				//set doctors to patients(Doctor-->patients)
						//patients allocattes Doctors
						p1.setDoctors(Set.of(d1,d2));
						p2.setDoctors(Set.of(d1,d2));
						p3.setDoctors(Set.of(d2));
						p4.setDoctors(Set.of(d2));
				
						Transaction tx=null;
						boolean flag=false;
						
						try {
							if(!ses.getTransaction().isActive())
							{
								tx=ses.beginTransaction();
							
							//save objects (parent to child)
							//ses.save(d1); 
							//ses.save(d2);
							
							//save objects (child to parent)
							ses.save(p1); 
							ses.save(p2); 
							ses.save(p3); 
							ses.save(p4);
							flag=true;
							
							}//if
						}//try
						
						catch(HibernateException he) {
							he.printStackTrace();
						}
						
						finally {
							//Transaction mgment
							if(flag) {
								tx.commit();
								System.out.println("Objects are saved useing child");
							}
							else {
								tx.rollback();
								System.out.println("objects are not saved useing child");
							}
						
							//close SessionFactory
							HibernateUtil.closeSessionFactory();
						
						}//finally
		
	}//method
	
}//class
