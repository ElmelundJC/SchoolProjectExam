package celmelund.kea24exam.service.springDataJPA;

import celmelund.kea24exam.models.Student;
import celmelund.kea24exam.repositories.StudentRepository;
import celmelund.kea24exam.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentJPA implements StudentService {

    public Set<Student> studentList;
    private final StudentRepository studentRepository;

    public StudentJPA(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Set<Student> findAll() {
        Set<Student> students =new HashSet<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    @Override
    public Student save(Student object) {
        return studentRepository.save(object);
    }

    @Override
    public void delete(Student object) {
        studentRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        studentRepository.deleteById(aLong);
    }

    @Override
    public Optional<Student> findById(Long aLong) {
        return studentRepository.findById(aLong);
    }

    /*
    @Override
    public List<Student> studentsWithNoTeacher() {
        List<Student> list = new ArrayList<>();
        studentRepository.findAll().forEach(student ->{
            if(student.getSupervisor() == null) {
                list.add(student);
            }
        });
        return list;
    }
    */

}
