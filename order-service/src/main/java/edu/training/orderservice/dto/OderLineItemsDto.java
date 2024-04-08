package edu.training.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OderLineItemsDto {

    private Long orderLineItemId;
    private String productName;
    private Integer productQty;
    private BigDecimal productPrice;
}
