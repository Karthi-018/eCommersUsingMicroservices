package edu.training.orderservice.service;

import edu.training.orderservice.dto.InventoryResponce;
import edu.training.orderservice.dto.OderLineItemsDto;
import edu.training.orderservice.dto.OrderRequest;
import edu.training.orderservice.model.OderLineItems;
import edu.training.orderservice.model.Order;
import edu.training.orderservice.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo repo;

    private final WebClient.Builder webClient;

    public void placeOrder(OrderRequest orderRequest)
    {
        List<OderLineItems> productList = orderRequest.getOderLineItemsList().stream().map(product->mapToOrderLineItems(product)).toList();

        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .oderLineItemsList(productList)
                .build();

        List<String> productNames = order.getOderLineItemsList().stream().map(pList -> pList.getProductName()).toList();
     InventoryResponce[] inventoryResponces =   webClient.build().get().uri("http://inventory-service/api/inventory",uriBuilder -> uriBuilder.queryParam("productName",productNames).build())
                        .retrieve()
                                .bodyToMono(InventoryResponce[].class)
                                        .block();
     boolean productStockStatus = Arrays.stream(inventoryResponces).allMatch(iRes-> iRes.isProductStatus());

     if(productStockStatus)
     {
         repo.save(order);
     }
     else {
            throw  new IllegalArgumentException("Some of the Product is not in stock , please try later ");
     }

    }

    private OderLineItems mapToOrderLineItems(OderLineItemsDto o) {

        return OderLineItems.builder()
                .productName(o.getProductName())
                .productPrice(o.getProductPrice())
                .productQty(o.getProductQty())
                .build();
    }
}
