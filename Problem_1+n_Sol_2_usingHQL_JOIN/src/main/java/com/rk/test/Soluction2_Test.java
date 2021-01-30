package com.rk.test;

import com.rk.dao.SoluctionDAO;
import com.rk.dao.SoluctionDAOImpl;

public class Soluction2_Test {

	public static void main(String[] args) {
		
		//use dao
		SoluctionDAO dao=new SoluctionDAOImpl();
		
		dao.loadDataUsingHQL_JOIN_Soluction2();
	}//main
}//class
