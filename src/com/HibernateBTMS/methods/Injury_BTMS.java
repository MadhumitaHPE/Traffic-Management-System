package com.HibernateBTMS.methods;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.HibernateBTMS.dto.Injury;

public class Injury_BTMS {

	public void injury_Main()throws Exception
	{
		
		MainBTMS.session=MainBTMS.sessionFactory.getCurrentSession();
		Transaction tx=MainBTMS.session.beginTransaction();
		Accident_BTMS objAccident_BTMS=new Accident_BTMS();
		Injury_BTMS objInjury_BTMS=new Injury_BTMS();
		//your code goes here
		System.out.println("^^^^^Injury^^^^^^");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your choice 1.Insert 2.Display 3. Delete 4. Update "
				+ "5. Exit");
		int choice=sc.nextInt();


		if(choice==1) 
		{
			System.out.println("***Inserting records***");
			Scanner sc1=new Scanner(System.in);
			System.out.println("Enter Injury ID(same as Accidents):");
			int injury_id=sc1.nextInt();
			Scanner sc2=new Scanner(System.in);
			System.out.println("Enter patient name:");
			String p_name=sc2.nextLine();
			Scanner sc3=new Scanner(System.in);
			System.out.println("Enter patient age:");
			int p_age=sc1.nextInt();
			Scanner sc4=new Scanner(System.in);
			System.out.println("Enter patient address:");
			String p_address=sc4.nextLine();
			Scanner sc5=new Scanner(System.in);
			System.out.println("Enter injury type:");
			String injury_type=sc5.nextLine();
			String instr="insert into injury values(:n1,:n2,:n3,:n4,:n5)";
			Query qry1=MainBTMS.session.createSQLQuery(instr);
			qry1.setParameter("n1",injury_id);
			qry1.setParameter("n2",p_name);
			qry1.setParameter("n3",p_age);
			qry1.setParameter("n4",p_address);
			qry1.setParameter("n5",injury_type);

			int r=qry1.executeUpdate();
			tx.commit();
			System.out.println(r+" Records inserted");
			objInjury_BTMS.injury_Main();
		}

		else if(choice==2) 
		{
			System.out.println("***Displaying Injury Details***");
			Query qry2=MainBTMS.session.createQuery("from injury");
			List<Injury>alist=qry2.list();
			
			for(Injury i:alist)
				System.out.println(i.getAccident_ID()+"\t\t"+i.getPatient_name()+"\t\t"
						+i.getPatient_age()+"\t\t"+i.getPatient_address()+"\t\t"
						+i.getInjury_type());
			
			objInjury_BTMS.injury_Main();
		}

		else if(choice==3) 
		{
			System.out.println("***Deleting Records***");
			Scanner del=new Scanner(System.in);
			System.out.println("Enter ID to delete");
			int id=del.nextInt();
			String delstr="delete from injury where Accident_ID=:d";
			Query qry3=MainBTMS.session.createQuery(delstr);
			qry3.setParameter("d", id);
			qry3.executeUpdate();
			tx.commit();
			System.out.println(id+" records deleted");
			objInjury_BTMS.injury_Main();
		}

		else if(choice==4) 
		{
			System.out.println("***Updating Records***");
			Scanner u2=new Scanner(System.in);
			System.out.println("Enter Accident ID:");
			int n4=u2.nextInt();
			Scanner u1=new Scanner(System.in);
			System.out.println("Enter Patient Name to update: ");
			String n3=u1.next();
			String updstr="update injury set Patient_name=:n3 where Accident_ID=:n4";
			Query qry4=MainBTMS.session.createQuery(updstr);
			qry4.setParameter("n3",n3);
			qry4.setParameter("n4",n4);
			int status=qry4.executeUpdate();
			tx.commit();
			System.out.println(status);
			objInjury_BTMS.injury_Main();
		}
		else if(choice==5)
		{

			objAccident_BTMS.accident_Main();
		}
		else
		{
			System.out.println("Invalid Input");
			objInjury_BTMS.injury_Main();
		}
		tx.commit();
		tx.commit();
	}
}
