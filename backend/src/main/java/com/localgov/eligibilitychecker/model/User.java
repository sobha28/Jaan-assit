package com.localgov.eligibilitychecker.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer age;
    private String gender;
    private String occupation;
    private Double income;
    private String category;
    private String state;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "submission_date")
    private LocalDateTime submissionDate;

    @PrePersist
    protected void onCreate() {
        this.submissionDate = LocalDateTime.now();
    }

    // Default Constructor
    public User() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getOccupation() { return occupation; }
    public void setOccupation(String occupation) { this.occupation = occupation; }
    public Double getIncome() { return income; }
    public void setIncome(Double income) { this.income = income; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public LocalDateTime getSubmissionDate() { return submissionDate; }
    public void setSubmissionDate(LocalDateTime submissionDate) { this.submissionDate = submissionDate; }
}
