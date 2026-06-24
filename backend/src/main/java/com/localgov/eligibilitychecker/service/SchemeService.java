package com.localgov.eligibilitychecker.service;

import com.localgov.eligibilitychecker.model.Scheme;
import com.localgov.eligibilitychecker.repository.SchemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchemeService {

    @Autowired
    private SchemeRepository schemeRepository;

    public List<Scheme> getAllSchemes() {
        return schemeRepository.findAll();
    }
}
