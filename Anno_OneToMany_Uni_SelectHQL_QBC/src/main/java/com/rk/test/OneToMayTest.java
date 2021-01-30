package com.rk.test;

import com.rk.dao.OneToManyDAO;
import com.rk.dao.OneToManyDAOImp;

public class OneToMayTest {

	public static void main(String[] args) {
		
		//use dao
		OneToManyDAO dao=new OneToManyDAOImp();
		
		//load data using parent HQL Query
		 //dao.loadDataUsingParent();
		
		//load data using QBC parent side
		dao.loadDataUsingParentUsingQBC();
	}//main
}//class
