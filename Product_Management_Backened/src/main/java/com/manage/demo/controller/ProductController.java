package com.manage.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.manage.demo.model.Product;
import com.manage.demo.service.ProductService;

import java.util.List;


@RestController
@RequestMapping("/products")   // 🔥 Base URL fix
@CrossOrigin(origins = "http://localhost:3000") // React ke liye
public class ProductController {

    @Autowired
    private ProductService productService;

    // ✅ Create Product
    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    // ✅ Get All Products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    // ✅ Get Product By ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    // ✅ Delete Product
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product Deleted Successfully", HttpStatus.OK);
    }

    // ✅ Update Product
    @PutMapping("/{id}")
    public ResponseEntity<Product> editProduct(@RequestBody Product product, @PathVariable Integer id) {
        return new ResponseEntity<>(productService.editProduct(product, id), HttpStatus.OK);
    }
}