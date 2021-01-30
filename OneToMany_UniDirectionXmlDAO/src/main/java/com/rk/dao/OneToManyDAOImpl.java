package com.rk.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.rk.entity.PhoneNumber;
import com.rk.entity.UserInfo;
import com.rk.utility.HibernateUtil;

public class OneToManyDAOImpl implements OneToManyDAO {

	@Override
	public void saveDataUsingParent() {
		///properties
		Transaction tx=null;
		boolean flag=false;
		
		//get session
		Session ses=HibernateUtil.getSession();
		
		//prepare object
		//child object
		PhoneNumber phno=new PhoneNumber(799999l,"residence","home");
		PhoneNumber phno1=new PhoneNumber(788888l,"permanet","office");
		PhoneNumber phno2=new PhoneNumber(777777l,"residence","personal");
		
		Set<PhoneNumber> phoneset=Set.of(phno,phno1,phno2); //store all phoneNumber in one user 
		
		//parent class
			//store all details of user
		UserInfo user=new UserInfo();
		
		user.setUsername("ritu");
		user.setAddrs("ctc");
		user.setPhones(phoneset);
		
		try {
			
			//begin tx		
			if(!ses.getTransaction().isActive())
			{

			tx=ses.beginTransaction();
				
				//save objs
				ses.save(user);
				flag=true;
			
			}//if	
		}//try
		catch (HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		catch (Exception e) {
		e.printStackTrace();
		flag=false;
		}
		
		//show the result or save the object
		
		finally {
			
			if(flag)
			{
				tx.commit();
				System.out.println("User details are saved :::");
				System.out.println(user);
			}
			else
			{
				tx.rollback();
				System.out.println("user details are not saved ::::");
				return;
			}
			
			//close all
			//HibernateUtil.closeSessionFactory();
		}//finally

	}
	
//=============================================================================================================================
	
	@Override
	public void loadDataUsingParent() {
		//properties
				Transaction tx=null;
				boolean flag=false;
				
				//get session
				Session ses=HibernateUtil.getSession();
			
				try {
					
					//begin tx		
					if(!ses.getTransaction().isActive())
					{
						tx=ses.beginTransaction();
						
						//load parent obj
						Query query=ses.createQuery("from UserInfo");
						List<UserInfo> list=query.getResultList();
					
						//print parent class
						list.forEach(user->{
							System.out.println("parent :: "+user);
							
							//get associated child also print
							Set<PhoneNumber> child=user.getPhones();
																	child.forEach(ph->{
																			System.out.println("child :: "+ph);
																	});//child
						});//parent
		//
//						list.forEach(System.out::println);
					}//if	
				}//try
				catch (HibernateException he) {
					he.printStackTrace();
					
				}
				catch (Exception e) {
				e.printStackTrace();
				
				}
				
				//show the result or save the object
				
				finally {
					
					//close all
					//HibernateUtil.closeSessionFactory();
				}//finally
				
	}//method

	@Override
	public void addChildData() {
		
		//properties
				Transaction tx=null;
				boolean flag=false;
				
				//get session
				Session ses=HibernateUtil.getSession();
		
				try {
					
					//begin tx		
					if(!ses.getTransaction().isActive())
					{
					tx=ses.beginTransaction();
						
					//load existing parent class
					UserInfo user=ses.get(UserInfo.class,2); //2no id data is child 
					
					//get existing data is load
					Set<PhoneNumber> ChildphoneNo=user.getPhones();
					
					//craete a new child in phoneNumber class
					PhoneNumber phno=new PhoneNumber(555555555,"personal", "jio");
					
					//add that no in parent class(UserInfo)
					ChildphoneNo.add(phno);
					flag=true;
					}//if	
					
				}//try
				catch (HibernateException he) {
					he.printStackTrace();
					flag=false;
				}
				catch (Exception e) {
				e.printStackTrace();
				flag=false;
				}
				
				//show the result or save the object
				
				finally {
					
					if(flag)
					{
						tx.commit();
						System.out.println("User new Number are Added Suseccesfully :::");
						System.out.println();
					}
					else
					{
						tx.rollback();
						System.out.println("User new Number are not added some problem is there");
						return;
					}
					
					//close all
					//HibernateUtil.closeSessionFactory();
				}//finally
	}//method
//================================================================================================================
	
	@Override
	public void deleteParentData() {
		//properties
		Transaction tx=null;
		boolean flag=false;
		
		//get session
		Session ses=HibernateUtil.getSession();

		try {
			
			//begin tx		
			if(!ses.getTransaction().isActive())
			{
			tx=ses.beginTransaction();
				
			//load existing parent class
			UserInfo user=ses.get(UserInfo.class,2); //2no id data is child 
			
			//delete the parent
			ses.delete(user);
			flag=true;
			}//if
			
			}//try
			catch (HibernateException he) {
				he.printStackTrace();
				flag=false;
			}
			catch (Exception e) {
			e.printStackTrace();
			flag=false;
			}
			
			//show the result or save the object
			
			finally {
				
				if(flag)
				{
					tx.commit();
					System.out.println("User All data is DELETE  Suseccesfully :::");
					System.out.println();
				}
				else
				{
					tx.rollback();
					System.out.println("User All data is Not Deleted some problem is there");
					return;
				}
				
				//close all
				//HibernateUtil.closeSessionFactory();
			}//finally

	}//method
	
//====================================================================================================================
	
	@Override
	public void delete_a_specificChild() {
					
		//properties
				Transaction tx=null;
				boolean flag=false;
				
				//get session
				Session ses=HibernateUtil.getSession();

				try {
					
					//begin tx		
					if(!ses.getTransaction().isActive())
					{
					tx=ses.beginTransaction();
						
					//load parent class
					UserInfo user=ses.get(UserInfo.class,4);
					
					//load a specific data for parent
					Set<PhoneNumber> child=user.getPhones();
					
					//load child data
					PhoneNumber ph=ses.get(PhoneNumber.class,10);
					
					//remove child
					child.remove(ph);
					flag=true;
					}//if
					
					}//try
					catch (HibernateException he) {
						he.printStackTrace();
						flag=false;
					}
					catch (Exception e) {
					e.printStackTrace();
					flag=false;
					}
					
					//show the result or save the object
					finally {
						
						if(flag)
						{
							tx.commit();
							System.out.println("User aspecific child should delete Suseccesfully :::");
							System.out.println();
						}
						else
						{
							tx.rollback();
							System.out.println("User Child is Not Deleted some problem is there");
							return;
						}
						
						//close all
						//HibernateUtil.closeSessionFactory();
					}//finally
	}//method
	
//====================================================================================================================
	
	@Override
	public void transferOneUserChildToAnotherUserChild() {
		
		//properties
		Transaction tx=null;
		boolean flag=false;
		
		//get session
		Session ses=HibernateUtil.getSession();

		try {
			
			//begin tx		
			if(!ses.getTransaction().isActive())
			{
			tx=ses.beginTransaction();
				
			//load parent class
			UserInfo user1=ses.get(UserInfo.class,4);
			
			//get load child 
			Set<PhoneNumber> user1child=user1.getPhones();
			//load specific child that poticular (child transfer)
			PhoneNumber phone1=ses.get(PhoneNumber.class,10);
			
			//get Dest. parent obj
			//load that db table
			UserInfo user2=ses.get(UserInfo.class,5);
			//get all child 
			Set<PhoneNumber> user2child=user2.getPhones();
			
			//load that dest child
			user2child.add(phone1);
			
			//remove that dest. source
			user1child.remove(phone1);
			flag=true;
			}//if
			
			}//try
			catch (HibernateException he) {
				he.printStackTrace();
				flag=false;
			}
			catch (Exception e) {
			e.printStackTrace();
			flag=false;
			}
			
			//show the result or save the object
			finally {
				
				if(flag)
				{
					tx.commit();
					System.out.println("User Transfer one child to another child Suseccesfully :::");
					System.out.println();
				}
				else
				{
					tx.rollback();
					System.out.println("User NOT Transfer one child to another child is some problem is there");
					return;
				}
				
				//close all
				//HibernateUtil.closeSessionFactory();
			}//finally
		
	}//method
	
}//class
