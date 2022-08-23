package org.example;

import org.example.api.AdminResource;
import org.example.api.HotelResource;
import org.example.model.IRoom;
import org.example.model.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {

    private static final String DEFAULT_DATE_FORMAT = "MM/dd/yyyy";

    private static HotelResource hotelResource;

    public static void mainMenu(){
        String input = "";
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\nWelcome to the Hotel Reservation Application\n" +
                            "--------------------------------------------------\n" +
                            "1. Find and reserve a room\n" +
                            "2. See reservations\n" +
                            "3. Create an Account\n" +
                            "4. Admin\n" +
                            "5. Exit\n" +
                            "--------------------------------------------------\n" +
                            "Please select a number for the menu options: \n");

        try{
            do {
                input = scanner.nextLine();

                if (input.length() == 1){
                    switch (input.charAt(0)){
                        case '1':
                            findAndReserveRoom();
                            break;
                        case '2':
                            //seeMyReservation();
                            break;
                        case '3':
                            //createAccount();
                            break;
                        case '4':
                            //adminMenu();
                            break;
                        case '5':
                            System.out.println("Exiting Program...");;
                            break;
                        default:
                            System.out.println("Incorrect input! Please Try Again");
                            mainMenu();
                            break;
                        }
                    }else{
                    System.out.println("Error Invalid Action");
                }
            } while (input.charAt(0) != '5' || input.length() != 1);
        } catch (IllegalStateException exception) {
            System.out.println("Empty Input. Exiting Program");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void findAndReserveRoom() throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Check-in Date mm/dd/yyyy format");
        Date checkIn = new SimpleDateFormat(DEFAULT_DATE_FORMAT).parse(scanner.nextLine());

        System.out.println("Enter Check-out Date mm/dd/yyyy format");
        Date checkOut = new SimpleDateFormat(DEFAULT_DATE_FORMAT).parse(scanner.nextLine());

        if (checkIn != null && checkOut != null){
            Collection<IRoom> availableRooms = hotelResource.findARoom(checkIn, checkOut);

            if (availableRooms.isEmpty()){
                System.out.println("No rooms available.");
            } else {
                System.out.println("Available rooms are: " + availableRooms.toString());
            }
        }
    }



}
