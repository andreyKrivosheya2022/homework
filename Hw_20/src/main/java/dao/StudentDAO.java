package dao;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSession;

import java.util.List;

public class StudentDAO {

    public void addStudent(Student student) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }

    public void updateStudent(Student student) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
        session.close();
    }

    public void deleteStudent(Student student) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(student);
        transaction.commit();
        session.close();
    }

    public List<Student> getAllStudents() {
        Session session = HibernateSession.getSessionFactory().openSession();
        List<Student> students = session.createQuery("from Student", Student.class).list();
        session.close();
        return students;
    }

    public Student getStudentById(int id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }
}
