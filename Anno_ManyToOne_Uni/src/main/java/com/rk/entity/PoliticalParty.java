package com.rk.entity;

//PoliticalParty.java (parent class)

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class PoliticalParty implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  long partyId;
	
	@NonNull
	@Column(length = 20)
	private  String partyName;
	@NonNull
	@Column(length = 20)
	private  String flagColors;
	@NonNull
	@Column(length = 20)
	private String partySymbol;
	
	public PoliticalParty() {
		System.out.println("PoliticalParty:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "PoliticalParty [partyId=" + partyId + ", partyName=" + partyName + ", flagColors=" + flagColors
				+ ", partySymbol=" + partySymbol + "]";
	}
	
}//class