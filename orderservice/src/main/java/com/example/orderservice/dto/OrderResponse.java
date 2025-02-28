package com.example.orderservice.dto;

import lombok.Data;

@Data
public class OrderResponse {
    private String orderId;
    private String productId;
    private Integer quantity;

        public OrderResponse(String id, String productId, Integer quantity) {
    }
}