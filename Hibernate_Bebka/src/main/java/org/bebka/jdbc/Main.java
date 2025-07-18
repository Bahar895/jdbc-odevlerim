package org.bebka.jdbc;

import org.bebka.jdbc.model.Student;
import org.bebka.jdbc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // 1. Öğrenci oluştur ve kaydet
            Student student = new Student("Bahar", "Aydın");
            session.save(student);

            // 2. Öğrenciyi veritabanından al
            Student readStudent = session.get(Student.class, student.getId());
            System.out.println("Veritabanından okunan: " + readStudent);

            // 3. Güncelleme işlemi
            readStudent.setName("Derin");
            readStudent.setSurname("Aydın");
            session.update(readStudent);

            // 4. Silme işlemi
            session.delete(readStudent);
            System.out.println("Öğrenci silindi: " + readStudent);

            // 5. Commit
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback(); // Hata varsa geri al
            }
            e.printStackTrace();
        } finally {
            session.close(); // Oturumu her durumda kapat
        }
    }
}