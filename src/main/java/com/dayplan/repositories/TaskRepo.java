package com.dayplan.repositories;

import com.dayplan.domains.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends CrudRepository<Task, Integer> {

}
