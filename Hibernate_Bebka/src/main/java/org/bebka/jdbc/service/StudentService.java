package org.bebka.jdbc.service;

import org.bebka.jdbc.dao.StudentDAO;
import org.bebka.jdbc.model.Student;
import org.hibernate.Session;

public class StudentService {

    private StudentDAO studentDAO;

    // === BU CONSTRUCTOR'I EKLE ===
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void createUser(Session session, Student student) {
        studentDAO.createUser(session, student);
    }

    public Student getUserById(Session session, Long id) {
        return studentDAO.getUserById(session, id);
    }

    public void updateUser(Session session, Student student) {
        studentDAO.updateUser(session, student);
    }

    public void deleteUser(Session session, Student student) {
        studentDAO.deleteUser(session, student);
    }
}