package com.HibernateBTMS.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity(name="injury")
@Table(name="injury")
public class Injury {
	@Id
	@Column(name="Accident_ID")
	private int accident_ID ;
	@Column(name="patient_name")
	private String patient_name;
	@Column(name="patient_age")
	private int patient_age ;
	@Column(name="patient_address")
	private String patient_address;
	@Column(name="injury_type")
	private String injury_type ;
	public int getAccident_ID() {
		return accident_ID;
	}
	public void setAccident_ID(int accident_ID) {
		accident_ID = accident_ID;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public int getPatient_age() {
		return patient_age;
	}
	public void setPatient_age(int patient_age) {
		this.patient_age = patient_age;
	}
	public String getPatient_address() {
		return patient_address;
	}
	public void setPatient_address(String patient_address) {
		this.patient_address = patient_address;
	}
	public String getInjury_type() {
		return injury_type;
	}
	public void setInjury_type(String injury_type) {
		this.injury_type = injury_type;
	}
}