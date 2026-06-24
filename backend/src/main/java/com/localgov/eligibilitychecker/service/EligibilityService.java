package com.localgov.eligibilitychecker.service;

import com.localgov.eligibilitychecker.dto.EligibilityRequest;
import com.localgov.eligibilitychecker.dto.EligibilityResponse;
import com.localgov.eligibilitychecker.model.Scheme;
import com.localgov.eligibilitychecker.model.User;
import com.localgov.eligibilitychecker.repository.SchemeRepository;
import com.localgov.eligibilitychecker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EligibilityService {

    @Autowired
    private SchemeRepository schemeRepository;

    @Autowired
    private UserRepository userRepository;

    public EligibilityResponse checkEligibility(EligibilityRequest request) {
        // Create and populate the User entity with all requested details
        User user = new User();
        user.setName(request.getName());
        user.setAge(request.getAge());
        user.setGender(request.getGender());
        user.setOccupation(request.getOccupation());
        user.setIncome(request.getIncome());
        user.setCategory(request.getCategory());
        user.setState(request.getState());
        user.setContactNumber(request.getContactNumber());
        
        // Save user record to the database
        userRepository.save(user);

        // Fetch matching schemes automatically based on the selected category
        List<Scheme> eligibleSchemes = schemeRepository.findByCategoryIgnoreCase(request.getCategory());

        if (eligibleSchemes.isEmpty()) {
            return new EligibilityResponse(
                false, 
                eligibleSchemes, 
                "No specific government schemes found for the category: " + request.getCategory()
            );
        } else {
            return new EligibilityResponse(
                true, 
                eligibleSchemes, 
                "We found matching government schemes based on your profile!"
            );
        }
    }
}
