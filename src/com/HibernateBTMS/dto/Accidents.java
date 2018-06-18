package com.HibernateBTMS.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="accidents")
@Table(name="accidents")
public class Accidents{
	@Id
	@Column(name="Accident_ID")
	private int accident_ID ;
	@Column(name="Accident_Location")
	private String accident_Location;
	@Column(name="Accident_dt_time")
	private String accident_dt_time;
	@Column(name="Accident_Reason")
	private String accident_Reason;
	@Column(name="Vehicle_No")
	private int vehicle_No;
	@Column(name="No_Person_Affected")
	private int no_Person_Affected;

	public int getAccident_ID() {
		return accident_ID;
	}
	public void setAccident_ID(int accident_ID) {
		accident_ID = accident_ID;
	}
	public String getAccident_Location() {
		return accident_Location;
	}
	public void setAccident_Location(String accident_Location) {
		accident_Location = accident_Location;
	}
	public String getAccident_dt_time() {
		return accident_dt_time;
	}
	public void setAccident_dt_time(String a_DateTime) {
		accident_dt_time = a_DateTime;
	}
	public String getAccident_Reason() {
		return accident_Reason;
	}
	public void setAccident_Reason(String accident_Reason) {
		accident_Reason = accident_Reason;
	}
	public int getVehicle_No() {
		return vehicle_No;
	}
	public void setVehicle_No(int vehicle_No) {
		vehicle_No = vehicle_No;
	}
	public int getNo_Person_Affected() {
		return no_Person_Affected;
	}
	public void setNo_Person_Affected(int no_Person_Affected) {
		no_Person_Affected = no_Person_Affected;
	}
}