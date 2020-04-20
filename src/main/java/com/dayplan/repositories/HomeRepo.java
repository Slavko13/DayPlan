package com.dayplan.repositories;

import com.dayplan.domains.Home;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepo extends CrudRepository<Home, Integer> {

}
