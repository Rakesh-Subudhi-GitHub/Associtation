package com.rk.dao;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.Company;
import com.rk.entity.Project;
import com.rk.utility.HibernateUtil;

public class OneToMany_ManyToOne_Bi_DAOImpl implements OneToMany_ManyToOne_Bi_DAO{

@Override
public void saveDataUsingChilds() {
		
	//get Session
	Session ses=HibernateUtil.getSession();
	
	//prepare objects
	//parent set
	Company comp=new Company("Wiport","mumbai","IT");
	
	//child set value
	Project proj1=new Project("Aadhar","portfolid",10);
	Project proj2=new Project("FFW","govt",10);
	
	//add childs to parent
	comp.setProjects(Set.of(proj1,proj2));
	
	//add parent to childs
	proj1.setCompany(comp);
	proj2.setCompany(comp);
	
	Transaction tx=null;
	boolean flag=false;
	
	try {
	   //begin tx
		 if(!ses.getTransaction().isActive())
		 tx=ses.beginTransaction();
		
		 //child to save data 
		 ses.save(proj1); 
		 ses.save(proj2);
		
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
		//perform Tx Mgmt
		if(flag) {
			tx.commit();
			System.out.println("Objects are saved");
			}
		else {
	        tx.rollback();
			System.out.println("Objects are not saved");
			}
	
		//close session
		HibernateUtil.closeSessionFactory();
		
	}//finally
		
	}//method
		
	}//class
