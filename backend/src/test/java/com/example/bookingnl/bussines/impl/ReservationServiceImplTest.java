package com.example.bookingnl.bussines.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.bookingnl.domain.Destination;
import com.example.bookingnl.domain.Reservation;
import com.example.bookingnl.domain.User;
import com.example.bookingnl.persistence.ReservationRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ReservationServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ReservationServiceImplTest {
    @MockBean
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationServiceImpl reservationServiceImpl;


    @Test
    @Disabled("TODO: Complete this test")
    void testSaveReservation() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.Exception: Start cannot be before end date
        //       at com.example.bookingnl.domain.Reservation.setStartDate(Reservation.java:39)
        //   See https://diff.blue/R013 to resolve this issue.

        Reservation reservation = new Reservation();

        Destination destination = new Destination();
        destination.setId(123L);
        destination.setLocation("Location");
        destination.setName("Name");
        destination.setPricePerNight(10.0d);
        reservation.setDestination(destination);
        ZoneId zone = ZoneId.of("UTC");
        reservation.setEndDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(zone).toInstant()));
        reservation.setGuests(1);
        reservation.setId(123L);
        ZoneId zone1 = ZoneId.of("UTC");
        reservation.setStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(zone1).toInstant()));
        reservation.setTotalPrice(10.0d);

        User user = new User();
        user.setAdress("Adress");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRole("Role");
        reservation.setUser(user);
        reservationServiceImpl.saveReservation(reservation);
    }


    @Test
    void testSaveReservation2() throws Exception {
        Destination destination = new Destination();
        destination.setId(123L);
        destination.setLocation("Location");
        destination.setName("Name");
        destination.setPricePerNight(10.0d);

        User user = new User();
        user.setAdress("Adress");
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setRole("Role");
        Reservation reservation = mock(Reservation.class);
        doNothing().when(reservation).setDestination((Destination) any());
        doNothing().when(reservation).setEndDate((Date) any());
        doNothing().when(reservation).setGuests(anyInt());
        doNothing().when(reservation).setId((Long) any());
        doNothing().when(reservation).setStartDate((Date) any());
        doNothing().when(reservation).setTotalPrice(anyDouble());
        doNothing().when(reservation).setUser((User) any());
        reservation.setDestination(destination);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        reservation.setEndDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        reservation.setGuests(1);
        reservation.setId(123L);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        reservation.setStartDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        reservation.setTotalPrice(10.0d);
        reservation.setUser(user);
        when(reservationRepository.save((Reservation) any())).thenReturn(reservation);

        Destination destination1 = new Destination();
        destination1.setId(123L);
        destination1.setLocation("Location");
        destination1.setName("Name");
        destination1.setPricePerNight(10.0d);

        User user1 = new User();
        user1.setAdress("Adress");
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        user1.setRole("Role");
        Reservation reservation1 = mock(Reservation.class);
        doNothing().when(reservation1).setDestination((Destination) any());
        doNothing().when(reservation1).setEndDate((Date) any());
        doNothing().when(reservation1).setGuests(anyInt());
        doNothing().when(reservation1).setId((Long) any());
        doNothing().when(reservation1).setStartDate((Date) any());
        doNothing().when(reservation1).setTotalPrice(anyDouble());
        doNothing().when(reservation1).setUser((User) any());
        reservation1.setDestination(destination1);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        reservation1.setEndDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        reservation1.setGuests(1);
        reservation1.setId(123L);
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        reservation1.setStartDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        reservation1.setTotalPrice(10.0d);
        reservation1.setUser(user1);
        reservationServiceImpl.saveReservation(reservation1);
        verify(reservationRepository).save((Reservation) any());
        verify(reservation).setDestination((Destination) any());
        verify(reservation).setEndDate((Date) any());
        verify(reservation).setGuests(anyInt());
        verify(reservation).setId((Long) any());
        verify(reservation).setStartDate((Date) any());
        verify(reservation).setTotalPrice(anyDouble());
        verify(reservation).setUser((User) any());
        verify(reservation1).setDestination((Destination) any());
        verify(reservation1).setEndDate((Date) any());
        verify(reservation1).setGuests(anyInt());
        verify(reservation1).setId((Long) any());
        verify(reservation1).setStartDate((Date) any());
        verify(reservation1).setTotalPrice(anyDouble());
        verify(reservation1).setUser((User) any());
    }


    @Test
    void testFindAllReservationsByUserId() {
        ArrayList<Reservation> reservationList = new ArrayList<>();
        when(reservationRepository.findAllByUserId((Long) any())).thenReturn(reservationList);
        List<Reservation> actualFindAllReservationsByUserIdResult = reservationServiceImpl
                .findAllReservationsByUserId(123L);
        assertSame(reservationList, actualFindAllReservationsByUserIdResult);
        assertTrue(actualFindAllReservationsByUserIdResult.isEmpty());
        verify(reservationRepository).findAllByUserId((Long) any());
    }
}

