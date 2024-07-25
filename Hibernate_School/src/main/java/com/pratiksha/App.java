package com.pratiksha;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static SessionFactory factory;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Configuration config = new Configuration();

		config.configure("hibernate.cfg.xml");

		factory = config.buildSessionFactory();

		StudentDAO sd = new StudentDAO(factory);

		int ch;

		do {
			
			System.out.println("Menu");
			System.out.println("1.Add Student");
			System.out.println("2.Update Student");
			System.out.println("3.Delete Student");
			System.out.println("4.Get Student By Id");
			System.out.println("5.Exit");
			System.out.println("Enter your choice");
			ch = sc.nextInt();

			switch (ch) {
			case 1: {

				System.out.println("Enter the id of student:");
				int id = sc.nextInt();

				System.out.println("Enter the name of the student:");
				String name = sc.next();

				System.out.println("Enter the gender of the student:");
				String gender = sc.next();

				System.out.println("Enter the address of the student:");
				String address = sc.next();

				Student s = new Student(id, name, gender, address);
				sd.addStudent(s);
				break;
			}
			case 2: {

				System.out.println("Enter the id of the student you want to update:");
				int id = sc.nextInt();
				sd.updateStudent(id);

				break;
			}
			case 3: {

				System.out.println("Enter the id of student that you want to delete:");
				int id = sc.nextInt();
				sd.deleteStudent(id);
				break;
			}
			case 4: {
				System.out.println("Enter the student id:");
				int id = sc.nextInt();
				Student s = sd.getStudent(id);
				System.out.println("Name of student is:"+s.getName());
				System.out.println("Gender of student is:"+s.getGender());
				System.out.println("Address of student is:"+s.getAddress());
				System.out.println("Information Retrieved Sucessfully");
				break;
			}
			case 5: {
				System.out.println("Taking Exit");
				break;
			}
			default:
				System.out.println("Invalid choice...Enter valid choice..!");
				break;

			}
		} while (ch != 5);

	}
}
