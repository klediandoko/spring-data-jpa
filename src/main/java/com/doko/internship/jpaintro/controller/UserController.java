package com.doko.internship.jpaintro.controller;

import com.doko.internship.jpaintro.model.resources.UserResource;
import com.doko.internship.jpaintro.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<UserResource>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResource> getUserById(@PathVariable Long id) {
        Optional<UserResource> userResource = userService.getUserById(id);
        return userResource.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(path = "{userId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> updateUser(@PathVariable("userId") final Long userId,
                                           @RequestBody final UserResource user) {
        userService.save(userId, user);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/flight/{flightId}")
    public ResponseEntity<List<UserResource>> getAllUsersByFlight(@PathVariable Long flightId){
        return ResponseEntity.ok(userService.getAllUsersByFlight(flightId));
    }

    @DeleteMapping(path = "/{userId}", produces = "application/json")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") final Long userId) {
        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }


}
