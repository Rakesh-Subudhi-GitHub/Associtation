package com.rk.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {
	
	private int userId;
	@NonNull
	private String username;
	@NonNull
	private  String  addrs;
	
	private List<PhoneNumber> phones;  // special property to build 1..* assocication (By holding muliple objects of child class)

}
