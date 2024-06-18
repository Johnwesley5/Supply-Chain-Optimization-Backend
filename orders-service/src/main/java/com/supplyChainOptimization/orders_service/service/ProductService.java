// package com.supplyChainOptimization.orders_service.service;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.supplyChainOptimization.orders_service.model.Product;
// import com.supplyChainOptimization.orders_service.repository.ProductRepository;

// @Service
// public class ProductService {

//     @Autowired
//     private ProductRepository productRepository;

//     public Product addProduct(Product product) {
//         return productRepository.save(product);
//     }
//     public Product updateProductQuantity(Long productId, int quantity) {
//         Optional<Product> optionalProduct = productRepository.findById(productId);
//         if (optionalProduct.isPresent()) {
//             Product product = optionalProduct.get();
//             product.setQuantity(quantity);
//             return productRepository.save(product);
//         } else {
//             throw new RuntimeException("Product not found");
//         }
//     }
// }

package com.supplyChainOptimization.orders_service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplyChainOptimization.orders_service.model.Product;
import com.supplyChainOptimization.orders_service.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProductQuantity(Long productId, int quantity) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setQuantity(quantity);
            return productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    public Product updateProductPrice(Long productId, double price) { // Add this method
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setPrice(price);
            return productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found");
        }
    }
}
