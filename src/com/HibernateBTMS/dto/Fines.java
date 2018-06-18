package com.HibernateBTMS.dto;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity(name="fines")
@Table(name="fines")
public class Fines{
	@Id
	@Column(name="Violation_ID")
	private int violation_ID ;
	@Column(name="Fine_Amount")
	private int fine_Amount	;
	@Column(name="Fine_dt_time")
	private Date fine_dt_time ;
	@Column(name="fine_desc")
	private String fine_desc ;
	public int getViolation_ID() {
		return violation_ID;
	}
	public void setViolation_ID(int violation_ID) {
		violation_ID = violation_ID;
	}
	public int getFine_Amount() {
		return fine_Amount;
	}
	public void setFine_Amount(int fine_Amount) {
		fine_Amount = fine_Amount;
	}
	public Date getFine_dt_time() {
		return fine_dt_time;
	}
	public void setFine_dt_time(Date fine_dt_time) {
		fine_dt_time = fine_dt_time;
	}
	public String getFine_desc() {
		return fine_desc;
	}
	public void setFine_desc(String fine_desc) {
		this.fine_desc = fine_desc;
	}
}