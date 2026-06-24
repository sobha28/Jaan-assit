package com.localgov.eligibilitychecker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "schemes")
public class Scheme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "scheme_name", nullable = false)
    private String schemeName;

    @Column(nullable = false)
    private String category;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String eligibility;

    @Column(name = "official_website_url")
    private String officialWebsiteUrl;

    // Default Constructor
    public Scheme() {}

    // Convenience Constructor
    public Scheme(String schemeName, String category, String description, String eligibility, String officialWebsiteUrl) {
        this.schemeName = schemeName;
        this.category = category;
        this.description = description;
        this.eligibility = eligibility;
        this.officialWebsiteUrl = officialWebsiteUrl;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSchemeName() { return schemeName; }
    public void setSchemeName(String schemeName) { this.schemeName = schemeName; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getEligibility() { return eligibility; }
    public void setEligibility(String eligibility) { this.eligibility = eligibility; }
    public String getOfficialWebsiteUrl() { return officialWebsiteUrl; }
    public void setOfficialWebsiteUrl(String officialWebsiteUrl) { this.officialWebsiteUrl = officialWebsiteUrl; }
}
