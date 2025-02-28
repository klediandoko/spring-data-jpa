package com.doko.internship.jpaintro.mapper;

import com.doko.internship.jpaintro.model.entity.User;
import com.doko.internship.jpaintro.model.resources.UserDetailsResource;
import com.doko.internship.jpaintro.model.resources.UserResource;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResource toResource(final User user) {
        UserResource userResource = new UserResource(user);

        if (user.getUserDetails() != null) {
            userResource.setUserDetailsResource(new UserDetailsResource(user.getUserDetails()));
        }

        return userResource;
    }

    public void updateUser(final User userToUpdate, final UserResource user) {
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setRole(user.getRole());
       // userToUpdate.setUserDetails(user.getUserDetailsResource());
    }
}
