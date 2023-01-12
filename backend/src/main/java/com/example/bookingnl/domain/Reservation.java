package com.example.bookingnl.domain;

import com.example.bookingnl.exceptions.InvalidData;
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
    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;
    @NotNull

    private int guests;

    private double totalPrice;

    public void setStartDate(Date startDate) throws Exception {
        if (startDate.compareTo(endDate) >0){
            this.startDate = startDate;
        }
        else{
            throw new InvalidData();
        }
    }
}
