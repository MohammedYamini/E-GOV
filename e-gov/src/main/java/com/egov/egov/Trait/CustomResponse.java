package com.egov.egov.Trait;

import com.egov.egov.entity.Reclamation;

public class CustomResponse {
    private final String message;
    private final Reclamation reclamation;

    public CustomResponse(String message, Reclamation reclamation) {
        this.message = message;
        this.reclamation = reclamation;
    }

    public String getMessage() {
        return message;
    }

    public Reclamation getReclamation() {
        return reclamation;
    }
}
