package com.rk.test;

import com.rk.dao.SoluctionDAO;
import com.rk.dao.SoluctionDAOImpl;

public class Soluction1_Test {

	public static void main(String[] args) {
		
		//use dao
		SoluctionDAO dao=new SoluctionDAOImpl();
		
		//load HQL
		//dao.loadDataUsingQBC_Soluction1();
		
		//load JPQL
		dao.loadDataUsingJPQBC_Soluction1();
		
	}//main
}//class
