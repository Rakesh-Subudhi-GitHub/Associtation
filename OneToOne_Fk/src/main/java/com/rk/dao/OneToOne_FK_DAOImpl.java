package com.rk.dao;

import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.Passport;
import com.rk.entity.Person;
import com.rk.utility.HibernateUtil;

public class OneToOne_FK_DAOImpl implements OneToOne_FK_DAO {

	@Override
	public void saveData() {
		
		//get Session 
		Session ses=HibernateUtil.getSession();
				
		//prepare objects
		//parent
		Person per=new Person("raja","hyd");
		//child 
		Passport pspt=new Passport("india", LocalDate.of(2030,10,10));
	
		//allocate the parent
		pspt.setPersonDetails(per);
		
		//persion having no passport
		Person per1=new Person("ravi","vizag");
		
		Transaction tx=null;
		boolean flag=false;
		
		try {
				if(!ses.getTransaction().isActive())
					{
						tx=ses.beginTransaction();
						ses.save(pspt);
						ses.save(per1);
						flag=true;
					}//if
				
				}//try
		catch(HibernateException he) {
		he.printStackTrace();
				}
		catch(Exception e) {
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
