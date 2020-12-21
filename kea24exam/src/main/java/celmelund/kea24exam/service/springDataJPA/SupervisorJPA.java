package celmelund.kea24exam.service.springDataJPA;

import celmelund.kea24exam.models.Supervisor;
import celmelund.kea24exam.repositories.SupervisorRepository;
import celmelund.kea24exam.service.SupervisorService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class SupervisorJPA implements SupervisorService {

    private final SupervisorRepository supervisorRepository;

    public SupervisorJPA(SupervisorRepository supervisorRepository) {
        this.supervisorRepository = supervisorRepository;
    }

    @Override
    public Set<Supervisor> findAll() {
        Set<Supervisor> set = new HashSet<>();
        supervisorRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Supervisor save(Supervisor object) {
        return supervisorRepository.save(object);
    }

    @Override
    public void delete(Supervisor object) {
        supervisorRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        supervisorRepository.deleteById(aLong);
    }

    @Override
    public Optional<Supervisor> findById(Long aLong) {
        return supervisorRepository.findById(aLong);
    }
}
