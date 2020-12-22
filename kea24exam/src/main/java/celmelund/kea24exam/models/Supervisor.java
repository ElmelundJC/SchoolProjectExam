package celmelund.kea24exam.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "supervisors")
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supervisor_id;

    @Column
    private String supervisorName;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supervisor")
    private Set<Student> students;

    public Long getSupervisor_id() {
        return supervisor_id;
    }

    public void setSupervisor_id(Long id) {
        this.supervisor_id = id;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisor) {
        this.supervisorName = supervisor;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public String toString(){
        return supervisorName;
    }
}
