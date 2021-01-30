package com.rk.test;

import com.rk.dao.OneToMany_ManyToOne_Bi_DAO;
import com.rk.dao.OneToMany_ManyToOne_Bi_DAOImpl;

public class OneToMany_ManyToOne_Bi_Test {

	public static void main(String[] args) {
	
		//use dao
		OneToMany_ManyToOne_Bi_DAO dao=new OneToMany_ManyToOne_Bi_DAOImpl();
		
		//Invoke the insert Operation
		dao.saveDataUsingChilds();
		
	}//main
	
}//class
