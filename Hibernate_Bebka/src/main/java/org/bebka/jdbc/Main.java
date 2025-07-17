package org.bebka.jdbc;

import org.bebka.jdbc.model.Student;
import org.bebka.jdbc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {

        // SessionFactory'yi al
        SessionFactory factory = HibernateUtil.getSessionFactory();

        // Oturumu başlat
        Session session = factory.openSession();
        session.beginTransaction();

        // Yeni öğrenci oluştur ve veritabanına kaydet
        Student student = new Student("Bahar", "Aydın");
        session.save(student);

        // Veriyi geri okuma
        Student readStudent = session.get(Student.class, student.getId());
        System.out.println("Veritabanından okunan öğrenci: " + readStudent);

        // Oturumu kapat
        session.getTransaction().commit();
        session.close();
    }
}