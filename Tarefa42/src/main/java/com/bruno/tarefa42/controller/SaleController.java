package com.bruno.tarefa42.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bruno.tarefa42.model.Sale;
import com.bruno.tarefa42.service.SaleService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Tag(name = "Sales", description = "Operations related to sales")
@RestController
@RequestMapping("/api/sales")
public class SaleController {
	
	@Autowired
    private SaleService saleService;

    @Operation(summary = "Register a new sale")
    @ApiResponse(responseCode = "201", description = "Sale created")
    @PostMapping
    public Sale create(@RequestParam Long clientId, @RequestBody List<Long> productIds) {
        return saleService.makeSale(clientId, productIds);
    }

    @Operation(summary = "Get sales by ID")
    @ApiResponse(responseCode = "200", description = "Sales fetched")
    @GetMapping("/{id}")
    public Sale getById(@PathVariable Long id) {
        return saleService.findById(id);
    }

    @Operation(summary = "Get all sales")
    @ApiResponse(responseCode = "200", description = "Sales fetched")
    @GetMapping
    public List<Sale> getAll() {
        return saleService.findAll();
    }

}
