package com.doko.internship.jpaintro.model.resources;

import com.doko.internship.jpaintro.model.entity.User;

public class UserResource {

    private String username;
    private String role;
    private UserDetailsResource userDetailsResource;

    public UserResource() {
    }

    public UserResource(User user){
        this.username = user.getUsername();
        this.role = user.getRole();
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserDetailsResource getUserDetailsResource() {
        return userDetailsResource;
    }

    public void setUserDetailsResource(UserDetailsResource userDetailsResource) {
        this.userDetailsResource = userDetailsResource;
    }
}
