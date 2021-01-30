package com.rk.test;

import com.rk.dao.ManyToManyDAOImpl;

import com.rk.dao.ManyToManyDAO;

public class ManyToManyTest {

	public static void main(String[] args) {
		
		//use DAO
		ManyToManyDAO dao=new ManyToManyDAOImpl();
		
		//delete a specific child
				//dao.deleteSpecificChildFromSpecifcParent();
		
		//delete One parent and its all childs
		dao.deleteAllChildsOfAParent();
		
	}//main
}//class
