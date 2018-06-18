package com.HibernateBTMS.dto;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity(name="pollution")
@Table(name="pollution")
public class Pollution {
	@Id
	@Column(name="Area_Polluted")
	private String area_Polluted ;
	@Column(name="Pollution_Level_ppm")
	private float pollution_Level_ppm ;
	@Column(name="Pollution_Dt_Time")
	private Date pollution_Dt_Time;
	public String getArea_Polluted() {
		return area_Polluted;
	}
	public void setArea_Polluted(String area_Polluted) {
		area_Polluted = area_Polluted;
	}
	public float getPollution_Level_ppm() {
		return pollution_Level_ppm;
	}
	public void setPollution_Level_ppm(float pollution_Level_ppm) {
		pollution_Level_ppm = pollution_Level_ppm;
	}
	public Date getPollution_Dt_Time() {
		return pollution_Dt_Time;
	}
	public void setPollution_Dt_Time(Date pollution_Dt_Time) {
		pollution_Dt_Time = pollution_Dt_Time;
	}

}