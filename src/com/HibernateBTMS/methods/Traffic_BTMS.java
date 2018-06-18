package com.HibernateBTMS.methods;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.HibernateBTMS.dto.Traffic;

public class Traffic_BTMS {
	
	public void traffic_Main()throws Exception
	{
		
		MainBTMS.session=MainBTMS.sessionFactory.getCurrentSession();
		Transaction tx=MainBTMS.session.beginTransaction();;
		MainBTMS objMainBTMS=new MainBTMS();
		Traffic_BTMS objTraffic_BTMS=new Traffic_BTMS(); 
		System.out.println("^^^^^Traffic^^^^^^");
		Scanner c=new Scanner(System.in);
		System.out.println("Enter your choice 1.Insert 2.Display 3. Exit");
		int choice=c.nextInt();
		if(choice==1) 
		{
			System.out.println("***Inserting records***");
			Scanner sc=new Scanner(System.in);
			System.out.println("Traffic Indicator:");
			String t_ind=sc.nextLine();
			Scanner sc1=new Scanner(System.in);
			System.out.println("Traffic Location:");
			String t_loc=sc1.nextLine();
			Scanner sc2=new Scanner(System.in);
			System.out.println("Traffic Date  (YYYY:MM:DD):");
			String t_datetime=sc2.nextLine();
			Scanner sc3=new Scanner(System.in);
			System.out.println("Traffic Video Footage:");
			String v_path=sc3.nextLine();
			String instr="insert into traffic values(:n1,:n2,:n3,:n4)";
			Query qry1=MainBTMS.session.createSQLQuery(instr);
			qry1.setParameter("n1",t_ind);
			qry1.setParameter("n2",t_loc);
			qry1.setParameter("n3",t_datetime);
			qry1.setParameter("n4",v_path);
			int r=qry1.executeUpdate();
			tx.commit();
			System.out.println(r+" Records inserted");
			objTraffic_BTMS.traffic_Main();
		}
		else if(choice==2) 
		{
			System.out.println("***Displaying Accident Details***");
			Query qry2=MainBTMS.session.createQuery("from traffic");
			List<Traffic>alist=qry2.list();
			
			for(Traffic t:alist)
				System.out.println(t.getTraffic_Ind()+"\t\t"+t.getTraffic_Loc()+"\t\t"
						+t.getTraffic_Dt_Time()+"\t\t"+t.getTraffic_Video_Path());
			
			objTraffic_BTMS.traffic_Main();
		}
		else if(choice==3) 
		{

			objMainBTMS.btms_Main();
		}
		else 
		{
			System.out.println("Invalid Input");
			objTraffic_BTMS.traffic_Main();
		}
		tx.commit();
	}
}
