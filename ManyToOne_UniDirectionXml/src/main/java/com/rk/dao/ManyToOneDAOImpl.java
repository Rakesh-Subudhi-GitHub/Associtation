package com.rk.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rk.entity.Department;
import com.rk.entity.EmpDetails;
import com.rk.utility.HibernateUtil;

public class ManyToOneDAOImpl implements ManyToOneDAO{

	@Override
	public void insertRecord_ChildToParent()
	{
		
		//properties
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		
		//get session
		ses=HibernateUtil.getSession();
		
		try {
			if(!ses.getTransaction().isActive())
			{
				tx=ses.beginTransaction();
			
			//prepare objects
			   //child objs
			     EmpDetails emp1=new EmpDetails("raja","hyd",90000.0f);
			     EmpDetails emp2=new EmpDetails("rajesh","vizag",70000.0f);
			     EmpDetails emp3=new EmpDetails("suresh","delhi",60000.0f);
			     
			     //parent obj
			     Department dept=new Department("IT", "mumbai", 10);
			     
			     //set parent obj to multiple child objects
			     emp1.setDept(dept);
			     emp2.setDept(dept); 
			     emp3.setDept(dept);
			     
			     //save child objects
			     ses.save(emp1); 
			     ses.save(emp2);
			     ses.save(emp3);
			     flag=true;
			     
			}//if
		   }//try
		
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		
		finally {
			
			//perform Tx mgmt
			if(flag) {
				tx.commit();
				System.out.println("Objects are save (many to one)");
			}
			else {
				tx.rollback();
				System.out.println("Objects are not save (many to one)");
			}
		
			//close sessionfactory
			HibernateUtil.closeSessionFactory();
		
		}//finally
		
	}//method

	@Override
	public void loadDataUsingChild() {
		
		//properties
				Session ses=null;
				Transaction tx=null;
				boolean flag=false;
				
				//get session
				ses=HibernateUtil.getSession();
				
				try {
						if(!ses.getTransaction().isActive())
						{
							tx=ses.beginTransaction();
							
							//load object
							Query query=ses.createQuery("from EmpDetails");
							
							//execute query
							List<EmpDetails> empList=query.getResultList();
							
							//print the result
							empList.forEach(emp->{
								System.out.println("child :: "+emp);
							
								//associated Parent is print
								Department dept=emp.getDept();
								System.out.println("parent::  "+dept);
							});
							
						}//if	
					}//try
					catch(HibernateException he) {
						he.printStackTrace();
					}
					
					finally {
						//close sessionfactory
						HibernateUtil.closeSessionFactory();
					
					}//finally
	}//method
}//class
