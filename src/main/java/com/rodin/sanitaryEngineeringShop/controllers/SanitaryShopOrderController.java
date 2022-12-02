package com.rodin.sanitaryEngineeringShop.controllers;

import com.rodin.sanitaryEngineeringShop.model.SanitaryShopOrder;
import com.rodin.sanitaryEngineeringShop.repository.SanitaryShopOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/sanitary_order")
public class SanitaryShopOrderController {

    private final SanitaryShopOrderRepository sanitaryShopOrderRepository;

    @Autowired
    public SanitaryShopOrderController(SanitaryShopOrderRepository sanitaryShopOrderRepository) {
        this.sanitaryShopOrderRepository = sanitaryShopOrderRepository;
    }

    @GetMapping
    public ResponseEntity<List<SanitaryShopOrder>> getSanitaryShopOrders() {
        return ResponseEntity.ok(sanitaryShopOrderRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<SanitaryShopOrder> processOrder(@Valid @ModelAttribute("sanitaryOrder")
                                                              SanitaryShopOrder sanitaryShopOrder,
                                              Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(null);
        }
        log.info("Sanitary order submitted: " + sanitaryShopOrder);
        SanitaryShopOrder savedSanitaryShopOrder = this.sanitaryShopOrderRepository.save(sanitaryShopOrder);
        return ResponseEntity.ok(savedSanitaryShopOrder);
    }
}
