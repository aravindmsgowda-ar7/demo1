package com.MavenTest.mvnSimple;




import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Entity.Employee;
import Entity.Laptop;
import Entity.Student;

public class App 
{
    public static void main( String[] args )
    {
		/*
		 * Student s1 = new Student(); s1.setRollno(102); s1.setAge(21);
		 * s1.setSname("aravind");
		 */

    	Laptop l1 = new Laptop();
    	l1.setLid(102);
    	l1.setBrand("dell");
    	l1.setModel("lattitude");
    	l1.setRam(16);
    	Laptop l2 = new Laptop();
    	l2.setLid(103);
    	l2.setBrand("HP");
    	l2.setModel("h105");
    	l2.setRam(16);
    	
    	Employee e = new Employee();
    	e.setDesignation("sde1");
    	e.setEid(01);
    	e.setEname("aravind");
    	e.setLaptop(Arrays.asList(l1,l2));
    	
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Entity.Employee.class).addAnnotatedClass(Entity.Laptop.class);
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        
    //    Student s2 = session.get(Student.class, 101);
        Transaction transaction = session.beginTransaction();
        
        session.persist(l1); 
        session.persist(l2); 
        session.persist(e);   //store or save the data
    //    session.remove(s2);      // delete a row
        
        transaction.commit();
    //    Student s2 = session.get(Student.class, 101);   // used to read data
        
        session.close();
        sf.close();
  //      System.out.println(s2.getSname());

    }
}
