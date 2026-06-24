package com.localgov.eligibilitychecker.controller;

import com.localgov.eligibilitychecker.model.Scheme;
import com.localgov.eligibilitychecker.repository.SchemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schemes")
@CrossOrigin(origins = "*")
public class SchemeController {

    @Autowired
    private SchemeRepository repo;

    // ✅ CREATE
    @PostMapping
    public Scheme addScheme(@RequestBody Scheme scheme) {
        return repo.save(scheme);
    }

    // ✅ READ ALL
    @GetMapping
    public List<Scheme> getAllSchemes() {
        return repo.findAll();
    }

    // ✅ READ BY ID
    @GetMapping("/{id}")
    public Scheme getSchemeById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public Scheme updateScheme(@PathVariable Long id, @RequestBody Scheme newScheme) {
        Scheme existing = repo.findById(id).orElse(null);

        if (existing != null) {
            existing.setSchemeName(newScheme.getSchemeName());
            existing.setCategory(newScheme.getCategory());
            existing.setDescription(newScheme.getDescription());
            existing.setEligibility(newScheme.getEligibility());
            existing.setOfficialWebsiteUrl(newScheme.getOfficialWebsiteUrl());
            return repo.save(existing);
        } else {
            return null;
        }
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public String deleteScheme(@PathVariable Long id) {
        repo.deleteById(id);
        return "Scheme deleted successfully!";
    }
}