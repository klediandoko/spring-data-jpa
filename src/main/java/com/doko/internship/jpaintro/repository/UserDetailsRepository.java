package com.doko.internship.jpaintro.repository;

import com.doko.internship.jpaintro.model.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
}
