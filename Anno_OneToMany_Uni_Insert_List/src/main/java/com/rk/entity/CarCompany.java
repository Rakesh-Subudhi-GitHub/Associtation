package com.rk.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ListIndexBase;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name="CARCOMPANY_LIST")
public class CarCompany implements Serializable{

	//properties
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer compId;
	
	@Column(length = 20)
	@NonNull
	private String compName;
	
	@Column(length = 20)
	@NonNull
	private String location;
	
	@OneToMany(targetEntity = CarModel.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
	@JoinColumn(name ="COMPANY_ID",referencedColumnName = "COMPID")//fk column
	 
	//@IndexColumn(name = "LST_INDX",base = 1)  HB specific .. Deprecated
		@OrderColumn(name = "LST_INDX") //this 1
		@ListIndexBase(value = 1)   //this 2
	    @Fetch(FetchMode.SELECT)     //this 1 or 2 line not take then indirectly it take <bag> tag 
		private List<CarModel>  models;

	public CarCompany() {
		System.out.println("CarCompany:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "CarCompany [compId=" + compId + ", compName=" + compName + ", location=" + location + "]";
	}
	
}//class
