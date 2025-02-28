package com.example.orderservice.dto;



import lombok.Data;

@Data
public class OrderRequest {
    private String userId;
    private String productId;
    private Integer quantity;
}