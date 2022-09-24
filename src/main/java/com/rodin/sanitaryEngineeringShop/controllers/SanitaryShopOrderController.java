package com.rodin.sanitaryEngineeringShop.controllers;

import com.rodin.sanitaryEngineeringShop.model.PlumbingTypes;
import com.rodin.sanitaryEngineeringShop.model.SanitaryShopOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/sanitary_order")
public class SanitaryShopOrderController {

    @ModelAttribute("plumbingSanitaryTypes")
    public List<PlumbingTypes> bindBreakDownTypesAttribute() {
        return Arrays.asList(PlumbingTypes.values());
    }

    @ModelAttribute("sanitaryOrder")
    public SanitaryShopOrder getSanitaryOrderAttribute() {
        return new SanitaryShopOrder();
    }

    @GetMapping
    public String getSanitaryOrderForm() {
        return "sanitary_order";
    }

    @PostMapping
    public String processOrder(@Valid @ModelAttribute("sanitaryOrder") SanitaryShopOrder sanitaryShopOrder, Errors errors) {
        if (errors.hasErrors()) {
            return "sanitary_order";
        }
        log.info("Sanitary order submitted: " + sanitaryShopOrder);
        return "redirect:/homePage";
    }
}
