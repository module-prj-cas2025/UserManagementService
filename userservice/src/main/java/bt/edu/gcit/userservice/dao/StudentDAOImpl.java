package bt.edu.gcit.userservice.dao;

import bt.edu.gcit.userservice.entity.Student;
import bt.edu.gcit.userservice.entity.AuthenticationType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Student findByEmail(String email) {
        TypedQuery<Student> query = entityManager.createQuery(
            "SELECT s FROM Student s WHERE s.email = :email", Student.class);
        query.setParameter("email", email);
        List<Student> students = query.getResultList();
        return students.isEmpty() ? null : students.get(0);
    }

    @Override
    public Student findByNumber(Long number) {
        TypedQuery<Student> query = entityManager.createQuery(
            "SELECT s FROM Student s WHERE s.phoneNumber = :number", Student.class);
        query.setParameter("number", number);
        List<Student> students = query.getResultList();
        return students.isEmpty() ? null : students.get(0);
    }

    @Override
    public Student findByToken(Long token) {
        TypedQuery<Student> query = entityManager.createQuery(
            "SELECT s FROM Student s WHERE s.token = :token", Student.class);
        query.setParameter("token", token);
        List<Student> students = query.getResultList();
        return students.isEmpty() ? null : students.get(0);
    }

    @Override
    public void enable(long id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            student.setEnabled(true);
            entityManager.merge(student);
        }
    }

    @Override
    public Student registerStudent(Student student) {
        student.setAuthenticationType(AuthenticationType.DATABASE);
        entityManager.persist(student);
        return student;
    }

    
    @Override
    public boolean isEmailUnique(String email) {
        TypedQuery<Student> query = entityManager.createQuery(
            "SELECT s FROM Student s WHERE s.email = :email", Student.class);
        query.setParameter("email", email);
        List<Student> students = query.getResultList();
        return students.isEmpty();
    }

    @Override
    public Student getStudentById(long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> getAllStudents() {
        TypedQuery<Student> query = entityManager.createQuery(
            "SELECT s FROM Student s", Student.class);
        return query.getResultList();
    }

    @Override
    public Student updateStudent(int id, Student student) {
        Student existingStudent = entityManager.find(Student.class, (long) id);
        if (existingStudent != null) {
            student.setId(existingStudent.getId());
            return entityManager.merge(student);
        }
        return null;
    }

    @Override
    public void deleteStudent(long id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
        }
    }

    @Override
    public void updateAuthenticationType(Long studentId, AuthenticationType type) {
        Student student = entityManager.find(Student.class, studentId);
        if (student != null) {
            student.setAuthenticationType(type);
            entityManager.merge(student);
        }
    }
}
