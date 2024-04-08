package edu.training.orderservice.repo;

import edu.training.orderservice.model.OderLineItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OderLineItemRepo extends JpaRepository<OderLineItems,Long> {
}
