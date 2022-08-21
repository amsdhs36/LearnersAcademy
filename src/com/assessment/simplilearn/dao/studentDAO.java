package com.assessment.simplilearn.dao;

import java.util.List;

import com.assessment.simplilearn.connect.HibConfig;
import com.assessment.simplilearn.entity.student;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class studentDAO{
	public void saveStudent(student s) {
        Transaction transaction = null;
        try (Session session2 = HibConfig.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session2.beginTransaction();
            // save the student object
            session2.save(s);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	 public void updateStudent(student s) {
	        Transaction transaction = null;
	        try (Session session2 = HibConfig.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session2.beginTransaction();
	            // save the student object
	            session2.update(s);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
	 public void deleteStudent(int id) {

	        Transaction transaction = null;
	        try (Session session2 = HibConfig.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session2.beginTransaction();

	            // Delete a user object
	            student s = session2.get(student.class, id);
	            if (s != null) {
	                session2.delete(s);
	                System.out.println("student is deleted");
	            }

	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
	 public student getStudent(int id) {

	        Transaction transaction = null;
	        student s = null;
	        try (Session session2 = HibConfig.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session2.beginTransaction();
	            // get an user object
	            s = session2.get(student.class, id);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return s;
	    }
	 @SuppressWarnings("unchecked")
	    public List < student > getAllStudent() {
	        Transaction transaction = null;
	        List <student> listOfStudent = null;
	        try (Session session2 = HibConfig.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session2.beginTransaction();
	            // get a student object

	            listOfStudent = session2.createQuery("from student").getResultList();

	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return listOfStudent;
	    }
}