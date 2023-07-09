package com.sweethome.payment.controller.service;


import com.sweethome.payment.dto.TransactionDTO;
import com.sweethome.payment.entities.TransactionDetailsEntity;
import com.sweethome.payment.service.PaymentService;
import com.sweethome.payment.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/transaction")
    public ResponseEntity createPayment(@RequestBody TransactionDTO transactionDTO){
        TransactionDetailsEntity transactionDetailsEntity = ModelMapper.transactionDTO2TransactionEntity(transactionDTO);
        int transactionId = paymentService.createTransaction(transactionDetailsEntity);

        return new ResponseEntity(transactionId, HttpStatus.CREATED);
    }

    @GetMapping("/transaction/{transactionId}")
    public ResponseEntity getTransactionDetails(@PathVariable(name = "transactionId") int id){
        TransactionDetailsEntity transactionDetailsEntity = paymentService.getTransactionDetailById(id);
        return new ResponseEntity(transactionDetailsEntity, HttpStatus.OK);

    }
}
