package edu.training.productservice.repo;


import edu.training.productservice.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Products,Integer> {
}
