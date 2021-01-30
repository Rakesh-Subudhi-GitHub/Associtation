package com.rk.entity;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name="CARCOMPANY_MAP")
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
	@MapKeyColumn(name = "MAP_INDX",length = 10)
    @Fetch(FetchMode.SELECT)
	private Map<String,CarModel>  models;

	public CarCompany() {
		System.out.println("CarCompany:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "CarCompany [compId=" + compId + ", compName=" + compName + ", location=" + location + "]";
	}
	
}//class
