package edu.training.inventoryservice.controller;

import edu.training.inventoryservice.dto.InventoryRequest;
import edu.training.inventoryservice.dto.InventoryResponce;
import edu.training.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponce> checkProductStock(@RequestParam List<String> productName)
    {
      return   inventoryService.checkProductStock(productName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createInventory(@RequestBody InventoryRequest inventoryRequest)
    {
        inventoryService.createInventory(inventoryRequest);

    }
}
