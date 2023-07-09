package com.sweethome.booking.services;

import com.sweethome.booking.dao.BookingInfoDAO;
import com.sweethome.booking.dto.BookingDTO;
import com.sweethome.booking.dto.PaymentDTO;
import com.sweethome.booking.entities.BookingInfoEntity;
import com.sweethome.booking.exception.InvalidPaymentModeException;
import com.sweethome.booking.exception.ResourceNotFoundException;
import com.sweethome.booking.utils.BookingUtility;
import com.sweethome.booking.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingInfoDAO bookingInfoDAO;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${payment.url}")
    private String paymentUrl;

    @Override
    public BookingInfoEntity acceptBookingDetails(BookingDTO bookingDTO) {

        String numOfRooms = String.join(", ", BookingUtility.getRoomNumbers(bookingDTO.getNumOfRooms()));
        bookingDTO.setRoomNumbers(numOfRooms);
        bookingDTO.setBookedOn(LocalDate.now());
        int numOfDays = BookingUtility.getNumberOfDaysFromDates(bookingDTO.getFromDate(), bookingDTO.getToDate());
        bookingDTO.setRoomPrice(BookingUtility.getRoomPrice(bookingDTO.getNumOfRooms(), numOfDays));
        BookingInfoEntity bookingInfoEntity = ModelMapper.BookingDTO2BookingEntity(bookingDTO);
        return bookingInfoDAO.save(bookingInfoEntity);
    }



    @Override
    public BookingInfoEntity getBookingById(int id) {

        if(bookingInfoDAO.findById(id).isEmpty()){
            return null;
        }

        return bookingInfoDAO.findById(id).get();
    }

    @Override
    public BookingInfoEntity acceptPaymentDetails(PaymentDTO paymentDTO) {

        if(getBookingById(paymentDTO.getBookingId()) == null)
            throw new ResourceNotFoundException(String.format("No Booking found for the booking id %d" , paymentDTO.getBookingId()));

        if(!paymentDTO.getPaymentMode().toLowerCase().equals("card")  &&  !paymentDTO.getPaymentMode().toLowerCase().equals("upi")){

            throw new InvalidPaymentModeException("Invalid mode of payment");
        }

        Integer transactionId = restTemplate.postForObject(paymentUrl, paymentDTO, Integer.class);

        BookingInfoEntity bookingInfoEntity = new BookingInfoEntity();
        bookingInfoEntity = bookingInfoDAO.getReferenceById(paymentDTO.getBookingId());
        bookingInfoEntity.setTransactionId(transactionId);
        return bookingInfoEntity;

    }
}
