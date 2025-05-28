package bt.edu.gcit.userservice.service;

import bt.edu.gcit.userservice.entity.Student;
import bt.edu.gcit.userservice.entity.AuthenticationType;

import java.util.List;

public interface StudentService {

    Student findByEmail(String email);

    void enable(Long id);

    Student registerStudent(Student student);

    boolean isEmailUnique(String email);
 
    boolean isTokenUnique(Long token);

    Student getStudentById(Long id);

    List<Student> getAllStudents();

    Student updateToken(Long id, Long token);

    Student disableAccount(Long id);

    Student enableAccount(Long id);

    void deleteStudent(Long id);

    Student setActive(Long id);

    Student setInactive(Long id);

    void updateAuthenticationType(Long studentId, AuthenticationType type);

    void addNewStudentUponOAuthLogin(String name, String email, AuthenticationType authenticationType);
}
