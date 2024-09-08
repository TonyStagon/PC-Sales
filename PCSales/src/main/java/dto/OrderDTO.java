package com.example.pcsale.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private Long customerId;
    private List<ProductDTO> products;
    private LocalDateTime orderDate;
    private Double totalAmount;

    public OrderDTO(Long id, Long customerId, List<ProductDTO> products, LocalDateTime orderDate, Double totalAmount) {
        this.id = id;
        this.customerId = customerId;
        this.products = products;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }
}
