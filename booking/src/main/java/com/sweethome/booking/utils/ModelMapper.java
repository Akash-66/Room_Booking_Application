package com.sweethome.booking.utils;


import com.sweethome.booking.dto.BookingDTO;
import com.sweethome.booking.entities.BookingInfoEntity;

public class ModelMapper {

    public static BookingInfoEntity BookingDTO2BookingEntity(BookingDTO bookingDTO){
        BookingInfoEntity bookingInfoEntity = new BookingInfoEntity();
        bookingInfoEntity.setBookingId(bookingDTO.getBookingId());
        bookingInfoEntity.setAadharNumber(bookingDTO.getAadharNumber());
        bookingInfoEntity.setFromDate(bookingDTO.getFromDate());
        bookingInfoEntity.setBookedOn(bookingDTO.getBookedOn());
        bookingInfoEntity.setRoomNumbers(bookingDTO.getRoomNumbers());
        bookingInfoEntity.setNumOfRooms(bookingDTO.getNumOfRooms());
        bookingInfoEntity.setToDate(bookingDTO.getToDate());
        bookingInfoEntity.setRoomPrice(bookingDTO.getRoomPrice());
        bookingInfoEntity.setTransactionId(bookingDTO.getTransactionId());
        return bookingInfoEntity;
    }

    public static BookingDTO BookingInfoEntity2BookingDTO(BookingInfoEntity bookingInfoEntity){

        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setBookedOn(bookingInfoEntity.getBookedOn());
        bookingDTO.setBookingId(bookingInfoEntity.getBookingId());
        bookingDTO.setAadharNumber(bookingInfoEntity.getAadharNumber());
        bookingDTO.setRoomNumbers(bookingInfoEntity.getRoomNumbers());
        bookingDTO.setNumOfRooms(bookingInfoEntity.getNumOfRooms());
        bookingDTO.setTransactionId(bookingInfoEntity.getTransactionId());
        bookingDTO.setFromDate(bookingInfoEntity.getFromDate());
        bookingDTO.setToDate(bookingInfoEntity.getToDate());
        bookingDTO.setRoomPrice(bookingInfoEntity.getRoomPrice());

        return bookingDTO;

    }


}
