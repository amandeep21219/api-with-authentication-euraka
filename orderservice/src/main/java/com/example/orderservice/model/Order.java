package com.example.orderservice.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String userId;
    private String productId;
    private Integer quantity;
}