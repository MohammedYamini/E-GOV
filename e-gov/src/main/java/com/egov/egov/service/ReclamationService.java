package com.egov.egov.service;

import com.egov.egov.dao.ReclamationDao;
import com.egov.egov.entity.Reclamation;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReclamationService {

    @Autowired
    private ReclamationDao reclamationDao;

    public Reclamation StoreReclamation(Reclamation reclamation) {
        return reclamationDao.save(reclamation);
    }

    public List<Reclamation> IndexRecReclamation() {
        List<Reclamation> reclamations = new ArrayList<>();
        reclamationDao.findAll().forEach(reclamations::add);
        return reclamations;
    }

    public Reclamation GetReclamationById(Integer id) {
        return reclamationDao.findById(id).orElseThrow();
    }

    public void DeleteReclamation(Integer id) {
        reclamationDao.deleteById(id);
    }

    public Reclamation UpdateReclamation(Reclamation reclamation) {
        Optional<Reclamation> check_reclamation = reclamationDao.findById(reclamation.getId());

        if (check_reclamation.isPresent()) {
            Reclamation exist_reclamation = check_reclamation.get();

            if (reclamation.getMatriculation_interior() != null &&
                    reclamation.getMatriculation_number() != null &&
                    reclamation.getAddress() != null &&
                    reclamation.getParticular_vehicle() != null &&
                    reclamation.getFirst_time_in_circulation() != null &&
                    reclamation.getMutation() != null &&
                    reclamation.getFirst_use_in_morocco() != null &&
                    reclamation.getOwner() != null &&
                    reclamation.getType_of_usage() != null &&
                    reclamation.getParticular_vehicle() != null) {

                exist_reclamation.setAddress(reclamation.getAddress());
                exist_reclamation.setMatriculation_number(reclamation.getMatriculation_number());
                exist_reclamation.setParticular_vehicle(reclamation.getParticular_vehicle());
                exist_reclamation.setFirst_time_in_circulation(reclamation.getFirst_time_in_circulation());
                exist_reclamation.setMutation(reclamation.getMutation());
                exist_reclamation.setMatriculation_interior(reclamation.getMatriculation_interior());
                exist_reclamation.setFirst_use_in_morocco(reclamation.getFirst_use_in_morocco());
                exist_reclamation.setOwner(reclamation.getOwner());
                exist_reclamation.setType_of_usage(reclamation.getType_of_usage());
                exist_reclamation.setParticular_vehicle(reclamation.getParticular_vehicle());
            }

            return reclamationDao.save(exist_reclamation);
        } else {
            throw new EntityNotFoundException("Reclamation with ID " + reclamation.getId() + " not found.");
        }
    }
}
