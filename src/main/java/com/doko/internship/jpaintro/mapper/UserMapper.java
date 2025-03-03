package com.doko.internship.jpaintro.mapper;

import com.doko.internship.jpaintro.model.entity.User;
import com.doko.internship.jpaintro.model.entity.UserDetails;
import com.doko.internship.jpaintro.model.resources.UserDetailsResource;
import com.doko.internship.jpaintro.model.resources.UserResource;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final UserDetailsMapper userDetailsMapper;

    public UserMapper(UserDetailsMapper userDetailsMapper) {
        this.userDetailsMapper = userDetailsMapper;
    }

    public UserResource toResource(final User user) {
        UserResource userResource = new UserResource(user);

        if (user.getUserDetails() != null) {
            userResource.setUserDetailsResource(userDetailsMapper.toResource(user.getUserDetails()));
        } else {
            userResource.setUserDetailsResource(null);
        }
        return userResource;
    }

    public void updateUser(final User userToUpdate, final UserResource user) {
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setRole(user.getRole());
        userToUpdate.setPassword(user.getPassword());

        UserDetailsResource detailsResource = user.getUserDetailsResource();
        if (detailsResource != null) {
            UserDetails details = userDetailsMapper.ensureUserDetails(userToUpdate);
            details.setUser(userToUpdate);
            userDetailsMapper.updateUserDetails(details, detailsResource);
        }
    }
}
