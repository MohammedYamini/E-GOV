package com.egov.egov.controller;

import com.egov.egov.Trait.CustomListResponse;
import com.egov.egov.Trait.CustomResponse;
import com.egov.egov.entity.Reclamation;
import com.egov.egov.service.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
public class ReclamationController {

    @Autowired
    ReclamationService reclamationService;

    @PostMapping("/store/reclamation")
    public ResponseEntity<Object> storeReclamation(@RequestBody Reclamation reclamation) {
        Reclamation saved_reclamation = reclamationService.StoreReclamation(reclamation);
        String success_message = "Reclamation saved successfully.";

        CustomResponse response = new CustomResponse(success_message, saved_reclamation);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all/reclamations")
    public ResponseEntity<Object> IndexReclamation() {
        List<Reclamation> reclamations = reclamationService.IndexRecReclamation();

        if (reclamations.isEmpty()) {
            String success_message = "No reclamations found.";
            return new ResponseEntity<>(success_message, HttpStatus.NOT_FOUND);
        } else {
            String success_message = "All reclamations retrieved successfully.";
            CustomListResponse response = new CustomListResponse(success_message, reclamations);
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/reclamation/{id}")
    public ResponseEntity<Object> GetReclamationById(@PathVariable Integer id) {
        Reclamation reclamation = reclamationService.GetReclamationById(id);

        if (reclamation != null) {
            String success_message = "Reclamation retrieved successfully.";
            CustomResponse response = new CustomResponse(success_message, reclamation);
            return ResponseEntity.ok(response);
        } else {
            String error_message = "Reclamation with ID " + id + " not found.";
            return new ResponseEntity<>(error_message, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/reclamation/{id}")
    public ResponseEntity<Object> DeleteReclamation(@PathVariable Integer id) {
        reclamationService.DeleteReclamation(id);
        String success_message = "Reclamation with ID " + id + " deleted successfully.";
        return ResponseEntity.ok(success_message);
    }

    @PutMapping("/update/reclamation/{id}")
    public ResponseEntity<Object> updateReclamation(@PathVariable Integer id, @RequestBody Reclamation reclamation) {
        Reclamation check_reclamation = reclamationService.GetReclamationById(id);

        if (check_reclamation != null) {
            if (reclamation.getMatriculation_interior() != null &&
                    reclamation.getMatriculation_number() != null &&
                    reclamation.getAddress() != null &&
                    reclamation.getEnd_of_validity() != null &&
                    reclamation.getFirst_time_in_circulation() != null &&
                    reclamation.getMutation() != null &&
                    reclamation.getFirst_use_in_morocco() != null &&
                    reclamation.getOwner() != null &&
                    reclamation.getType_of_usage() != null &&
                    reclamation.getParticular_vehicle() != null) {

                check_reclamation.setMatriculation_interior(reclamation.getMatriculation_interior());
                check_reclamation.setMatriculation_number(reclamation.getMatriculation_number());
                check_reclamation.setAddress(reclamation.getAddress());
                check_reclamation.setEnd_of_validity(reclamation.getEnd_of_validity());
                check_reclamation.setFirst_time_in_circulation(reclamation.getFirst_time_in_circulation());
                check_reclamation.setMutation(reclamation.getMutation());
                check_reclamation.setFirst_use_in_morocco(reclamation.getFirst_use_in_morocco());
                check_reclamation.setOwner(reclamation.getOwner());
                check_reclamation.setType_of_usage(reclamation.getType_of_usage());
                check_reclamation.setParticular_vehicle(reclamation.getParticular_vehicle());
            }

            Reclamation updated_reclamation = reclamationService.UpdateReclamation(check_reclamation);
            String success_message = "Reclamation updated successfully.";
            CustomResponse response = new CustomResponse(success_message, updated_reclamation);
            return ResponseEntity.ok(response);
        } else {
            String success_message = "Reclamation with ID " + id + " not found.";
            return new ResponseEntity<>(success_message, HttpStatus.NOT_FOUND);
        }
    }
}
