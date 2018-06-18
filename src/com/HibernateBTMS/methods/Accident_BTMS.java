package com.HibernateBTMS.methods;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.HibernateBTMS.dto.Accidents;
import com.HibernateBTMS.dto.Casualty;
import com.HibernateBTMS.dto.Injury;

public class Accident_BTMS {


	public void accident_Main() throws Exception
	{
		MainBTMS.session=MainBTMS.sessionFactory.getCurrentSession();
		Transaction tx=MainBTMS.session.beginTransaction();
		Accident_BTMS objAccident_BTMS=new Accident_BTMS();
		MainBTMS objMainBTMS=new MainBTMS();
		//your code goes here
		Scanner sc=new Scanner(System.in);
		System.out.println("^^^^^Accidents^^^^^^");
		System.out.println("Enter your choice 1.Insert 2.Display"
				+ " 3. Delete 4. Update 5. Casualty 6. Injury "
				+ " 7. Search for Casualty/Injury 8. Exit");
		int choice=sc.nextInt();
		
		if(choice==1)
		{
			System.out.println("***Inserting records***");
			Scanner sc1=new Scanner(System.in);
			System.out.println("Accident ID:");
			int a_id = sc1.nextInt();
			Scanner sc2=new Scanner(System.in);
			System.out.println("Accident Location:");
			String a_loc=sc2.nextLine();
			Scanner sc3=new Scanner(System.in);
			System.out.println("Accident Date (YYYY:MM:DD): ");
			String a_DateTime=sc3.nextLine();
			Scanner sc4=new Scanner(System.in);
			System.out.println("Accident Reason:");
			String a_reason=sc4.nextLine();
			Scanner sc5=new Scanner(System.in);
			System.out.println("Accident Vehicle Number(last 4 digits):");
			int v_no=sc5.nextInt();
			Scanner sc6=new Scanner(System.in);
			System.out.println("Number of persons affected:");
			int no_of_persons=sc6.nextInt();
			
			String instr="insert into accidents values(:n1,:n2,:n3,:n4,:n5,:n6)";
			Query qry1=MainBTMS.session.createSQLQuery(instr);
			
			qry1.setParameter("n1",a_id);
			qry1.setParameter("n2",a_loc);
			qry1.setParameter("n3",a_DateTime);
			qry1.setParameter("n4",a_reason);
			qry1.setParameter("n5",v_no);
			qry1.setParameter("n6",no_of_persons);

			int r=qry1.executeUpdate();
			tx.commit();
			System.out.println(r+" Records inserted");
			objAccident_BTMS.accident_Main();
		}
		else if(choice==2) 
		{
			System.out.println("***Displaying Accident Details***");
			Query qry2=MainBTMS.session.createQuery("from accidents");
			List<Accidents>alist=qry2.list();
			
			for(Accidents a:alist)
				System.out.println(a.getAccident_ID()+"\t\t"+a.getAccident_Location()+
				"\t\t"+a.getAccident_dt_time()+"\t\t"+a.getAccident_Reason()
				+"\t\t"+a.getVehicle_No()+"\t\t"+a.getNo_Person_Affected()+"\t\t");
			
			objAccident_BTMS.accident_Main();
		}
		else if(choice==3) 
		{
			System.out.println("***Deleting Records***");
			Scanner del=new Scanner(System.in);
			System.out.println("Enter Accident ID:");
			int acc=del.nextInt();
			String delstr="delete from accidents where Accident_ID=:d";
			Query qry3=MainBTMS.session.createQuery(delstr);
			qry3.setParameter("d", acc);
			qry3.executeUpdate();
			tx.commit();
			System.out.println(acc+"records deleted");
			objAccident_BTMS.accident_Main();
		}
		else if(choice==4) 
		{
			System.out.println("***Updating Records***");

			Scanner u2=new Scanner(System.in);
			System.out.println("Enter Accident ID:");
			int n4=u2.nextInt();
			Scanner u1=new Scanner(System.in);
			System.out.println("Enter Vehicle Number to update: ");
			int n3=u1.nextInt();
			String updstr="update accidents set Vehicle_No=:n3 where Accident_ID=:n4";
			Query qry4=MainBTMS.session.createQuery(updstr);
			qry4.setParameter("n3",n3);
			qry4.setParameter("n4",n4);
			int status=qry4.executeUpdate();
			tx.commit();
			System.out.println(status);
			objAccident_BTMS.accident_Main();
		}
		else if(choice==5) 
		{
			Casualty_BTMS cas=new Casualty_BTMS();
			cas.casualty_Main();
		}
		else if(choice==6) 
		{
			Injury_BTMS ib=new Injury_BTMS();
			ib.injury_Main();
		}
		else if(choice==7) 
		{
			System.out.println("Search for casualty/injury using ID");
			Scanner sci=new Scanner(System.in);
			System.out.println("Enter ID to search: ");
			int id=sci.nextInt();
			String SearchCas="from casualty where Accident_ID=";
			Query qry5=MainBTMS.session.createQuery(SearchCas+id);
			List<Casualty>alist=qry5.list();
			for(Casualty c:alist)
				System.out.println(c.getAccident_ID()+"\t\t"+c.getCasualty_name()
				+"\t\t"+c.getCasualty_address()+"\t\t"+c.getCasualty_sex()
				+"\t\t"+c.getCasualty_age()+"\t\t"+c.getCasualty_color()+"\t\t"
				+c.getDeath_Reason()+"\t\t"+c.getAdmitted_Hospital());
			String SearchInj="from injury where Accident_ID=";
			Query qry6=MainBTMS.session.createQuery(SearchInj+id);
			List<Injury>alist1=qry6.list();
			for(Injury i:alist1)
				System.out.println(i.getAccident_ID()+"\t\t"+i.getPatient_name()
				+"\t\t"+i.getPatient_age()+"\t\t"+i.getPatient_address()+"\t\t"
				+i.getInjury_type());
			objAccident_BTMS.accident_Main();
		}
		else if(choice==8)
		{
			objMainBTMS.btms_Main();
		}
		else 
		{
			System.out.println("Invalid Input");
			objAccident_BTMS.accident_Main();
		}
		//your code goes here
		tx.commit();
	}
}
