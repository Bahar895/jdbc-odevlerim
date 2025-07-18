package org.bebka.jdbc.service;

import org.bebka.jdbc.dao.StudentDAO;
import org.bebka.jdbc.model.Student;
import org.bebka.jdbc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentService {

    private final StudentDAO studentDAO = new StudentDAO();

    public void performStudentOperations() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Student student = new Student("Mehmet", "Yılmaz");
            studentDAO.saveStudent(session, student);

            student.setName("Mehmet Güncel");
            studentDAO.updateStudent(session, student);

            studentDAO.deleteStudent(session, student);

            tx.commit();
            System.out.println("Tüm işlemler başarılı şekilde tamamlandı.");

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                System.out.println("Hata oldu, işlemler geri alındı.");
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}