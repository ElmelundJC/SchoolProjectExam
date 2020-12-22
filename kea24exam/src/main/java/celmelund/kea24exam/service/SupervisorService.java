package celmelund.kea24exam.service;

import celmelund.kea24exam.models.Supervisor;

import java.util.List;

public interface SupervisorService extends CrudService<Supervisor,Long>{
    public List<Supervisor> getSupervisors();
}
