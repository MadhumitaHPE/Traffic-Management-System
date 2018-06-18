package com.HibernateBTMS.methods;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.HibernateBTMS.dto.Casualty;

public class Casualty_BTMS {


	public void casualty_Main() throws Exception
	{
		MainBTMS.session=MainBTMS.sessionFactory.getCurrentSession();
		Transaction tx=MainBTMS.session.beginTransaction();
		Accident_BTMS objAccident_BTMS=new Accident_BTMS();
		Casualty_BTMS objCasualty_BTMS=new Casualty_BTMS();
		//your code goes here
		System.out.println("^^^^^Casualty^^^^^^");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your choice 1.Insert 2.Display 3. Delete 4. Update"
				+ " 5. Exit");
		int choice=sc.nextInt();
		if(choice==1) 
		{
			System.out.println("***Inserting records***");
			Scanner s1=new Scanner(System.in);
			System.out.println("Enter Accident ID(same as Accidents):");
			int casuality_id=s1.nextInt();
			Scanner s2=new Scanner(System.in);
			System.out.println("Casuality Name:");
			String c_name=s2.nextLine();
			Scanner s3=new Scanner(System.in);
			System.out.println("Casuality Address:");
			String c_addr=s3.nextLine();
			Scanner s4=new Scanner(System.in);
			System.out.println("Casuality Sex:");
			String c_sex=s4.nextLine();
			Scanner s5=new Scanner(System.in);
			System.out.println("Casuality Age:");
			int c_age=s5.nextInt();
			Scanner s6=new Scanner(System.in);
			System.out.println("Casuality Color:");
			String c_color=s6.nextLine();
			Scanner s7=new Scanner(System.in);
			System.out.println("Death Reason:");
			String death_res=s7.nextLine();
			Scanner s8=new Scanner(System.in);
			System.out.println("Admitted in hospital:");
			String admit_hos=s8.nextLine();
			String instr="insert into casualty values(:n1,:n2,:n3,:n4,:n5,:n6,:n7,:n8)";
			Query qry1=MainBTMS.session.createSQLQuery(instr);
			qry1.setParameter("n1",casuality_id);
			qry1.setParameter("n2",c_name);
			qry1.setParameter("n3",c_addr);
			qry1.setParameter("n4",c_sex );
			qry1.setParameter("n5",c_age );
			qry1.setParameter("n6",c_color );
			qry1.setParameter("n7",death_res );
			qry1.setParameter("n8",admit_hos );
			int r=qry1.executeUpdate();
			tx.commit();
			System.out.println(r+" Records inserted");

			objCasualty_BTMS.casualty_Main();
		}
		else if(choice==2) 
		{
			System.out.println("***Displaying Casualty Details***");
			Query qry2=MainBTMS.session.createQuery("from casualty");
			List<Casualty>alist=qry2.list();
			
			for(Casualty c:alist)
				System.out.println(c.getAccident_ID()+"\t\t"+c.getCasualty_name()+
				"\t\t"+c.getCasualty_address()+"\t\t"+c.getCasualty_sex()+"\t\t"+
				c.getCasualty_age()+"\t\t"+c.getCasualty_color()+"\t\t"
				+c.getDeath_Reason()+"\t\t"+c.getAdmitted_Hospital());
			
			objCasualty_BTMS.casualty_Main();
		}
		else if(choice==3) 
		{
			System.out.println("***Deleting Records***");
			Scanner del=new Scanner(System.in);
			System.out.println("Enter Accident ID:");
			int acc=del.nextInt();
			String delstr="delete from casualty where Accident_ID=:d";
			Query qry3=MainBTMS.session.createQuery(delstr);
			qry3.setParameter("d", acc);
			qry3.executeUpdate();
			tx.commit();
			System.out.println(acc+"records deleted");
			objCasualty_BTMS.casualty_Main();
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
			String updstr="update casualty set casualty_name=:n3 where Accident_ID=:n4";
			Query qry4=MainBTMS.session.createQuery(updstr);
			qry4.setParameter("n3",n3);
			qry4.setParameter("n4",n4);
			int status=qry4.executeUpdate();
			tx.commit();
			System.out.println(status);
			objCasualty_BTMS.casualty_Main();
		}
		else if(choice==5)
		{

			objAccident_BTMS.accident_Main();
		}
		else 
		{
			System.out.println("Invalid Input");
			objCasualty_BTMS.casualty_Main();
		}
		//your code goes here
		tx.commit();
	}
}
