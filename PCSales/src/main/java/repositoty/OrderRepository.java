package com.example.pcsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pcsale.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
