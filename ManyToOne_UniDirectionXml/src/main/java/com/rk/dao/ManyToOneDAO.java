package com.rk.dao;
public interface ManyToOneDAO {

	public void insertRecord_ChildToParent();
	
	public void loadDataUsingChild();
}
