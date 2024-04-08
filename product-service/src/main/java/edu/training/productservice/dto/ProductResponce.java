package edu.training.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponce {

    private Integer proId;
    private String productName;
    private String productDesc;
    private BigDecimal productPrice;

}
