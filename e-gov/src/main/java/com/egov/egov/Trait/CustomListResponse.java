package com.egov.egov.Trait;

import com.egov.egov.entity.Reclamation;

import java.util.List;

public class CustomListResponse {
    private final String message;
    private final List<Reclamation> reclamations;

    public CustomListResponse(String message, List<Reclamation> reclamations) {
        this.message = message;
        this.reclamations = reclamations;
    }

    public String getMessage() {
        return message;
    }

    public List<Reclamation> getReclamations() {
        return reclamations;
    }
}
