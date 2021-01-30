package com.rk.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rk.entity.PhoneNumber;
import com.rk.entity.UserInfo;
import com.rk.utility.HibernateUtil;

public class SoluctionDAOImpl implements SoluctionDAO {

	@Override
	public void loadDataUsingHQL_JOIN_Scalar_Soluction3(){
		
		// get Session
			Session ses=HibernateUtil.getSession();
			Transaction tx=null;
				
			try {
			if(!ses.getTransaction().isActive())
					 tx=ses.beginTransaction();
		
			//execute HQL Join Query
			Query query=ses.createQuery("select u.userId,u.username,u.addrs ,ph.regNo,ph.phone,ph.type,ph.provider from UserInfo u inner join  u.phones ph ");
			List<Object[]> list=query.getResultList();
			list.forEach(row->{
				for(Object val:row) 
					System.out.print(val+"  ");
				
				System.out.println();
			});
			
				}//try
				
				catch(HibernateException he) {
					he.printStackTrace();
				}
				
				finally {
					//close  objs
					HibernateUtil.closeSessionFactory();
				}
		
	}//method
	
}//class
