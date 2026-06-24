package com.localgov.eligibilitychecker.dto;

public class EligibilityRequest {
    private String name;
    private Integer age;
    private String gender;
    private String occupation;
    private Double income;
    private String category;
    private String state;
    private String contactNumber;

    // Getters and Setters
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
}
