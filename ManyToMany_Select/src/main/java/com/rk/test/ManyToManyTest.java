package com.rk.test;

import com.rk.dao.ManyToManyDAOImpl;

import com.rk.dao.ManyToManyDAO;

public class ManyToManyTest {

	public static void main(String[] args) {
		
		//use DAO
		ManyToManyDAO dao=new ManyToManyDAOImpl();
		
		// load SELECT using parent(DOCTOR)
				//dao.loadDataUsingParent();
		
		//load SELECT using Child(Patient)
		dao.loadDataUsingChild();
	}//main
}//class
