package org.example.service;

import org.example.model.Customer;
import org.example.model.IRoom;
import org.example.model.Reservation;

import java.util.*;

public class ReservationService {
    private final Map<String, IRoom> rooms = new HashMap<>();
    private final Map<String, Collection<Reservation>> reservations = new HashMap<>();

    public ReservationService() {
    }

    public void addRoom(IRoom room){
        rooms.put(room.getRoomNumber(), room);
    }

    public IRoom getRoom(String roomNumber){
        return rooms.get(roomNumber);
    }
    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){

        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);


        Collection<Reservation> customerReservations = getCustomerReservation(customer);

        if (customerReservations == null){
            customerReservations = new ArrayList<>();
        }
        customerReservations.add(reservation);
        reservations.put(customer.getEmail(), customerReservations);

        return reservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){


        Collection<Reservation> allReservation = new ArrayList<>();
        Collection<IRoom> notAvailable = new ArrayList<>();

        for (Collection<Reservation> reservations: reservations.values()){
            allReservation.addAll(reservations);
        }
        Reservation reservation = new Reservation();
        if (checkInDate.before(reservation.getCheckOutDate() )&& checkOutDate.after(reservation.getCheckInDate())){
            notAvailable.add(reservation.getRoom());
        }

        return rooms.values();
    }

    public Collection<IRoom> getAllRooms(){
        return rooms.values();
    }

    public Collection<Reservation> getCustomerReservation(Customer customer){
        return reservations.get(customer.getEmail());
    }

    public void printAllReservations() {
        Collection<Reservation> allReservations = new ArrayList<>();

        for (Collection<Reservation> reservations:reservations.values()){
            allReservations.addAll(reservations);
        }
        if (reservations.isEmpty()){
            System.out.println("No reservations found.");
        }else {
            System.out.println(reservations);
        }
    }
}
