package edu.training.productservice.service;

import edu.training.productservice.dto.InventoryRequest;
import edu.training.productservice.dto.ProductRequest;
import edu.training.productservice.dto.ProductResponce;
import edu.training.productservice.model.Products;
import edu.training.productservice.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo repo;

    private final WebClient.Builder webClient;

    public void createProduct(ProductRequest productRequest)
    {
        Products products = Products.builder()
                .productName(productRequest.getProductName())
                .productDesc(productRequest.getProductDesc())
                .productPrice(productRequest.getProductPrice())
                .build();

        InventoryRequest inventoryRequest = InventoryRequest.builder()
                        .productName(productRequest.getProductName())
                                .productQty(10)
                                        .build();

        webClient.build().post().uri("http://inventory-service/api/inventory")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(inventoryRequest)
                .retrieve()
                .toBodilessEntity()
                .block();
        repo.save(products);
    }


    public List<ProductResponce> getAllProducts()
    {
        List<Products> products = repo.findAll();

        ProductResponce pr = null;
        List<ProductResponce> productResponces = new ArrayList<>();
        for(Products p : products)
        {
             pr = new ProductResponce();
            pr.setProductName(p.getProductName());
            pr.setProductDesc(p.getProductDesc());
            pr.setProductPrice(p.getProductPrice());
            productResponces.add(pr);
        }



//      List<ProductResponce> productResponces =  products.stream().map(product->mapToProductResponce(product)).toList();
        return productResponces;
    }

    private ProductResponce mapToProductResponce(Products product) {

      return  ProductResponce.builder()
                .proId(product.getProId())
                .productName(product.getProductName())
                .productDesc(product.getProductDesc())
                .productPrice(product.getProductPrice())
                .build();
    }


}
