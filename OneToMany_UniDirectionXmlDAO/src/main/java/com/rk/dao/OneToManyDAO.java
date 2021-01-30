package com.rk.dao;

public interface  OneToManyDAO {

	public void saveDataUsingParent();
	
	public void loadDataUsingParent();
	
	public void addChildData(); //add a new phone number
	
	public void deleteParentData();
	
	public void delete_a_specificChild();
	
	public void transferOneUserChildToAnotherUserChild();
}
