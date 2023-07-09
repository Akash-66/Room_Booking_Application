package com.sweethome.payment.dao;

import com.sweethome.payment.entities.TransactionDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDetailsDAO extends JpaRepository<TransactionDetailsEntity, Integer> {

}
