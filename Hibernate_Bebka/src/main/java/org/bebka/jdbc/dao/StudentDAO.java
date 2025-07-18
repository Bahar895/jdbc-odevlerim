package org.bebka.jdbc.dao;

import org.bebka.jdbc.model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAO {

    public void saveStudent(Session session, Student student) {
        session.save(student);
    }

    public Student getStudentById(Session session, int id) {
        return session.get(Student.class, id);
    }

    public void updateStudent(Session session, Student student) {
        session.update(student);
    }

    public void deleteStudent(Session session, Student student) {
        session.delete(student);
    }
}