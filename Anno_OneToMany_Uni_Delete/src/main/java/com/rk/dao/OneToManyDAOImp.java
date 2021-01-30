package com.rk.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rk.entity.CarCompany;
import com.rk.entity.CarModel;
import com.rk.utility.HibernateUtil;

public class OneToManyDAOImp implements OneToManyDAO {

	@Override
	public void deletOneSpecificChild_Parent() {
		
		// get Session
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		
		//boolean flag=false;  
		              var flag=false; // type inference variable  (from java 10 ..)
		                                      //its runtime desite the datatype
		              var x=10;
		            //  System.out.println("x value desite :: "+x);   run time x value is set in integer type
		try {
	    	   if(!ses.getTransaction().isActive())
	    		     tx=ses.beginTransaction();
	    
	    	   //Load parent obj
	    	   CarCompany company=ses.get(CarCompany.class, 102);
	    	   
	    	   //get all its childs
	    	   Set<CarModel> models=company.getModels();
	    	   
	    	   //Load Specific Child object
	    	   CarModel model=ses.get(CarModel.class,101L);
	    	   
	    	   //remove the child
	    	   models.remove(model);
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
			  
		  
			  //perform TxMgmt
			    if(flag) {
			    	System.out.println("Object is deleted");
			    	tx.commit();
			    }
			    else {
			    	System.out.println("Object is not deleted");
			    	tx.rollback();
			    }
			    
			    //close session
			    HibernateUtil.closeSessionFactory();
		  }//finally

}//method

}//class
