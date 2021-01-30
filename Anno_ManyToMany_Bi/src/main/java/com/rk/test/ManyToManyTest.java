package com.rk.test;

import com.rk.dao.ManyToManyDAO;
import com.rk.dao.ManyToManyDAOImpl;

public class ManyToManyTest {

	public static void main(String[] args) {
	
		//use dao
		ManyToManyDAO dao=new ManyToManyDAOImpl();
		
		//Invoke the insert Operation (Parent)
		         //dao.saveDataUsingChilds();
		
		//Invoke the insert Operation (Child)
				dao.saveDataUsingParent();
				
	}//main
	
}//class
