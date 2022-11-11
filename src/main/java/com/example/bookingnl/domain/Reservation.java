package com.example.bookingnl.domain;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;
    @ManyToOne()
    @JoinColumn(name = "destinationId", referencedColumnName = "id")
    private Destination destination;
    private Date startDate;
    private Date endDate;
    private int guests;
    private double totalPrice;
}
