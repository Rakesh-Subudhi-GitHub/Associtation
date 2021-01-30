package com.rk.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Table(name="COMPANY_OTM_BI")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Company  implements Serializable {

	@Id
	@GeneratedValue
	private Integer compId;
	
	@Column(length=20)
	@NonNull
    private String   compName;
	
	@Column(length=20)
	@NonNull
    private  String  addrs;
	
	@Column(length=20)
	@NonNull
    private  String type;
	
	@OneToMany(targetEntity =Project.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval =true)
	@JoinColumn(name = "COMPANY_ID",referencedColumnName = "COMPID")
    private Set<Project>  projects; 
	
	public Company() {
		System.out.println("Company:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "Company [compName=" + compName + ", addrs=" + addrs + ", type=" + type + "]";
	}
	
}//class

