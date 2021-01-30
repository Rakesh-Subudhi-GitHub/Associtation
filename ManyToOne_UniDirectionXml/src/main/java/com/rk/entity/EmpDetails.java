package com.rk.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class EmpDetails implements Serializable {
	private Integer eno;
	
	@NonNull
	private String ename;
	
	@NonNull
	private String eadd;
	
	@NonNull
	private Float salary;
	
	
	private Department dept;  //many to one associated
	
}
