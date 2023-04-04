import entity.Student;
import dao.StudentDAO;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        System.out.println("Введите к-ство студентов: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // добавляем студентов
        for (int i = 1; i <= n; i++) {
            Student student = new Student("Student " + i, "email" + i + "@example.com");
            studentDAO.addStudent(student);
        }

        // получаем всех студентов и выводим их на экран
        List<Student> students = studentDAO.getAllStudents();
        for (Student student : students) {
            System.out.println(student.toString());
        }

        // изменяем данные студента с ID=1
        Student student1 = studentDAO.getStudentById(students.get(0).getId());
        student1.setEmail("newemail@example.com");
        studentDAO.updateStudent(student1);

        // удаляем студента с ID=1
        Student student2 = studentDAO.getStudentById(students.get(0).getId());
        studentDAO.deleteStudent(student2);
    }
}
