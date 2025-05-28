package bt.edu.gcit.userservice.rest;

import bt.edu.gcit.userservice.entity.Student;
import bt.edu.gcit.userservice.entity.AuthenticationType;
import bt.edu.gcit.userservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {

    private final StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/register")
    public Student createStudent(@RequestBody Student student) {
        return studentService.registerStudent(student);
    }

    @PostMapping("/sendVerificationEmail")
    public void sendVerificationEmail(@RequestBody String email) {
        // implementation depends on your email service
    }

    @PostMapping("/isEmailUnique")
    public ResponseEntity<Boolean> isEmailUnique(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        boolean isUnique = studentService.isEmailUnique(email);
        return ResponseEntity.ok(isUnique);
    }

    @PostMapping("/isTokenUnique")
    public ResponseEntity<Boolean> isTokenUnique(@RequestBody Map<String, Long> requestBody) {
        Long token = requestBody.get("token");
        boolean isUnique = studentService.isTokenUnique(token);
        return ResponseEntity.ok(isUnique);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/byEmail/{email}")
    public Student getStudentByEmail(@PathVariable String email) {
        return studentService.findByEmail(email);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Map<String, Long> body) {
        Long token = body.get("token");
        return studentService.updateToken(id, token);
    }

    @PutMapping("/disable/{id}")
    public Student accountDisable(@PathVariable Long id) {
        return studentService.disableAccount(id);
    }

    @PutMapping("/enable/{id}")
    public Student accountEnable(@PathVariable Long id) {
        return studentService.enableAccount(id);
    }

    @PutMapping("/active/{id}")
    public Student setActive(@PathVariable Long id) {
        return studentService.setActive(id);
    }

    @PutMapping("/inactive/{id}")
    public Student setInactive(@PathVariable Long id) {
        return studentService.setInactive(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/updateAuthenticationType/{studentId}")
    public void updateAuthenticationType(@PathVariable Long studentId, @RequestBody String type) {
        AuthenticationType authenticationType;
        try {
            authenticationType = AuthenticationType.valueOf(type);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid authentication type");
        }
        studentService.updateAuthenticationType(studentId, authenticationType);
    }
}
