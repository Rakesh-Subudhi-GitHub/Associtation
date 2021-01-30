package com.rk.test;

import com.rk.dao.ManyToOneDAO;
import com.rk.dao.ManyToOneDAOImpl;

public class ManyToOneTest {

	public static void main(String[] args) {
		
		//load DAO
		ManyToOneDAO dao=new ManyToOneDAOImpl();
		
		//insert method
			//dao.insertRecord_ChildToParent();
		//select operation
		dao.loadDataUsingChild();
		
	}//main
}//class
