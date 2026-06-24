package com.localgov.eligibilitychecker.dto;

import com.localgov.eligibilitychecker.model.Scheme;
import java.util.List;

public class EligibilityResponse {
    private boolean eligible;
    private List<Scheme> eligibleSchemes;
    private String message;

    public EligibilityResponse(boolean eligible, List<Scheme> eligibleSchemes, String message) {
        this.eligible = eligible;
        this.eligibleSchemes = eligibleSchemes;
        this.message = message;
    }

    // Getters and Setters
    public boolean isEligible() { return eligible; }
    public void setEligible(boolean eligible) { this.eligible = eligible; }
    public List<Scheme> getEligibleSchemes() { return eligibleSchemes; }
    public void setEligibleSchemes(List<Scheme> eligibleSchemes) { this.eligibleSchemes = eligibleSchemes; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
