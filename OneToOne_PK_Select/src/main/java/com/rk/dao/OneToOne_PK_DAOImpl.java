package com.rk.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rk.entity.LibraryMembership;
import com.rk.entity.Student;
import com.rk.utility.HibernateUtil;

public class OneToOne_PK_DAOImpl implements OneToOne_PK_DAO {

	@Override
	public void loadDataUsingParent() {
		
		//get Session object
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
		
			//prepare HQL Query
			Query query=ses.createQuery("from Student");
			
			//execute Query
			List<Student> list=query.getResultList();
			
			//show the result
			list.forEach(st->{
				//print parent
				System.out.println("parent::"+st);
				
				//print child
				LibraryMembership lib=st.getLibraryDetails();
				System.out.println("child ::"+lib);
		
			});
			
		}//try
		catch(HibernateException he) {
					he.printStackTrace();
				}
		catch(Exception e) {
			e.printStackTrace();
				}
		
		finally {
			
			//close SessionFactory
			HibernateUtil.closeSessionFactory();
		}//finally
		
	}//method

}//class
