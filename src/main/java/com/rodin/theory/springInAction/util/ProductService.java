package com.rodin.theory.springInAction.util;

public class ProductService {

    private InventoryService inventoryService;

    public ProductService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
}
