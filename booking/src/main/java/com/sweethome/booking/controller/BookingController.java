package com.sweethome.booking.controller;

import com.sweethome.booking.dto.BookingDTO;
import com.sweethome.booking.dto.PaymentDTO;
import com.sweethome.booking.entities.BookingInfoEntity;
import com.sweethome.booking.exception.InvalidPaymentModeException;
import com.sweethome.booking.exception.InvalidResourceException;
import com.sweethome.booking.exception.ResourceNotFoundException;
import com.sweethome.booking.services.BookingService;
import com.sweethome.booking.utils.BookingUtility;
import com.sweethome.booking.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/hotel")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping(value = "/booking", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createBooking(@RequestBody BookingDTO bookingDTO){

        BookingInfoEntity savedBookingEntity = bookingService.acceptBookingDetails(bookingDTO);
        BookingDTO savedBooking = ModelMapper.BookingInfoEntity2BookingDTO(savedBookingEntity);
        return new ResponseEntity(savedBooking, HttpStatus.CREATED);

    }

    @PostMapping(value = "/booking/{bookingId}/transaction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createPayment(@RequestBody PaymentDTO paymentDTO, @PathVariable(name="bookingId") int bookingId){

        if(paymentDTO.getBookingId() != bookingId){
            throw new InvalidResourceException("Invalid Booking Id");
        }

        BookingInfoEntity savedBookingEntity = bookingService.acceptPaymentDetails(paymentDTO);
        BookingDTO savedBookingDTO = ModelMapper.BookingInfoEntity2BookingDTO(savedBookingEntity);


        return new ResponseEntity(savedBookingDTO, HttpStatus.OK);

    }

    @GetMapping(value = "/live")
    public String live(){
        return "Hello World!!! I am live now";
    }
}


