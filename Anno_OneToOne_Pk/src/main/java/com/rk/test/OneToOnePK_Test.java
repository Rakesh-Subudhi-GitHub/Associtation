package com.rk.test;

import com.rk.dao.OneToOneDAO;
import com.rk.dao.OneToOneDAOImpl;

public class OneToOnePK_Test {

	public static void main(String[] args) {
	
		//use dao
		OneToOneDAO dao=new OneToOneDAOImpl();
		
		//Invoke the insert Operation (Child)
				dao.saveDataUsingParent();
				
	}//main
	
}//class
