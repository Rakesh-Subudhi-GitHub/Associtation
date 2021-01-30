package com.rk.test;

import com.rk.dao.OneToManyDAO;
import com.rk.dao.OneToManyDAOImpl;

public class OneToManyTest {

	
	public static void main(String[] args) {
	
		//use DAO class
		OneToManyDAO dao=new OneToManyDAOImpl();
		
		//calling method accordingly
		
		//insert data 
			dao.saveDataUsingParent();
		
		System.out.println("==========================================================================================");
		//delete a specific child 
			//dao.deletOneSpecificChild_InParent();
		
	}//main
}//class
