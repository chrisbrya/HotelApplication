package org.example.api;

import org.example.model.Customer;
import org.example.model.IRoom;
import org.example.model.Reservation;
import org.example.service.CustomerService;
import org.example.service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {

public static CustomerService customerService;

public static ReservationService reservationService;

    public AdminResource() {
    }

    public Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }

    public void addRoom(List<IRoom> rooms){
        rooms.forEach(reservationService::addRoom);
    }

    public Collection<IRoom> getAllRooms() {
        return reservationService.getAllRooms();
    }

    public Collection<Customer> getAllCustomers(){
        return (Collection<Customer>) customerService.getAllCustomers();
    }

    public void displayAllReservations(){
        reservationService.printAllReservations();
    }
}
