package com.rk.test;

import com.rk.dao.ManyToOne_Uni_DAOImpl;

import com.rk.dao.ManyToOneDAO;

public class ManyToOneTest {

	public static void main(String[] args) {
	
		//use dao
		ManyToOneDAO dao=new ManyToOne_Uni_DAOImpl();
		
		//Invoke the insert Operation
		dao.saveDataUsingChilds();
		
	}//main
	
}//class
