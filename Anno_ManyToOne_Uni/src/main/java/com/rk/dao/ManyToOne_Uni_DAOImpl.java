package com.rk.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rk.entity.PoliticalLeader;
import com.rk.entity.PoliticalParty;
import com.rk.utility.HibernateUtil;

public class ManyToOne_Uni_DAOImpl implements ManyToOneDAO{

	@Override
	public void saveDataUsingChilds() {
	
	//get Session object
	Session ses=HibernateUtil.getSession();
		
	//prepare objects parent
	 PoliticalParty party1=new PoliticalParty("BJP","saffron-Green","Lotus");
	 
	 //child 
	 PoliticalLeader  leader1=new PoliticalLeader("modi", "PM","delhi");
	 PoliticalLeader  leader2=new PoliticalLeader("yogi", "CM","UP");
	
	 //map parent to childs
	  leader1.setParty(party1);
	  leader2.setParty(party1);
			  
	  //parent 2 load
	  PoliticalParty party2=new PoliticalParty("AAP","white","Broom");
	  
	  //child load
	  PoliticalLeader  leader3=new PoliticalLeader("Aravind", "CM","delhi");
	  PoliticalLeader  leader4=new PoliticalLeader("prasanth", "D-CM","delhi");
		
	//map parent 2 to childs
	  leader3.setParty(party2);
	  leader4.setParty(party2);
			  
	Transaction tx=null;
	boolean flag=false;
	try {
		//begin Tx
		if(!ses.getTransaction().isActive())
		tx=ses.beginTransaction();
	   
		//save the data using child
		ses.save(leader1); 
		ses.save(leader2);
		ses.save(leader3);
		ses.save(leader4);
		
		flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
		e.printStackTrace();
			}
		
	finally {
				if(flag) {
					tx.commit();
					System.out.println("objects are saved");
				}
				else {
					tx.rollback();
					System.out.println("Objects are not saved");
				}
				
				//closeSession object
				HibernateUtil.closeSessionFactory();
			}//finally
			
		}//method
		
	}//class
