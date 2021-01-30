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
	public void loadDataUsingParent() {
		
		//get session
		Session ses=HibernateUtil.getSession();
		
		Transaction tx=null;
		
	       try {
	    	   if(!ses.getTransaction().isActive())
	    		     tx=ses.beginTransaction();
	    	
	    	   //prepared Quey
	    	   Query query=ses.createQuery("From CarCompany");
	    	  
	    	   //execute query
	    	   List<CarCompany> complist=query.getResultList();
	    	 
	    	   //print result
	    	   complist.forEach(comp->{
	    		   System.out.println("parent :: "+comp);
	    		   
	    		   
	    		   //load associated child
	    		   Set<CarModel> models=comp.getModels();
	    		   models.forEach(model->{
	    			   System.out.println("child :: "+model);
	    		   });
	    	   });
	       }//try
	       
	       catch(HibernateException he) {
	    	   he.printStackTrace();
	       }
	       
	       finally {
	    	  HibernateUtil.closeSessionFactory();
	    	  
	       }//finally
	       
	}//method

@Override
public void loadDataUsingParentUsingQBC() {
		
	//get session
	Session ses=HibernateUtil.getSession();
				
	Transaction tx=null;
				
	try {
	  if(!ses.getTransaction().isActive())
			   tx=ses.beginTransaction();
			    	
			  //prepared Quey
			  Criteria criteria=ses.createCriteria(CarCompany.class);
			    	  
			   //execute query
			   List<CarCompany> complist=criteria.list();
			    	 
			    //print result
			      complist.forEach(comp->{
			    		   System.out.println("parent :: "+comp);
			    		   
			    		   
			    		   //load associated child
			    		   Set<CarModel> models=comp.getModels();
			    		   models.forEach(model->{
			    			   System.out.println("child :: "+model);
			    		   });
			    	   });
			       }//try
			       
			       catch(HibernateException he) {
			    	   he.printStackTrace();
			       }
			       
			       finally {
			    	  HibernateUtil.closeSessionFactory();
			    	  
			       }//finally
		
	}//class

}//class
