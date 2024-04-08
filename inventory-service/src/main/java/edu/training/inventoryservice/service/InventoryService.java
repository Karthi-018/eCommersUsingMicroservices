package edu.training.inventoryservice.service;

import edu.training.inventoryservice.dto.InventoryRequest;
import edu.training.inventoryservice.dto.InventoryResponce;
import edu.training.inventoryservice.model.Inventory;
import edu.training.inventoryservice.repo.InventoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
@RequiredArgsConstructor
public class InventoryService {

   private final InventoryRepo repo;



    public List<InventoryResponce> checkProductStock(List<String> productName)
    {
       return repo.findByProductNameIn(productName).stream().map(inventory -> InventoryResponce.builder()
                .productName(inventory.getProductName())
                .productStatus(inventory.getProductQty()>0).build()).toList();
    }

    public void createInventory(InventoryRequest inventoryRequest) {
        Inventory inventory = Inventory.builder()
                .productName(inventoryRequest.getProductName())
                .productQty(inventoryRequest.getProductQty())
                .build();
        repo.save(inventory);
    }
}
