package com.sweethome.booking.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BookingUtility {

    public static Set<String> getRoomNumbers(int numOfDays){
        Random rand = new Random();
        int upperBound = 100;
        Set<String> roomNumbers = new HashSet<String>();

        for (int i=0; i<numOfDays; i++){
            roomNumbers.add(String.valueOf(rand.nextInt(upperBound)));
        }

        return roomNumbers;
    }

    public static int getRoomPrice(int numOfRooms , int numberOfDays){

        int roomPrice = 1000* numOfRooms*(numberOfDays);
        return roomPrice;
    }

    public static int getNumberOfDaysFromDates(LocalDate fromDate, LocalDate toDate){

        int totalDays = Period.between(fromDate, toDate).getDays();
        return totalDays;
    }

}
