package com.rk.servlet;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.Membership;
import com.rk.utility.HibernateUtil;

public class InsertTest {

	public static void main(String[] args) {

		//read inputs
		Session ses=null;
		Membership member=null;
		Transaction tx=null;
		boolean flag=false;
		
		//get session object
		ses=HibernateUtil.getSession();
		
		//prepare object
		member= new Membership();
		
		//set param
		member.setName("daddy");
		member.setAddres("rohit");
		member.setReward_points(900l);
		
try {
	
	tx=ses.beginTransaction();
	ses.merge(member);
	flag=true;
	
	//ses.refresh(member);
System.out.println(member);	
	}//try
	
catch(HibernateException he)
{
	he.printStackTrace();
}
catch(Exception e)
{
	e.printStackTrace();
}

	//finally chek or commet the trasaction
finally {
	
	if(flag)
	{
		tx.commit();
		System.out.println("object is save or updateed");
		System.out.println(member);
	}
	else
	{
		System.out.println("object is not save");
		tx.rollback();
		return;
	}
	
	//close obj
	HibernateUtil.closeSession(ses);
	HibernateUtil.closeSessionFactory();
}//finally

	}//main
}