package com.doko.internship.jpaintro.service;

import com.doko.internship.jpaintro.mapper.UserMapper;
import com.doko.internship.jpaintro.model.entity.Flight;
import com.doko.internship.jpaintro.model.entity.User;
import com.doko.internship.jpaintro.model.resources.FlightResource;
import com.doko.internship.jpaintro.model.resources.UserResource;
import com.doko.internship.jpaintro.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserResource> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toResource)
                .toList();
    }

    public Optional<UserResource> getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toResource);
    }

    @Transactional
    public void save(final Long userId, final UserResource userResource) {
        User userToUpdate = userRepository.findById(userId).orElseGet(User::new);
        userMapper.updateUser(userToUpdate, userResource);

        userRepository.save(userToUpdate);

    }

    public List<UserResource> getAllUsersByFlight(Long flightId){

        return userRepository.findAllUsersByFlightId(flightId).stream()
                .map(userMapper::toResource).toList();
    }

    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
