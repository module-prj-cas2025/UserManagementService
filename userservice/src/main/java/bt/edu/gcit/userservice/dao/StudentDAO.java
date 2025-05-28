package bt.edu.gcit.userservice.dao;

import bt.edu.gcit.userservice.entity.Student;
import bt.edu.gcit.userservice.entity.AuthenticationType;
import java.util.List;

public interface StudentDAO {
    Student findByEmail(String email);
    Student findByNumber(Long number);
    void enable(long id);
    Student findByToken(Long token);
    Student registerStudent(Student student);
    boolean isEmailUnique(String email);
    Student getStudentById(long id);
    List<Student> getAllStudents();
    Student updateStudent(int id, Student student);
    void deleteStudent(long id);
    void updateAuthenticationType(Long studentId, AuthenticationType type);
}
