package com.rk.entity;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;

import lombok.Data;

@Data
@Entity
public class Membership {

	//read inputs
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
		private Long mid;
		private String name;
		private String addres;
		private Long reward_points;
}
