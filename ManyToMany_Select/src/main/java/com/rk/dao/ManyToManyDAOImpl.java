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
	public void loadDataUsingParent()
	{
		
		//get session
		Session ses=HibernateUtil.getSession();
		
		Transaction tx=null;
		boolean flag=false;
				
		try {
			if(!ses.getTransaction().isActive())
			{
				tx=ses.beginTransaction();
				
				//prepare Query
				Query query=ses.createQuery("from Doctor");
				
				//execute SQL query
				List<Doctor> list=query.getResultList();
				
				//load result
				//parent load
				list.forEach(doc->{
					System.out.println("parent::"+doc);
				    
					//load child result
					Set<Patient> childs=doc.getPatients();
				     childs.forEach(pat->{
				    	 System.out.println("child ::"+pat);
				     });
				});
				
			}//if
			}//try
				
			catch(HibernateException he) {
				he.printStackTrace();
				}
				
		finally {
			
					//close SessionFactory
					HibernateUtil.closeSessionFactory();
				
				}//finally
				
	}//method

	@Override
	public void loadDataUsingChild() {
		//get session
				Session ses=HibernateUtil.getSession();
				
				Transaction tx=null;
				boolean flag=false;
						
				try {
					if(!ses.getTransaction().isActive())
					{
						tx=ses.beginTransaction();
						
						//prepare SQL qyery
						Query query=ses.createQuery("from Patient");
						
						//execute SQL query
						List<Patient> list=query.getResultList();
						
						//load Result in child
						list.forEach(pat->{
							System.out.println("child::"+pat);
						
							//load parent
						    Set<Doctor> parents=pat.getDoctors();
						     parents.forEach(doc->{
						    	 System.out.println("parent ::"+doc);
						     });
						});
						
					}//if
					}//try
						
					catch(HibernateException he) {
						he.printStackTrace();
						}
						
				finally {
					
							//close SessionFactory
							HibernateUtil.closeSessionFactory();
						
						}//finally
	}//method
	
}//class
