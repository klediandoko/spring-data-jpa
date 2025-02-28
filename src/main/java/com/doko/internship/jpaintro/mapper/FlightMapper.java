package com.doko.internship.jpaintro.mapper;

import com.doko.internship.jpaintro.model.entity.Flight;
import com.doko.internship.jpaintro.model.resources.FlightResource;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper {

   public FlightResource toResource(final Flight flight){
       return new FlightResource(flight);
   }

    public void updateFlight(Flight flightToUpdate, FlightResource flightResource) {

        flightToUpdate.setOrigin(flightResource.getOrigin());
        flightToUpdate.setAirline(flightResource.getAirline());
        flightToUpdate.setArrivalDate(flightResource.getArrivalDate());
        flightToUpdate.setDepartureDate(flightResource.getDepartureDate());
        flightToUpdate.setDestination(flightResource.getDestination());
        flightToUpdate.setFlightNumber(flightResource.getFlightNumber());
        flightToUpdate.setFlightStatus(flightResource.getFlightStatus());

    }
}
