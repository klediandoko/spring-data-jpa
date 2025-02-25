package com.doko.internship.jpaintro.main;


import com.doko.internship.jpaintro.model.entity.User;
import com.doko.internship.jpaintro.repository.BookingFlightRepository;
import com.doko.internship.jpaintro.repository.BookingRepository;
import com.doko.internship.jpaintro.repository.FlightRepository;
import com.doko.internship.jpaintro.repository.UserDetailsRepository;
import com.doko.internship.jpaintro.repository.UserRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ApplicationRunner implements InitializingBean {

    private final UserRepository userRepository;
   /* private final UserDetailsRepository userDetailsRepository;
    private final BookingRepository bookingRepository;
    private final FlightRepository flightRepository;
    private final BookingFlightRepository bookingFlightRepository;*/

    public ApplicationRunner(final UserRepository userRepository) {
        this.userRepository = userRepository;
      /* this.userDetailsRepository = userDetailsRepository;
        this.bookingRepository = bookingRepository;
        this.flightRepository = flightRepository;
        this.bookingFlightRepository = bookingFlightRepository;*/
    }

    @Override
    @Transactional
    public void afterPropertiesSet() {
        // Method testing here

       userRepository.findAll().forEach(System.out::println);
    }

  /*  // Specification executor example
    private Specification<User> getSpecification() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("username"), "mariol.ballaj");
    }*/
}