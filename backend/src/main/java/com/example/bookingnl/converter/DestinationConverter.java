package com.example.bookingnl.converter;

import com.example.bookingnl.domain.CreateDestinationRequest;
import com.example.bookingnl.domain.Destination;
import com.example.bookingnl.domain.DestinationResponse;
import lombok.Builder;
import lombok.NoArgsConstructor;


public class DestinationConverter {

    public static Destination requestToEntity(CreateDestinationRequest request){
        Destination destination = Destination.builder()
                .name(request.getName())
                .location(request.getLocation())
                .pricePerNight(request.getPricePerNight())
                .build();
        return destination;
    }

    public static DestinationResponse entityToResponse(Destination destination){
        DestinationResponse response = DestinationResponse.builder()
                .id(destination.getId())
                .build();
        return response;
    }
}
