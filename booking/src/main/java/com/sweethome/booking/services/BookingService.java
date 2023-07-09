package com.sweethome.booking.services;

import com.sweethome.booking.dto.BookingDTO;
import com.sweethome.booking.dto.PaymentDTO;
import com.sweethome.booking.entities.BookingInfoEntity;

public interface BookingService {

    public BookingInfoEntity acceptBookingDetails(BookingDTO bookingDTO);


    public BookingInfoEntity acceptPaymentDetails(PaymentDTO paymentDTO);

    public BookingInfoEntity getBookingById(int id);
}
