package com.localgov.eligibilitychecker.controller;

import com.localgov.eligibilitychecker.dto.EligibilityRequest;
import com.localgov.eligibilitychecker.dto.EligibilityResponse;
import com.localgov.eligibilitychecker.service.EligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EligibilityController {

    @Autowired
    private EligibilityService eligibilityService;

    @PostMapping("/check-eligibility")
    public EligibilityResponse checkEligibility(@RequestBody EligibilityRequest request) {
        System.out.println("REQUEST RECEIVED : " + request.getName());

        return eligibilityService.checkEligibility(request);
    }
}
