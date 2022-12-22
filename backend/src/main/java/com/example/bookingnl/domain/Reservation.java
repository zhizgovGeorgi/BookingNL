package com.example.bookingnl.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
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
    @Setter(AccessLevel.NONE)
    private Date startDate;
    private Date endDate;
    @NotNull

    private int guests;

    private double totalPrice;

    public void setStartDate(Date startDate) throws Exception {
        if (startDate.compareTo(endDate) >0){
            this.startDate = startDate;
        }
        else{
            throw new Exception("Start cannot be before end date");
        }
    }
}
