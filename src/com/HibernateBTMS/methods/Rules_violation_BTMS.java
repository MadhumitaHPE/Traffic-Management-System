package com.HibernateBTMS.methods;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.HibernateBTMS.dto.Rules_violation;

public class Rules_violation_BTMS {


	public void rules_violation_Main() throws Exception
	{
		
		MainBTMS.session=MainBTMS.sessionFactory.getCurrentSession();
		Transaction tx=MainBTMS.session.beginTransaction();
		MainBTMS objMainBTMS=new MainBTMS();
		Rules_violation_BTMS objRules_violation_BTMS=new Rules_violation_BTMS();
		//your code goes here
		System.out.println("^^^^^Rules_Violation^^^^^^");
		Scanner c=new Scanner(System.in);
		System.out.println("Enter your choice 1.Insert 2.Display 3. Delete 4. Update "
				+ "5. Exit");
		int choice=c.nextInt();


		if(choice==1) 
		{
			System.out.println("***Inserting records***");
			Scanner sc=new Scanner(System.in);
			System.out.println("Violation ID:");
			int v_id=sc.nextInt();
			Scanner sc1=new Scanner(System.in);
			System.out.println("Violation Description:");
			String v_desc=sc1.nextLine();
			Scanner sc2=new Scanner(System.in);
			System.out.println("Vehicle No(last 4 digits of vehicle no):");
			int v_no=sc2.nextInt();
			Scanner sc3=new Scanner(System.in);
			System.out.println("Vehicle Type:");
			String v_type=sc3.nextLine();
			Scanner sc4=new Scanner(System.in);
			System.out.println("Violation Place:");
			String v_place=sc4.nextLine();
			Scanner sc5=new Scanner(System.in);
			System.out.println("Date  (YYYY:MM:DD)");
			String v_datetime=sc5.nextLine();
			Scanner sc6=new Scanner(System.in);
			System.out.println("Enter violator's age");
			int v_age=sc6.nextInt();
			String instr="insert into Rules_violation values(:n1,:n2,:n3,:n4,:n5,:n6,:n7)";
			Query qry1=MainBTMS.session.createSQLQuery(instr);
			qry1.setParameter("n1",v_id );
			qry1.setParameter("n2",v_desc);
			qry1.setParameter("n3",v_no);
			qry1.setParameter("n4",v_type);
			qry1.setParameter("n5",v_place);
			qry1.setParameter("n6",v_datetime);
			qry1.setParameter("n7", v_age);

			int r=qry1.executeUpdate();
			tx.commit();
			System.out.println(r+" Records inserted");
			objRules_violation_BTMS.rules_violation_Main();
		}

		else if(choice==2) 
		{
			System.out.println("***Displaying Rules Violation Details***");
			Query qry2=MainBTMS.session.createQuery("from Rules_violation");
			List<Rules_violation>alist=qry2.list();
			
			for(Rules_violation r:alist)
				System.out.println(r.getViolation_ID()+"\t\t"+r.getViolation_Desc()
				+"\t\t"+r.getVehicle_No()+"\t\t"+r.getVehicle_Type()+"\t\t"
				+r.getViolation_Place()+"\t\t"+r.getViolation_dt_time());
			
			objRules_violation_BTMS.rules_violation_Main();
		}

		else if(choice==3) 
		{
			System.out.println("***Deleting Records***");
			Scanner del=new Scanner(System.in);
			System.out.println("Enter ID to delete");
			int id=del.nextInt();
			String delstr="delete from Rules_violation where Violation_ID=:d";
			Query qry3=MainBTMS.session.createQuery(delstr);
			qry3.setParameter("d", id);
			qry3.executeUpdate();
			tx.commit();
			System.out.println(id+" records deleted");
			objRules_violation_BTMS.rules_violation_Main();
		}

		else if(choice==4)
		{
			System.out.println("***Updating Records***");
			Scanner u2=new Scanner(System.in);
			System.out.println("Enter Violation ID:");
			int n4=u2.nextInt();
			Scanner u1=new Scanner(System.in);
			System.out.println("Enter Vehicle Number to update: ");
			int n3=u1.nextInt();
			String updstr="update Rules_violation set Vehicle_No=:n3 where Violation_ID=:n4";
			Query qry4=MainBTMS.session.createQuery(updstr);
			qry4.setParameter("n3",n3);
			qry4.setParameter("n4",n4);
			int status=qry4.executeUpdate();
			tx.commit();
			System.out.println(status);
			objRules_violation_BTMS.rules_violation_Main();
		}
		else if(choice==5)
		{

			objMainBTMS.btms_Main();
		}
		else 
		{
			System.out.println("Invalid Input");
			objRules_violation_BTMS.rules_violation_Main();
		}
		tx.commit();
	}
}
