package com.HibernateBTMS.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity(name="casualty")
@Table(name="casualty_view")
public class Casualty {
	@Id
	@Column(name="Accident_ID")
	private int accident_ID ;
	@Column(name="casualty_name")
	private String casualty_name;
	@Column(name="casualty_address")
	private String casualty_address; 
	@Column(name="casualty_sex")
	private String casualty_sex ;
	@Column(name="casualty_age")
	private int casualty_age;
	@Column(name="casualty_color")
	private String casualty_color; 
	@Column(name="Death_Reason")
	private String death_Reason;
	@Column(name="Admitted_Hospital")
	private String admitted_Hospital;
	public int getAccident_ID() {
		return accident_ID;
	}
	public void setAccident_ID(int accident_ID) {
		accident_ID = accident_ID;
	}
	public String getCasualty_name() {
		return casualty_name;
	}
	public void setCasualty_name(String casualty_name) {
		this.casualty_name = casualty_name;
	}
	public String getCasualty_address() {
		return casualty_address;
	}
	public void setCasualty_address(String casualty_address) {
		this.casualty_address = casualty_address;
	}
	public String getCasualty_sex() {
		return casualty_sex;
	}
	public void setCasualty_sex(String casualty_sex) {
		this.casualty_sex = casualty_sex;
	}
	public int getCasualty_age() {
		return casualty_age;
	}
	public void setCasualty_age(int casualty_age) {
		this.casualty_age = casualty_age;
	}
	public String getCasualty_color() {
		return casualty_color;
	}
	public void setCasualty_color(String casualty_color) {
		this.casualty_color = casualty_color;
	}
	public String getDeath_Reason() {
		return death_Reason;
	}
	public void setDeath_Reason(String death_Reason) {
		death_Reason = death_Reason;
	}
	public String getAdmitted_Hospital() {
		return admitted_Hospital;
	}
	public void setAdmitted_Hospital(String admitted_Hospital) {
		admitted_Hospital = admitted_Hospital;
	} 
}
