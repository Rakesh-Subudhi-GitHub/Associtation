package com.rk.test;

import com.rk.dao.OneToManyDAO;
import com.rk.dao.OneToManyDAOImp;

public class OneToMayTest {

	public static void main(String[] args) {
		
		//use dao
		OneToManyDAO dao=new OneToManyDAOImp();
		
		//Save in useing Parent
			//dao.saveDataUsingParent();
		
		//load data using parent
		dao.loadDataUsingParent();
	}//main
}//class
