package com.HibernateBTMS.dto;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity(name="Rules_violation")
@Table(name="Rules_violation")
public class Rules_violation {
	@Id
	@Column(name="Violation_ID")
	private int violation_ID ;
	@Column(name="Violation_Desc")
	private String violation_Desc;
	@Column(name="Vehicle_No")
	private int vehicle_No	;
	@Column(name="Vehicle_Type")
	private String vehicle_Type;
	@Column(name="Violation_Place")
	private String violation_Place	;
	@Column(name="Violation_dt_time")
	private Date violation_dt_time;
	@Column(name="Violator_Age")
	private int violator_Age ;
	public int getViolation_ID() {
		return violation_ID;
	}
	public void setViolation_ID(int violation_ID) {
		violation_ID = violation_ID;
	}
	public String getViolation_Desc() {
		return violation_Desc;
	}
	public void setViolation_Desc(String violation_Desc) {
		violation_Desc = violation_Desc;
	}
	public int getVehicle_No() {
		return vehicle_No;
	}
	public void setVehicle_No(int vehicle_No) {
		vehicle_No = vehicle_No;
	}
	public String getVehicle_Type() {
		return vehicle_Type;
	}
	public void setVehicle_Type(String vehicle_Type) {
		vehicle_Type = vehicle_Type;
	}
	public String getViolation_Place() {
		return violation_Place;
	}
	public void setViolation_Place(String violation_Place) {
		violation_Place = violation_Place;
	}
	public Date getViolation_dt_time() {
		return violation_dt_time;
	}
	public void setViolation_dt_time(Date violation_dt_time) {
		violation_dt_time = violation_dt_time;
	}
	public int getViolator_Age() {
		return violator_Age;
	}
	public void setViolator_Age(int violator_Age) {
		violator_Age = violator_Age;
	}
}