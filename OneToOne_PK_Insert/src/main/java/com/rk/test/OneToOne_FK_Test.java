package com.rk.test;

import com.rk.dao.OneToOne_PK_DAO;
import com.rk.dao.OneToOne_PK_DAOImpl;

public class OneToOne_FK_Test {

	public static void main(String[] args) {
		
		//use DAO
		OneToOne_PK_DAO dao=new OneToOne_PK_DAOImpl();
		
		//insert method using Help of Parent
		   //dao.saveDataUsingParent();
		
		//insert method using Help of Child
		dao.saveDataUsingChild();
	}//main
	
}//class
