package com.sweethome.booking.dao;

import com.sweethome.booking.entities.BookingInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingInfoDAO extends JpaRepository<BookingInfoEntity, Integer> {
}
