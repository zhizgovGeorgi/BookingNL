package com.example.bookingnl.domain;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.awt.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String location;
    @NotNull
    @Setter(AccessLevel.NONE)
    private double pricePerNight;

    public void setPricePerNight(double pricePerNight) throws Exception {
        if(pricePerNight>0){
            this.pricePerNight = pricePerNight;
        }
        else {
            throw new Exception("Price cannot 0 or less");
        }
    }
}
