package com.rodin.theory.springInAction.configuration;

import com.rodin.theory.springInAction.util.InventoryService;
import com.rodin.theory.springInAction.util.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationClass {

    @Bean
    public InventoryService inventoryService() {
        return new InventoryService();
    }

    @Bean
    public ProductService productService() {
        return new ProductService(inventoryService());
    }
}
