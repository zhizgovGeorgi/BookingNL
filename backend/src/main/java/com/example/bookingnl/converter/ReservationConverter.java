package com.example.bookingnl.converter;

import com.example.bookingnl.controller.CreateReservationRequest;
import com.example.bookingnl.controller.ReservationResponse;
import com.example.bookingnl.domain.*;


public class ReservationConverter {

    public static Reservation requestToEntity(CreateReservationRequest request){
        Reservation reservation = Reservation.builder()
                .user(request.getUser())
                .destination(request.getDestination())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .guests(request.getGuests())
                .totalPrice(request.getTotalPrice())
                .build();
        return reservation;
    }

    public static ReservationResponse entityToResponse(Reservation reservation){
        ReservationResponse response = ReservationResponse.builder()
                .id(reservation.getId())
                .build();
        return response;
    }
}
