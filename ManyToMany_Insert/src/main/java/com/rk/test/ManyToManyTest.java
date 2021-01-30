package com.rk.test;

import com.rk.dao.ManyToManyDAOImpl;

import com.rk.dao.ManyToManyDAO;

public class ManyToManyTest {

	public static void main(String[] args) {
		
		//use DAO
		ManyToManyDAO dao=new ManyToManyDAOImpl();
		
		//insert method called(parent save record)
				//dao.saveDataUsingParent();
		
		//insert method called(child  save record)
		  dao.saveDataUsingChild();
	}//main
}//class
