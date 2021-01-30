package com.rk.test;

import com.rk.dao.OneToManyDAO;
import com.rk.dao.OneToManyDAOImpl;

public class OneToManyTest {

	
	public static void main(String[] args) {
	
		//use DAO class
		OneToManyDAO dao=new OneToManyDAOImpl();
		
		//calling method accordingly
		
		//insert data 
			//dao.saveDataUsingParent();
		
		System.out.println("=====================================================================================");
		
		//select and load Operation
			//dao.loadDataUsingParent();
	
		System.out.println("=====================================================================================");
		
		//add a new phone number 
			//dao.addChildData();
		
		System.out.println("=====================================================================================");
		
		//delete parent table data
		//dao.deleteParentData();
		
		System.out.println("========================================================================================");
		
		//remove specific child
		//dao.delete_a_specificChild();
		
		System.out.println("==========================================================================================");
		//transfer one child to another child
		dao.transferOneUserChildToAnotherUserChild();
	}//main
}//class
