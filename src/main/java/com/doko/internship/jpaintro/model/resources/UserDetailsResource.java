package com.doko.internship.jpaintro.model.resources;

import com.doko.internship.jpaintro.model.entity.UserDetails;

public class UserDetailsResource {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public UserDetailsResource() {
    }

    public UserDetailsResource(UserDetails userDetails) {
        this.firstName = userDetails.getFirstName();
        this.lastName = userDetails.getLastName();
        this.email = userDetails.getEmail();
        this.phoneNumber = userDetails.getPhoneNumber();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
