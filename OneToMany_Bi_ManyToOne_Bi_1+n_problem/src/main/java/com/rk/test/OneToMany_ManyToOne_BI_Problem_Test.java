package com.rk.test;

import com.rk.dao.OneToMany_BI_HQLjoin_DAO;
import com.rk.dao.OneToMany_Bi_HQLJoinDAOImpl;

public class OneToMany_ManyToOne_BI_Problem_Test {

	public static void main(String[] args) {
		
		//use dao
		OneToMany_BI_HQLjoin_DAO dao=new OneToMany_Bi_HQLJoinDAOImpl();
		
		dao.loadDataUsingParent();
	}//main
}//class
