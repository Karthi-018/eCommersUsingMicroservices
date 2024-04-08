package edu.training.orderservice.dto;

import edu.training.orderservice.model.OderLineItems;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {

    private List<OderLineItemsDto> oderLineItemsList;

}
