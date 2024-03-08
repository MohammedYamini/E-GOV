package com.egov.egov.dao;

import com.egov.egov.entity.Reclamation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamationDao extends CrudRepository<Reclamation, Integer> {

}
