package org.bebka.jdbc.dao;

import org.bebka.jdbc.model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAO {

    public void createUser(Session session, Student student) {
        Transaction tx = session.beginTransaction();
        try {
            session.save(student);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    public Student getUserById(Session session, Long id) {
        return session.get(Student.class, id);
    }

    public void updateUser(Session session, Student student) {
        Transaction tx = session.beginTransaction();
        try {
            session.update(student);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    public void deleteUser(Session session, Student student) {
        Transaction tx = session.beginTransaction();
        try {
            session.delete(student);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}