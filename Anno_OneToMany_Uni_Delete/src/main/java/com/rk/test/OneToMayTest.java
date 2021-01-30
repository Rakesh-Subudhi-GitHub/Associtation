package com.rk.test;

import com.rk.dao.OneToManyDAO;
import com.rk.dao.OneToManyDAOImp;

public class OneToMayTest {

	public static void main(String[] args) {
		
		//use dao
		OneToManyDAO dao=new OneToManyDAOImp();
		
		//delete a specific child to a parent
		dao.deletOneSpecificChild_Parent();
	}//main
}//class
