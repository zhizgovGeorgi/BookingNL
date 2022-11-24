package com.example.bookingnl.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CreateReservationRequest {
    private User user;
    private Destination destination;
    private Date startDate;
    private Date endDate;
    private int guests;
    private double totalPrice;

}
