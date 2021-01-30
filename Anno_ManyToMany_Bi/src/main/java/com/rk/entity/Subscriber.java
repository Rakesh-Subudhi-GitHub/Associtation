package com.rk.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
public class Subscriber  implements Serializable {
	
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "sub_id_seq",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer subscriberId;
	
	@Column(length=20)
	@NonNull
	private String  subscriberName;
	
	@Column(length=20)
	@NonNull
	private String  subscriberType;
	
	@Column(length=20)
	@NonNull
	private String  subscriberLocation;

	@ManyToMany(targetEntity = TVChannel.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name="TVCHANNEL_SUBSCRIBER_MTOM",
	                     joinColumns = @JoinColumn(name ="SUBSCRIBER_ID",referencedColumnName = "SUBSCRIBERID" ),  //owning side fk col
	                     inverseJoinColumns = @JoinColumn(name ="CHANNEL_ID",referencedColumnName = "CHANNELID" )  // non-owning side fk  col
	                    )
	private Set<TVChannel> channels;
	
	public Subscriber() {
		System.out.println("Subscriber:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "Subscriber [subscriberId=" + subscriberId + ", subscriberName=" + subscriberName + ", subscriberType="
				+ subscriberType + ", subscriberLocation=" + subscriberLocation + "]";
	}
	
}//class
