package com.HibernateBTMS.methods;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Column;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.HibernateBTMS.dto.Rules_violation;
import com.HibernateBTMS.dto.Accidents;
import com.HibernateBTMS.dto.Casualty;
import com.HibernateBTMS.dto.Equipments;
import com.HibernateBTMS.dto.Fines;
import com.HibernateBTMS.dto.Injury;
import com.HibernateBTMS.dto.Pollution;
import com.HibernateBTMS.dto.Traffic;


public class Report_BTMS {


	public void report_Main() throws Exception
	{
	
		MainBTMS.session=MainBTMS.sessionFactory.getCurrentSession();
		Transaction tx=MainBTMS.session.beginTransaction();
		MainBTMS objMainBTMS=new MainBTMS();
		Report_BTMS objReport_BTMS=new Report_BTMS();
		//your code goes here
		System.out.println("#####Reports######");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter your choice 1. Rules Violation 2. Fines 3.Accident "
		+ "4.Casualty 5. Injury 6. Equipments 7. Pollution  8. Traffic 9. Exit");
		
		int choice=sc.nextInt();
		if(choice==1) 
		{
			System.out.println("***Displaying Rules Violation Details***");
			Query qry2=MainBTMS.session.createQuery("from Rules_violation");
			List<Rules_violation>alist=qry2.list();
			
			for(Rules_violation r	:alist)
				System.out.println(r.getViolation_ID()+"\t\t"+r.getViolation_Desc()
				+"\t\t"+r.getVehicle_No()+"\t\t"+r.getVehicle_Type()+"\t\t"
				+r.getViolation_Place()+"\t\t"+r.getViolation_dt_time());
			
			objReport_BTMS.report_Main();
		}

		else if(choice==2) 
		{
			System.out.println("***Displaying Fines Details***");
			Query qry2=MainBTMS.session.createQuery("from fines");
			List<Fines>alist=qry2.list();
			
			for(Fines f:alist)
				System.out.println(f.getViolation_ID()+"\t\t"+f.getFine_Amount()
									+"\t\t"+f.getFine_desc());
			 
			objReport_BTMS.report_Main();
		}
		else if(choice==3) 
		{
			System.out.println("***Displaying Accident Details***");
			Query qry2=MainBTMS.session.createQuery("from accidents");
			List<Accidents>alist=qry2.list();
			
			for(Accidents a:alist)
				System.out.println(a.getAccident_ID()+"\t\t"+a.getAccident_Location()
				+"\t\t"+a.getAccident_dt_time()+"\t\t"+a.getAccident_Reason()+"\t\t"
						+a.getVehicle_No()+"\t\t"+a.getNo_Person_Affected());
			
			objReport_BTMS.report_Main();
		}
		else if(choice==4) 
		{
			System.out.println("***Displaying Casualty Details***");
			Query qry2=MainBTMS.session.createQuery("from casualty");
			List<Casualty>alist=qry2.list();
			
			for(Casualty c:alist)
				System.out.println(c.getAccident_ID()+"\t\t"+c.getCasualty_name()
				+"\t\t"+c.getCasualty_address()+"\t\t"+c.getCasualty_sex()+"\t\t"
				+c.getCasualty_age()+"\t\t"+c.getCasualty_color()+"\t\t"
				+c.getDeath_Reason()+"\t\t"+c.getAdmitted_Hospital());
			
			objReport_BTMS.report_Main();
		}
		else if(choice==5)
		{
			System.out.println("***Displaying Injury Details***");
			Query qry2=MainBTMS.session.createQuery("from injury");
			List<Injury>alist=qry2.list();
			
			for(Injury i:alist)
				System.out.println(i.getAccident_ID()+"\t\t"+i.getPatient_name()
				+"\t\t"+i.getPatient_age()+"\t\t"+i.getPatient_address()+"\t\t"
				+i.getInjury_type());
			
			objReport_BTMS.report_Main();
		}
		else if(choice==6) 
		{
			System.out.println("***Displaying Equipments Details***");
			Query qry2=MainBTMS.session.createQuery("from equipments");
			List<Equipments>alist=qry2.list();
			
			for(Equipments e:alist)
				System.out.println(e.getEquipment_id()+"\t\t"+e.getEquipment_code()+"\t\t"
						+e.getEquipment_Purchase_Date()+"\t\t"
						+e.getEquipment_Damage_Ind()
						+"\t\t"+e.getEquipment_price());
			
			objReport_BTMS.report_Main();
		}


		else if(choice==7)
		{
			System.out.println("***Displaying Pollution Details***");
			Query qry2=MainBTMS.session.createQuery("from pollution");
			List<Pollution>alist=qry2.list();
			
			for(Pollution p:alist)
				System.out.println(p.getArea_Polluted()+"\t\t"
						+p.getPollution_Level_ppm()+"\t\t"
						+p.getPollution_Dt_Time());
			
			objReport_BTMS.report_Main();
		}

		else if(choice==8) 
		{
			System.out.println("***Displaying Traffic Details***");
			Query qry2=MainBTMS.session.createQuery("from traffic");
			List<Traffic>alist=qry2.list();
			
			for(Traffic t:alist)
				System.out.println(t.getTraffic_Ind()+"\t\t"+t.getTraffic_Loc()
					+"\t\t"+t.getTraffic_Dt_Time()+"\t\t"+t.getTraffic_Video_Path());
			
			objReport_BTMS.report_Main();
		}
		else if(choice==9){
			System.out.println("---Exiting-----");
			objMainBTMS.btms_Main();
		}
		{
			System.out.println("Invalid Input");
			objMainBTMS.btms_Main();
		}
		tx.commit();

	}
}
