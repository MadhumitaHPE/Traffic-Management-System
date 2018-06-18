package com.HibernateBTMS.methods;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.HibernateBTMS.dto.*;

public class MainBTMS {
	static AnnotationConfiguration aconf=new AnnotationConfiguration();
	public static Session session;
	public static SessionFactory sessionFactory=aconf.configure().buildSessionFactory();

	public static void main(String args[]) throws Exception {
		aconf.addAnnotatedClass(Accidents.class);
		aconf.addAnnotatedClass(Casualty.class);
		aconf.addAnnotatedClass(Injury.class);
		aconf.addAnnotatedClass(Fines.class);
		aconf.addAnnotatedClass(Equipments.class);
		aconf.addAnnotatedClass(Pollution.class);
		aconf.addAnnotatedClass(Rules_violation.class);
		aconf.addAnnotatedClass(Traffic.class);
		System.out.println("Welcome to BTMS");
		MainBTMS objMainBTMS=new  MainBTMS();
		objMainBTMS.btms_Main();

	}

	public void btms_Main() throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("\n****Banglore Traffic Management System****\n");
		System.out.println(" 1. Rules Violation \n 2. Fines \n 3. Accident case \n "
				+ "4. Equipments \n 5. Traffic \n 6. Pollution \n 7. Reports");
		int ch=sc.nextInt();
		
		switch(ch) {
		case 1:
			System.out.println("\n-----Rules Violations-----\n");
			Rules_violation_BTMS objRules_violation_BTMS=new Rules_violation_BTMS();
			objRules_violation_BTMS.rules_violation_Main();
			break;
		case 2:
			System.out.println("\n-----Fines------\n");
			Fines_BTMS objFines_BTMS=new Fines_BTMS();
			objFines_BTMS.fines_Main();
			break;
		case 3:
			System.out.println("\n-----Accidents-----\n");
			Accident_BTMS objAccident_BTMS=new Accident_BTMS();
			objAccident_BTMS.accident_Main();	
			break;
		case 4:
			System.out.println("\n----Equipments-----\n");
			Equipments_BTMS objEquipments_BTMS=new Equipments_BTMS();
			objEquipments_BTMS.equipments_Main();
			break;
		case 5:
			System.out.println("\n-----Traffic------\n");
			Traffic_BTMS objTraffic_BTMS=new Traffic_BTMS();
			objTraffic_BTMS.traffic_Main();
			break;
		case 6:
			System.out.println("\n-----Pollution------\n");
			Pollution_BTMS objPollution_BTMS=new Pollution_BTMS();
			objPollution_BTMS.pollution_Main();
			break;
		case 7:
			System.out.println("\n-----Reports-----\n");
			Report_BTMS objReport_BTMS=new Report_BTMS();
			objReport_BTMS.report_Main();
			break;
		}

	}	

}
