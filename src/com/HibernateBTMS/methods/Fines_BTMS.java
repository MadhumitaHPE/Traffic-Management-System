package com.HibernateBTMS.methods;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.HibernateBTMS.dto.Rules_violation;
import com.HibernateBTMS.dto.Fines;

public class Fines_BTMS {

	public void fines_Main()throws Exception
	{
		
		MainBTMS.session=MainBTMS.sessionFactory.getCurrentSession();
		Transaction tx=MainBTMS.session.beginTransaction();
		MainBTMS objMainBTMS=new MainBTMS();
		Fines_BTMS objFines_BTMS=new Fines_BTMS();
		//your code goes here
		System.out.println("^^^^^Fines^^^^^^");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your choice 1.Insert 2.Display 3. Delete 4. Update "
				+ "5.Generate Bill 6. Exit");
		int choice=sc.nextInt();


		if(choice==1)
		{
			Scanner sc1=new Scanner(System.in);
			System.out.println("Violation ID(same as Rules Violation):");
			int v_id=sc1.nextInt();
			Scanner scan1=new Scanner(System.in);
			System.out.println("Fine Amount(float):");
			float fa=scan1.nextFloat();
			Scanner fdt=new Scanner(System.in);
			System.out.println("Enter fine Date(YYYY:MM:DD):");
			String f_date=fdt.next();
			Scanner scan2=new Scanner(System.in);
			System.out.println("Fine Description:");
			String f_desc=scan2.nextLine();
			String instr="insert into fines values(:n1,:n2,:n3,:n4)";
			Query qry1=MainBTMS.session.createSQLQuery(instr);
			qry1.setParameter("n1",v_id);
			qry1.setParameter("n2",fa);
			qry1.setParameter("n3", f_date);
			qry1.setParameter("n4",f_desc);
			int r=qry1.executeUpdate();
			tx.commit();
			System.out.println(r+" Records inserted");
			objFines_BTMS.fines_Main();
		}

		else if(choice==2) 
		{
			System.out.println("***Displaying Fines Details***");
			Query qry2=MainBTMS.session.createQuery("from fines");
			List<Fines>alist=qry2.list();
			
			for(Fines a:alist)
				System.out.println(a.getViolation_ID()+
						"\t\t"+a.getFine_Amount()+"\t\t"+a.getFine_dt_time()+
						"\t\t"+a.getFine_desc());
			
			objFines_BTMS.fines_Main();
		}

		else if(choice==3) 
		{
			System.out.println("***Deleting Records***");
			Scanner del=new Scanner(System.in);
			System.out.println("Enter ID to delete");
			int id=del.nextInt();
			String delstr="delete from fines where Violation_ID=:d";
			Query qry3=MainBTMS.session.createQuery(delstr);
			qry3.setParameter("d", id);
			qry3.executeUpdate();
			tx.commit();
			System.out.println(id+" records deleted");
			objFines_BTMS.fines_Main();
		}

		else if(choice==4) 
		{
			System.out.println("***Updating Records***");
			Scanner u2=new Scanner(System.in);
			System.out.println("Enter Violation ID:");
			int n4=u2.nextInt();
			Scanner u1=new Scanner(System.in);
			System.out.println("Enter Fine Amount: ");
			int n3=u1.nextInt();
			String updstr="update fines set Fine_Amount=:n3 where Violation_ID=:n4";
			Query qry4=MainBTMS.session.createQuery(updstr);
			qry4.setParameter("n3",n3);
			qry4.setParameter("n4",n4);
			int status=qry4.executeUpdate();
			System.out.println(status);
			tx.commit();
			objFines_BTMS.fines_Main();
		}
		else if(choice==5) 
		{
			System.out.println("\n Spot Fine \n");
			Scanner gb=new Scanner(System.in);
			System.out.println("Enter Violation ID: ");
			int vid=gb.nextInt();
			String genbill="from fines where Violation_ID="+vid;
			Query qry5=MainBTMS.session.createQuery(genbill);
			List<Fines>gbil=qry5.list();
			
			for(Fines f:gbil)
				System.out.println("\nViolation ID: "+f.getViolation_ID()+"\n"
						+"\nFine Amount: "+f.getFine_Amount()
						+"\n"+"\nFine Description: "+f.getFine_desc());

			String genbill1="from Rules_violation where Violation_ID="+vid;
			Query qry6=MainBTMS.session.createQuery(genbill1);
			List<Rules_violation>gbil1=qry6.list(); 
			
			for(Rules_violation r:gbil1)
				System.out.println("\n"+"Vehicle Number: "+r.getVehicle_No()
						+"\n"+"Violation Description: "+r.getViolation_Desc());
			
			objFines_BTMS.fines_Main();
		}
		else if(choice==6)
		{

			objMainBTMS.btms_Main();
		}
		else 
		{
			System.out.println("Invalid Input");
			objFines_BTMS.fines_Main();
		}
		tx.commit();
	}
}
