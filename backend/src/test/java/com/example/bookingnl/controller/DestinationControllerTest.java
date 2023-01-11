package com.example.bookingnl.controller;

import com.example.bookingnl.bussines.DestinationService;
import com.example.bookingnl.bussines.UserService;
import com.example.bookingnl.domain.Destination;
import com.example.bookingnl.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
class DestinationControllerTest {
    @Autowired
    private DestinationController destinationController;

    @MockBean
    private DestinationService destinationService;
//    @MockBean
//    private UserService userService;
//happy flow
    @Test
    void getDestinations_should_return_list_of_dest() throws Exception {
        //arrange
        List<Destination> destinationList = new ArrayList<>(List.of(Destination.builder().id(1L).build(), Destination.builder().id(2L).build()));
        when(destinationService.findAll()).thenReturn(destinationList);

        //act
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/destinations");
        String content = (new ObjectMapper()).writeValueAsString(destinationList);
        MockMvcBuilders.standaloneSetup(destinationController)
                .build()
                .perform(requestBuilder)
        //assert
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(content));
    }

    //unhappy flow
    @Test
    void getDestinations_should_return_empty_list() throws Exception {
        //arrange
        List<Destination> destinationList = new ArrayList<>();
        when(destinationService.findAll()).thenReturn(destinationList);

        //act
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/destinations");
        String content = (new ObjectMapper()).writeValueAsString(destinationList);
        MockMvcBuilders.standaloneSetup(destinationController)
                .build()
                .perform(requestBuilder)
                //assert
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(content));
    }

    //happy flow
    @Test
    void saveDestination_successfully() throws Exception {
//            //ARRANGE
//        Destination destination = Destination.builder().id(1L).location("Sunny").pricePerNight(21).name("Sunny").build();
//            CreateDestinationRequest destinationRequest = new CreateDestinationRequest();
//            destinationRequest.setEmail("g@abv.bg");
//            destinationRequest.setName("Sunny");
//            destinationRequest.setLocation("Sunny");
//            destinationRequest.setPricePerNight(21);
//            when(destinationService.saveDestination(any(Destination.class))).thenReturn(destination);
//            String content = (new ObjectMapper()).writeValueAsString(destinationRequest);
//            String expected = (new ObjectMapper()).writeValueAsString(destination);
//
//            MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/destinations")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(content);
//
//
//            //ACT
//            MockMvcBuilders.standaloneSetup(destinationController)
//                    .build()
//                    .perform(requestBuilder)
//                    //ASSERT
////                    .andExpect(MockMvcResultMatchers.status().isOk())
//                    .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                    .andExpect(MockMvcResultMatchers.content().string(expected));
        }


//happy flow
    @Test
    void getDestination() throws Exception {
        //arrange
       Destination destination = Destination.builder().id(1L).build();
        when(destinationService.findById(any(Long.class))).thenReturn(Optional.ofNullable(destination));

        //act
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/destinations/{id}", 1L);
        String content = (new ObjectMapper()).writeValueAsString(destination);
        MockMvcBuilders.standaloneSetup(destinationController)
                .build()
                .perform(requestBuilder)
                //assert
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(content));
    }

    //unhappy flow
    @Test
    void getDestination_null() throws Exception {
        //arrange
        Destination destination = null;
        when(destinationService.findById(any(Long.class))).thenReturn(Optional.ofNullable(destination));

        //act
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/destinations/{id}", 1L);
        String content = (new ObjectMapper()).writeValueAsString(destination);
        MockMvcBuilders.standaloneSetup(destinationController)
                .build()
                .perform(requestBuilder)
                //assert
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(content));
    }

//happy flow
    @Test
    void deleteDestination() throws Exception {
        //arrange
        String content = (new ObjectMapper()).writeValueAsString("ga@abv.bg");
//        when(userService.findByEmail(any(String.class))).then((Answer<?>) User.builder().role("Admin").build());
        when(destinationService.findById(any(Long.class))).thenReturn(Optional.ofNullable(Destination.builder().build()));

        //act
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/destinations/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        MockMvcBuilders.standaloneSetup(destinationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    //unhappy flow
    @Test
    void deleteDestination_when_not_existing() throws Exception {
        //arrange
        String content = (new ObjectMapper()).writeValueAsString("ga@abv.bg");
        when(destinationService.findById(any(Long.class))).thenReturn(null);

        //act
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/destinations/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        MockMvcBuilders.standaloneSetup(destinationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}