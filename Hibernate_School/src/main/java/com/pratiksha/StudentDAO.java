package com.pratiksha;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentDAO {

	private SessionFactory factory;

	public StudentDAO(SessionFactory factory) {
		this.factory = factory;
	}

	public void addStudent(Student s) {
		// add student
		Transaction tx = null;
		try {
			Session session = factory.openSession();

			tx = session.beginTransaction();

			session.save(s);

			tx.commit();
			
			System.out.println("Student Added Sucessfully");
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

	}

	public void updateStudent(int id) {
		// update student
		Transaction tx = null;

		Student s = null;

		try {
			Session session = factory.openSession();

			tx = session.beginTransaction();

			s = session.get(Student.class, id);

			s.setAddress("Mumbai");
			
			System.out.println("Student updated Sucessfully");

			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

	}

	public void deleteStudent(int id) {
		Transaction tx = null;
		try {
			Session session = factory.openSession();

			tx = session.beginTransaction();

			Student s = session.get(Student.class, id);

			if (s != null) {
				session.delete(s);
				tx.commit();
				System.out.println("Student deleted sucessfully");
			} else {
				System.out.println("Student is not find with this id");
			}

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

	}

	public Student getStudent(int id) {
		Student s = null;
		Transaction tx = null;
		try {
			Session session = factory.openSession();

			tx = session.beginTransaction();

			s = session.get(Student.class, id);

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

		return s;
	}
}


