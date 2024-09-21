package edu.eci.cvds.productAgent.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    private String name;
    private BigDecimal price;
    private Integer quantity;
    private String category;
}
