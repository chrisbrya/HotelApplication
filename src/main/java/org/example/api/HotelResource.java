package org.example.api;

import org.example.model.Customer;
import org.example.model.IRoom;
import org.example.model.Reservation;
import org.example.service.CustomerService;
import org.example.service.ReservationService;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class HotelResource {

    private static CustomerService customerService;
    private static ReservationService reservationService;


    public static Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }

    public static void createACustomer(String email, String firstName, String lastName){
        customerService.addCustomers(email, firstName, lastName);
    }

    public static IRoom getRoom(String roomNumber){
        return reservationService.getRoom(roomNumber);
    }

    public static Reservation bookARoom(String customerEmail, IRoom rooom, Date checkInDate, Date checkOutDate){
        return reservationService.reserveARoom(getCustomer(customerEmail), rooom, checkInDate, checkOutDate);
    }

    public static Collection<Reservation> getCustomersReservations(String customerEmail){
        Customer customer = getCustomer(customerEmail);

        if(customer == null){
            return Collections.emptyList();
        }else {
            return reservationService.getCustomerReservation(getCustomer(customerEmail));
        }
    }

    public static Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return reservationService.findRooms(checkIn, checkOut);
    }

}
