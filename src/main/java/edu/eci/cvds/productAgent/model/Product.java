package edu.eci.cvds.productAgent.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@ToString
/**
 * This class represents a product
 */
public class Product {
    private String name;
    private BigDecimal price;
    private Integer quantity;
    private String category;
}
