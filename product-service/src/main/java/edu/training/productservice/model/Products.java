package edu.training.productservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer proId;
    @Column(nullable = false)
    private String productName;
    private String productDesc;
    private BigDecimal productPrice;

}
