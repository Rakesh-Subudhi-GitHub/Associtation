package com.rk.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class PhoneNumber implements Serializable {
	
	private int regNo;
	@NonNull
	private long phone;
	@NonNull
	private String type;
	@NonNull
	private  String provider;
}
