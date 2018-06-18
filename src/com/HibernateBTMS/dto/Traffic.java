package com.HibernateBTMS.dto;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity(name="traffic")
@Table(name="traffic")
public class Traffic {
	@Id
	@Column(name="Traffic_Ind")
	private String traffic_Ind	;
	@Column(name="Traffic_Loc")
	private String traffic_Loc;
	@Column(name="Traffic_Dt_Time")
	private Date traffic_Dt_Time;
	@Column(name="Traffic_Video_Path")
	private String traffic_Video_Path;
	public String getTraffic_Ind() {
		return traffic_Ind;
	}
	public void setTraffic_Ind(String traffic_Ind) {
		traffic_Ind = traffic_Ind;
	}
	public String getTraffic_Loc() {
		return traffic_Loc;
	}
	public void setTraffic_Loc(String traffic_Loc) {
		traffic_Loc = traffic_Loc;
	}
	public Date getTraffic_Dt_Time() {
		return traffic_Dt_Time;
	}
	public void setTraffic_Dt_Time(Date traffic_Dt_Time) {
		traffic_Dt_Time = traffic_Dt_Time;
	}
	public String getTraffic_Video_Path() {
		return traffic_Video_Path;
	}
	public void setTraffic_Video_Path(String traffic_Video_Path) {
		traffic_Video_Path = traffic_Video_Path;
	}

}