package com.HibernateBTMS.dto;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity(name="equipments")
@Table(name="equipments")
public class Equipments {
	@Id
	@Column(name="Equipment_id")
	private int equipment_id  ;
	@Column(name="Equipment_code")
	private String equipment_code; 
	@Column(name="Equipment_Purchase_Date")
	private Date equipment_Purchase_Date;
	@Column(name="Equipment_Damage_Ind")
	private String equipment_Damage_Ind ;
	@Column(name="Equipment_price")
	private int equipment_price		;
	public int getEquipment_id() {
		return equipment_id;
	}
	public void setEquipment_id(int equipment_id) {
		equipment_id = equipment_id;
	}
	public String getEquipment_code() {
		return equipment_code;
	}
	public void setEquipment_code(String equipment_code) {
		equipment_code = equipment_code;
	}
	public Date getEquipment_Purchase_Date() {
		return equipment_Purchase_Date;
	}
	public void setEquipment_Purchase_Date(Date equipment_Purchase_Date) {
		equipment_Purchase_Date = equipment_Purchase_Date;
	}
	public String getEquipment_Damage_Ind() {
		return equipment_Damage_Ind;
	}
	public void setEquipment_Damage_Ind(String equipment_Damage_Ind) {
		equipment_Damage_Ind = equipment_Damage_Ind;
	}
	public int getEquipment_price() {
		return equipment_price;
	}
	public void setEquipment_price(int equipment_price) {
		equipment_price = equipment_price;
	}
}