package com.HibernateBTMS.methods;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.HibernateBTMS.dto.Pollution;

public class Pollution_BTMS {
	
	public void pollution_Main()throws Exception
	{
		MainBTMS.session=MainBTMS.sessionFactory.getCurrentSession();
		Transaction tx=MainBTMS.session.beginTransaction();
		MainBTMS objMainBTMS=new MainBTMS();
		
		Pollution_BTMS objPollution_BTMS=new Pollution_BTMS(); 
		//your code goes here
		System.out.println("^^^^^Pollution^^^^^^");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your choice 1.Insert 2.Display 3. Exit");
		int choice=sc.nextInt();
		if(choice==1) 
		{
			System.out.println("***Inserting records***");
			Scanner sc1=new Scanner(System.in);
			System.out.println("Polluted Region:");
			String pol_reg=sc1.nextLine();
			Scanner sc2=new Scanner(System.in);
			System.out.println("Pollution Level(ppm)(float):");
			float pol_lev=sc2.nextFloat();
			Scanner sc3=new Scanner(System.in);
			System.out.println("Enter date of pollution (YYYY:MM:DD)");
			String p_date=sc3.nextLine();
			String instr="insert into pollution values(:n1,:n2,:n3)";
			Query qry1=MainBTMS.session.createSQLQuery(instr);
			qry1.setParameter("n1",pol_reg);
			qry1.setParameter("n2",pol_lev);
			qry1.setParameter("n3",p_date);

			int r=qry1.executeUpdate();
			tx.commit();
			System.out.println(r+" Records inserted");
			objPollution_BTMS.pollution_Main();
		}
		else if(choice==2)
		{
			System.out.println("***Displaying Pollution Details***");
			Query qry2=MainBTMS.session.createQuery("from pollution");
			List<Pollution>alist=qry2.list();
			/*for(Pollution p:alist)
				System.out.println(p.getArea_Polluted()+"\t\t"+p.getPollution_Level_ppm()
						+"\t\t"+p.getPollution_Dt_Time());*/
			alist.forEach(
					(p)->System.out.println(p.getArea_Polluted()+"\t\t"+p.getPollution_Level_ppm()
					+"\t\t"+p.getPollution_Dt_Time())
					);
			objPollution_BTMS.pollution_Main();
		}
		else if(choice==3) 
		{

			objMainBTMS.btms_Main();
		}
		else 
		{
			System.out.println("Invalid Input");
			objPollution_BTMS.pollution_Main();
		}
		tx.commit();
	}
}
