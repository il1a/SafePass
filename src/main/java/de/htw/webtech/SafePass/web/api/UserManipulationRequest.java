package de.htw.webtech.SafePass.web.api;

public class UserManipulationRequest {

    private String firstName;
    private String lastName;
    private String country;
    private String zipCode;

    public UserManipulationRequest(String firstName, String lastName, String country, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.zipCode = zipCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}