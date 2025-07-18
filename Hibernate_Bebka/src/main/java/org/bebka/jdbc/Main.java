//package org.bebka.jdbc;
//
//import org.bebka.jdbc.model.Student;
//import org.bebka.jdbc.util.HibernateUtil;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//
//public class Main {
//    public static void main(String[] args) {
//        SessionFactory factory = HibernateUtil.getSessionFactory();
//        Session session = factory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//
//            // 1. Öğrenci oluştur ve kaydet
//            Student student = new Student("Zeynep", "Kaya");
//            session.save(student);
//
//            // 2. Öğrenciyi veritabanından al
//            Student readStudent = session.get(Student.class, student.getId());
//            System.out.println("Veritabanından okunan: " + readStudent);
//
//            // 3. Güncelleme işlemi
//            readStudent.setName("Zeynep Güncel");
//            session.update(readStudent);
//
//            // 4. Silme işlemi
//            //session.delete(readStudent);
//            //System.out.println("Öğrenci silindi: " + readStudent);
//
//            // 5. Commit
//            tx.commit();
//            System.out.println("İşlem başarıyla tamamlandı");
//
//        } catch (Exception e) {
//            if (tx != null) {
//                tx.rollback(); // Hata varsa geri al
//            }
//            e.printStackTrace();
//        } finally {
//            session.close(); // Oturumu her durumda kapat
//        }
//    }
//}
//package org.bebka.jdbc;
//
//import org.bebka.jdbc.service.StudentService;
//
//public class Main {
//    public static void main(String[] args) {
//        StudentService service = new StudentService();
//        service.performStudentOperations();
//    }
//}
package org.bebka.jdbc;

import org.bebka.jdbc.dao.StudentDAO;
import org.bebka.jdbc.model.Student;
import org.bebka.jdbc.service.StudentService;
import org.bebka.jdbc.util.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        // DAO ve Service katmanlarını oluştur
        StudentDAO studentDAO = new StudentDAO();
        StudentService studentService = new StudentService(studentDAO);

        // Yeni öğrenci oluştur
        Student student = new Student("Ali", "Yılmaz");

        // Create (Ekle)
        studentService.createUser(session, student);

        // Read (ID ile çek)
        Student found = studentService.getUserById(session, (long)student.getId());
        System.out.println("Bulunan öğrenci: " + found.getName() + " " + found.getSurname());

        // Update (Güncelle)
        found.setSurname("Güncellenmiş Soyad");
        studentService.updateUser(session, found);

        // Delete (Sil)
        studentService.deleteUser(session, found);

    }
}