package edu.training.inventoryservice.repo;

import edu.training.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepo extends JpaRepository<Inventory,Integer> {

    List<Inventory> findByProductNameIn(List<String> productName);
}
