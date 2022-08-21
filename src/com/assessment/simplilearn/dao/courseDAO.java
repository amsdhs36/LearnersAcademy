package com.assessment.simplilearn.dao;

import java.util.List;

import com.assessment.simplilearn.connect.HibConfig;
import com.assessment.simplilearn.entity.course;
import com.assessment.simplilearn.entity.student;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class courseDAO {
	public void saveCourse(course c) {
        Transaction transaction = null;
        try (Session session1 = HibConfig.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session1.beginTransaction();
            // save the course object
            session1.save(c);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        
    }
	 public void updateCourse(course c) {
	        Transaction transaction = null;
	        try (Session session1 = HibConfig.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session1.beginTransaction();
	            // save the course object
	            session1.update(c);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
	 public void deleteCourse(int courseid) {

	        @SuppressWarnings("unused")
			Transaction transaction = null;
	        try (Session session1 = HibConfig.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session1.beginTransaction();

	            // Delete a course object
	            course c = session1.get(course.class, courseid);
	            if (c != null) {
	                session1.delete(c);
	                System.out.println("course is deleted");
	            }

}}
	 public student getCourse(int id) {

    Transaction transaction = null;
    student s = null;
    try (Session session1 = HibConfig.getSessionFactory().openSession()) {
        // start a transaction
        transaction = session1.beginTransaction();
        // get an course object
        s = session1.get(student.class, id);
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
public List < course > getAllCourse() {
    Transaction transaction = null;
    List < course > listOfCourses = null;
    try (Session session1 = HibConfig.getSessionFactory().openSession()) {
        // start a transaction
        transaction = session1.beginTransaction();
        // get a course object

        listOfCourses = session1.createQuery("from course").getResultList();

        // commit transaction
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }
    return listOfCourses;
}
}
