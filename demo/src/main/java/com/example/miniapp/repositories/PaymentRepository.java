package com.example.miniapp.repositories;


import com.example.miniapp.models.Payment;
import com.example.miniapp.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

//todo
// • Finding payments by trip ID.
// • Finding payments with an amount above a set threshold
//List<Payment> findPaymentsByTrip(long tripId);
List<Payment> findPaymentsByAmountGreaterThan(Double amount);

    @Query("SELECT p FROM Payment p WHERE p.trip.id = :tripId")
    List<Payment> findPaymentsByTripId(@Param("tripId") Long tripId);


}

