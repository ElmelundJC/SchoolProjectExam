package celmelund.kea24exam.controllers;

import celmelund.kea24exam.models.Student;
import celmelund.kea24exam.service.StudentService;
import celmelund.kea24exam.service.SupervisorService;
import celmelund.kea24exam.service.springDataJPA.StudentJPA;
import celmelund.kea24exam.service.springDataJPA.SupervisorJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudentController {


    private StudentJPA studentJPA;
    private SupervisorJPA supervisorJPA;


    public StudentController(StudentJPA studentJPA, SupervisorJPA supervisorJPA) {
        this.studentJPA = studentJPA;
        this.supervisorJPA = supervisorJPA;
    }

    @PostMapping("api/studentservice")
    public ResponseEntity<StudentService> getSearchResults(){
        studentJPA.studentList = studentJPA.findAll();
        System.out.println("api/studentservice kaldt med: ");
        return ResponseEntity.ok(studentJPA);
    }

    @PostMapping("/api/createstudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println("api/createstudent kaldt med ");
        return ResponseEntity.ok(studentJPA.save(student));
    }

    /*
    @PostMapping("/api/updatestudent")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        studentJPA.findById(studen;);
    }
     */


    @PostMapping("/api/deleteStudent")
    public void deleteStudentById(@RequestBody Student student){
        studentJPA.deleteById(student.getId());
    }

}
