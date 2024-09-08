package com.example.pcsale.bl;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pcsale.dto.OrderDTO;
import com.example.pcsale.dto.ProductDTO;
import com.example.pcsale.model.Order;
import com.example.pcsale.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepo.findAll();
        List<OrderDTO> orderDTOs = new ArrayList<>();

        for (Order order : orders) {
            List<ProductDTO> products = new ArrayList<>();
            order.getProducts().forEach(product -> {
                products.add(new ProductDTO(product.getId().toString(), product.getBrand(), product.getName(), product.getProcessor(), product.getStorage(), product.getRam(), product.getAdditionalFeatures(), product.getCondition(), product.getPrice().toString(), "data:image/png;base64," + Base64.getEncoder().encodeToString(product.getImage())));
            });

            orderDTOs.add(new OrderDTO(order.getId(), order.getCustomer().getId(), products, order.getOrderDate(), order.getTotalAmount()));
        }

        return orderDTOs;
    }
}
