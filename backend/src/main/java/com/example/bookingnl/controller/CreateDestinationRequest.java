package com.example.bookingnl.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CreateDestinationRequest {
    private String name;
    private String location;
    private double pricePerNight;

}