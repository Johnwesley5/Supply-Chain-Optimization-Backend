// package com.supplyChainOptimization.orders_service.controller;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.supplyChainOptimization.orders_service.model.Product;
// import com.supplyChainOptimization.orders_service.model.QuantityUpdateRequest;
// import com.supplyChainOptimization.orders_service.repository.ProductRepository;
// import com.supplyChainOptimization.orders_service.service.ProductService;

// @RestController
// @RequestMapping("/api/products")
// public class ProductController {

//     @Autowired
//     private ProductService productService;

//     @Autowired
//     private ProductRepository productRepository;

//     @PostMapping("/addProduct")
//     public ResponseEntity<Product> addProduct(@RequestBody Product product) {
//         Product savedProduct = productService.addProduct(product);
//         return ResponseEntity.ok(savedProduct);
//     }
//     @PutMapping("/{productId}/quantity")
//     public ResponseEntity<Product> updateProductQuantity(@PathVariable Long productId, @RequestBody QuantityUpdateRequest request) {
//         Optional<Product> productOptional = productRepository.findById(productId);

//         if (!productOptional.isPresent()) {
//             return ResponseEntity.notFound().build();
//         }

//         Product product = productOptional.get();
//         product.setQuantity(request.getQuantity());
//         productRepository.save(product);

//         return ResponseEntity.ok(product);
//     }
// }

package com.supplyChainOptimization.orders_service.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.supplyChainOptimization.orders_service.model.Product;
import com.supplyChainOptimization.orders_service.model.QuantityUpdateRequest;
import com.supplyChainOptimization.orders_service.repository.ProductRepository;
import com.supplyChainOptimization.orders_service.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = productService.addProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    @PutMapping("/{productId}/quantity")
    public ResponseEntity<Product> updateProductQuantity(@PathVariable Long productId, @RequestBody QuantityUpdateRequest request) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (!productOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Product product = productOptional.get();
        product.setQuantity(request.getQuantity());
        productRepository.save(product);

        return ResponseEntity.ok(product);
    }
    
    @PutMapping("/{productId}/price")
    public ResponseEntity<Product> updateProductPrice(@PathVariable Long productId, @RequestBody Product productDetails) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (!productOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Product product = productOptional.get();
        product.setPrice(productDetails.getPrice());
        productRepository.save(product);

        return ResponseEntity.ok(product);
    }
}
