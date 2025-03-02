package com.doko.internship.jpaintro.mapper;

import com.doko.internship.jpaintro.model.entity.User;
import com.doko.internship.jpaintro.model.entity.UserDetails;
import com.doko.internship.jpaintro.model.resources.UserDetailsResource;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsMapper {

    public UserDetailsResource toResource(final UserDetails userDetails) {
        return new UserDetailsResource(userDetails);
    }

    public void updateUserDetails(UserDetails userDetailsToUpdate, UserDetailsResource userDetailsResource) {

        if (userDetailsResource == null){
            return;
        }
        userDetailsToUpdate.setFirstName(userDetailsResource.getFirstName());
        userDetailsToUpdate.setLastName(userDetailsResource.getLastName());
        userDetailsToUpdate.setEmail(userDetailsResource.getEmail());
        userDetailsToUpdate.setPhoneNumber(userDetailsResource.getPhoneNumber());
    }

    public UserDetails ensureUserDetails(User user) {
        if (user.getUserDetails() == null) {
            user.setUserDetails(new UserDetails());
        }
        return user.getUserDetails();
    }
}