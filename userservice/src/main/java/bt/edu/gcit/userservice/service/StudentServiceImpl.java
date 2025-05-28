package bt.edu.gcit.userservice.service;

import bt.edu.gcit.userservice.dao.StudentDAO;
import bt.edu.gcit.userservice.entity.Student;
import bt.edu.gcit.userservice.entity.AuthenticationType;
import bt.edu.gcit.userservice.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO, PasswordEncoder passwordEncoder) {
        this.studentDAO = studentDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public Student findByEmail(String email) {
        return studentDAO.findByEmail(email);
    }

    @Override
    @Transactional
    public void enable(Long id) {
        studentDAO.enable(id);
    }

    @Override
    @Transactional
    public Student registerStudent(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentDAO.registerStudent(student);
    }

    @Override
    @Transactional
    public boolean isEmailUnique(String email) {
        return studentDAO.findByEmail(email) == null;
    }


    @Override
    @Transactional
    public boolean isTokenUnique(Long token) {
        return studentDAO.findByToken(token) == null;
    }

    @Override
    @Transactional
    public Student getStudentById(Long id) {
        return studentDAO.getStudentById(id);
    }

    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    @Transactional
    public Student updateToken(Long id, Long token) {
        Student existing = studentDAO.getStudentById(id);
        if (existing == null) {
            throw new UserNotFoundException("Student not found with id " + id);
        }
        existing.setToken(token);
        return studentDAO.registerStudent(existing);
    }

    @Override
    @Transactional
    public Student disableAccount(Long id) {
        Student existing = studentDAO.getStudentById(id);
        if (existing == null) {
            throw new UserNotFoundException("Student not found with id " + id);
        }
        existing.setEnabled(false);
        return studentDAO.registerStudent(existing);
    }

    @Override
    @Transactional
    public Student enableAccount(Long id) {
        Student existing = studentDAO.getStudentById(id);
        if (existing == null) {
            throw new UserNotFoundException("Student not found with id " + id);
        }
        existing.setEnabled(true);
        return studentDAO.registerStudent(existing);
    }

    @Override
    @Transactional
    public Student setActive(Long id) {
        Student existing = studentDAO.getStudentById(id);
        if (existing == null) {
            throw new UserNotFoundException("Student not found with id " + id);
        }
        existing.setActive(true);
        return studentDAO.registerStudent(existing);
    }

    @Override
    @Transactional
    public Student setInactive(Long id) {
        Student existing = studentDAO.getStudentById(id);
        if (existing == null) {
            throw new UserNotFoundException("Student not found with id " + id);
        }
        existing.setActive(false);
        return studentDAO.registerStudent(existing);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        studentDAO.deleteStudent(id);
    }

    @Override
    @Transactional
    public void updateAuthenticationType(Long studentId, AuthenticationType type) {
        studentDAO.updateAuthenticationType(studentId, type);
    }

    @Override
    @Transactional
    public void addNewStudentUponOAuthLogin(String name, String email, AuthenticationType authenticationType) {
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setEnabled(true);
        student.setActive(true);
        student.setCreatedTime(new Date());
        student.setAuthenticationType(authenticationType);
        student.setPassword(""); // Or generate a default secure password
        System.out.println("Student: " + student);
        studentDAO.registerStudent(student);
    }
}
