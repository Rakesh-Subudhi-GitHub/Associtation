package com.rk.test;

import com.rk.dao.OneToOne_FK_DAOImpl;

import com.rk.dao.OneToOne_FK_DAO;

public class OneToOne_FK_Test {

	public static void main(String[] args) {
		
		//use DAO
		OneToOne_FK_DAO dao=new OneToOne_FK_DAOImpl();
		
		//invoke the method
		dao.saveData();
		
	}//main
}//class
