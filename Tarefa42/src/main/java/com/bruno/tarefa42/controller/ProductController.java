package com.bruno.tarefa42.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bruno.tarefa42.model.Product;
import com.bruno.tarefa42.service.ProductService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Tag(name = "Products", description = "Operations related to products")
@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
    private ProductService productService;

	@Operation(summary = "Create a new product")
    @ApiResponse(responseCode = "201", description = "Product created")
    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }

	@Operation(summary = "Get product ID") 
    @ApiResponse(responseCode = "200", description = "Product fetched")
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.findById(id);
    }
    
    @Operation(summary = "Get all products")
    @ApiResponse(responseCode = "200", description = "Products fetched")
    @GetMapping
    public List<Product> getAll() {
        return productService.findAll();
    }

    @Operation(summary = "Update product ID") 
    @ApiResponse(responseCode = "200", description = "Product updated")
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return productService.update(id, product);
    }
    
    @Operation(summary = "Delete a product by ID")
    @ApiResponse(responseCode = "204", description = "Product deleted")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

}
