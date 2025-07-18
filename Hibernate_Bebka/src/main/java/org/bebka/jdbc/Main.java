package org.bebka.jdbc;

import org.bebka.jdbc.model.Student;
import org.bebka.jdbc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        // SessionFactory'yi al
        SessionFactory factory = HibernateUtil.getSessionFactory();

        // Oturumu başlat
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Yeni öğrenci oluştur ve veritabanına kaydet
        Student student = new Student("Bahar", "Aydın");
        session.save(student);

        // Veriyi geri okuma
        Student readStudent = session.get(Student.class, 4);
        System.out.println(readStudent);

        //Update
        readStudent.setName("Derin");
        readStudent.setSurname("Aydın");
        session.update(readStudent);

        //Öğrenciyi silme işlemi
        session.delete(readStudent);
        System.out.println("Öğrenci silindi" + readStudent);

        tx.commit();

        // Oturumu kapat
        session.close();
    }
}