package com.rk.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.CarCompany;
import com.rk.entity.CarModel;
import com.rk.utility.HibernateUtil;

public class OneToManyDAOImp implements OneToManyDAO {

	@Override
	public void saveDataUsingParent() {
		
		//get session
		Session ses=HibernateUtil.getSession();
		
		//prepared obj
		
		//load child class obj 
		 CarModel model1=new CarModel("Baleno","HatchBack","diesel");
	     CarModel model2=new CarModel("Brezza","HatchBack","diesel");  //use help of Constructor or setter method also
		CarModel model3=new CarModel();
		
		//load all child obj value
		model3.setModelName("Baleno");
		model3.setType("HatchBack");
		model3.setFuelType("diesel");
		
		//add all child obj in SetCollections
		List<CarModel> models=List.of(model1,model2,model3);
		
		//load parent obj 
		CarCompany comp=new CarCompany();
				
		//set value
		comp.setCompName("maruthi-suzuki");
		comp.setLocation("noida");
		
		//child loaded so  load the collection
		comp.setModels(models);
		
		Transaction tx=null;
	       boolean flag=false;
	       try {
	    	   if(!ses.getTransaction().isActive())
	    		     tx=ses.beginTransaction();
	    	
	    	   //save the data in Parent
	    	   ses.save(comp);
	    	   flag=true;
	       }//try
	       
	       catch(HibernateException he) {
	    	   he.printStackTrace();
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
	       }//finally
	       
	}//method

}//class
