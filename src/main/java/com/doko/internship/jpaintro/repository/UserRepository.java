package com.doko.internship.jpaintro.repository;

import com.doko.internship.jpaintro.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
