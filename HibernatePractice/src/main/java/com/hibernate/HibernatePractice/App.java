package com.hibernate.HibernatePractice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;
public class App 
{
    public static void main( String[] args )
    {
    	Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	SessionFactory sfactory = configuration.buildSessionFactory();
    	Session session = sfactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an option:");
		System.out.println("1. Add a Student");
		System.out.println("2. Delete a Student");
		System.out.println("3. Update a Student");
		System.out.println("4. Search Students");
		System.out.println("5. Show all Students");
		System.out.println("6. exit");
		
		int option = sc.nextInt();
		switch(option) {
		case 1:
			Student st = new Student();
			System.out.println("Enter id");
			st.setStudentId(sc.nextInt());
			System.out.println("Enter name");
			st.setStudentName(sc.next());
			System.out.println("Enter marks");
			st.setMarks(sc.nextInt());
			System.out.println("Enter city");
			st.setCity(sc.next());
			
			session.save(st);
			tx.commit();
			break;
		case 2:
			System.out.println("Enter ID");
			int i = sc.nextInt();
			Student st2 = session.get(Student.class, i);
			session.delete(st2);
			session.getTransaction().commit();
			break;
		case 3:
			System.out.println("Enter ID");
			int j = sc.nextInt();
			Student st3 = session.get(Student.class, j);
			System.out.println("Enter name");
			st3.setStudentName(sc.next());
			System.out.println("Enter marks");
			st3.setMarks(sc.nextInt());
			System.out.println("Enter city");
			st3.setCity(sc.next());
			session.getTransaction().commit();
		case 4:
			System.out.println("Enter ID");
			int  k= sc.nextInt();
			Student st4 = session.get(Student.class, k);
			System.out.println(st4.getStudentId() + " " + st4.getStudentName() + " " 
								+ st4.getMarks() + " " + st4.getCity());
		case 5:
			List<Student> stdList = session.createQuery("FROM Student").getResultList();
			Iterator<Student> it = stdList.iterator();
			while(it.hasNext()) {
				System.out.println(it.next().getStudentId() + " " + it.next().getStudentName() + " " 
						+ it.next().getMarks() + " " + it.next().getCity());
			}
		}
    }
}
