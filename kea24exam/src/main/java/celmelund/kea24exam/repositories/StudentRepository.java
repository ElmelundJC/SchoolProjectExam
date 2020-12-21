package celmelund.kea24exam.repositories;

import celmelund.kea24exam.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Long> {
}
