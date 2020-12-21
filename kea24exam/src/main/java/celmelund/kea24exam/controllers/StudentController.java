package celmelund.kea24exam.controllers;

import celmelund.kea24exam.models.Student;
import celmelund.kea24exam.service.StudentService;
import celmelund.kea24exam.service.SupervisorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudentController {

    private final StudentService studentService;
    private SupervisorService supervisorService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("api/studentservice")
    public ResponseEntity<StudentService> getSearchResults(){
        System.out.println("api/studentservice kaldt med: ");
        return ResponseEntity.ok(studentService);
    }

    @PostMapping("api/createstudent")
    public ResponseEntity<StudentService> createStudent(@RequestBody Student student){
        System.out.println("api/createstudent kaldt med ");
        studentService.save(student);
        return ResponseEntity.ok(studentService);
    }
}
