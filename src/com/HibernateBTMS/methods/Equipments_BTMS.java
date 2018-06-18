package com.HibernateBTMS.methods;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.HibernateBTMS.dto.Equipments;

public class Equipments_BTMS {


	public void equipments_Main() throws Exception
	{
		MainBTMS.session=MainBTMS.sessionFactory.getCurrentSession();
		Transaction tx=MainBTMS.session.beginTransaction();
		MainBTMS objMainBTMS=new MainBTMS();
		Equipments_BTMS objEquipments_BTMS =new Equipments_BTMS();
		//your code goes here
		System.out.println("^^^^^Equipments^^^^^^");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your choice 1.Insert 2.Display 3. Delete 4. Exit");
		int choice=sc.nextInt();
		if(choice==1) {
			System.out.println("***Inserting records***");
			Scanner sc1=new Scanner(System.in);
			System.out.println("Equipment ID:");
			int e_id=sc1.nextInt();
			Scanner sc2=new Scanner(System.in);
			System.out.println("Equipment Code:");
			String e_code=sc2.nextLine();
			Scanner sc3=new Scanner(System.in);
			System.out.println("Purchase Date  (YYYY:MM:DD):");
			String e_datetime=sc3.nextLine();
			Scanner sc4=new Scanner(System.in);
			System.out.println("Damage Indicator:");
			String dam_ind=sc4.nextLine();
			Scanner sc5=new Scanner(System.in);
			System.out.println("Price(float):");
			float price=sc5.nextFloat();
			String instr="insert into equipments values(:n1,:n2,:n3,:n4,:n5)";
			Query qry1=MainBTMS.session.createSQLQuery(instr);
			qry1.setParameter("n1",e_id);
			qry1.setParameter("n2",e_code);
			qry1.setParameter("n3",e_datetime);
			qry1.setParameter("n4",dam_ind );
			qry1.setParameter("n5",price );

			int r=qry1.executeUpdate();
			tx.commit();
			System.out.println(r+" Records inserted");
			objEquipments_BTMS.equipments_Main();
		}
		else if(choice==2)
		{
			System.out.println("***Displaying Equipments Details***");
			Query qry2=MainBTMS.session.createQuery("from equipments");
			List<Equipments>alist=qry2.list();
			for(Equipments e:alist)
				System.out.println(e.getEquipment_id()+"\t\t"+e.getEquipment_code()+
				"\t\t"+e.getEquipment_Purchase_Date()+"\t\t"+e.getEquipment_Damage_Ind()
				+"\t\t"+e.getEquipment_price());
			tx.commit();
			objEquipments_BTMS.equipments_Main();
		}
		else if(choice==3) 
		{
			System.out.println("***Deleting Records***");
			Scanner del=new Scanner(System.in);
			System.out.println("Enter Equipment ID:");
			int acc=del.nextInt();
			String delstr="delete from equipments where Equipment_id=:d";
			Query qry3=MainBTMS.session.createQuery(delstr);
			qry3.setParameter("d", acc);
			qry3.executeUpdate();
			tx.commit();
			System.out.println(acc+"records deleted");
			objEquipments_BTMS.equipments_Main();
		}
		else if(choice==4) 
		{
			objMainBTMS.btms_Main();
		}
		else 
		{
			System.out.println("Invalid Input");
			objEquipments_BTMS.equipments_Main();
		}
		tx.commit();
	}
}
