package com.rk.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.CanteenCard;
import com.rk.entity.Employee;
import com.rk.utility.HibernateUtil;

public class OneToOneDAOImpl implements OneToOneDAO{

	@Override
	public void saveDataUsingParent() {
		
		//get Session object
		Session ses=HibernateUtil.getSession();
		
		//prepare object
		//parent set value
		Employee emp=new Employee("raja", "hyd",90000.0f);
		
		//child set value
		CanteenCard  card=new CanteenCard("miltary","hyd","gold");
		
		//child detauls store in parent
		emp.setCardDetails(card);
		//parent details store in child
		card.setEmpDetails(emp);
		
		Transaction tx=null;
		boolean flag=false;
		try {
			if(!ses.getTransaction().isActive())
				 tx=ses.beginTransaction();
			
			//save the data using parent
			   ses.save(emp);
			
			   flag=true;
		}//try
		
		catch(HibernateException he) {
			he.printStackTrace();
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
		}//finally

	}//method
}//class
