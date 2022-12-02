package com.rodin.sanitaryEngineeringShop;

import com.rodin.sanitaryEngineeringShop.model.PlumbingTypes;
import com.rodin.sanitaryEngineeringShop.model.SanitaryShopOrder;
import com.rodin.sanitaryEngineeringShop.repository.SanitaryShopOrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class SanitaryEngineeringShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SanitaryEngineeringShopApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(SanitaryShopOrderRepository sanitaryShopOrderRepository) {
        return args -> {
            sanitaryShopOrderRepository.save(new SanitaryShopOrder(
                    -1L, "Родин", "Алексей", "Викторович", "89206315859",
                    Collections.singleton(PlumbingTypes.MIXES),
                    "5536914161452937", "07/30", "489"));
            sanitaryShopOrderRepository.save(new SanitaryShopOrder(
                    -1L, "Сёмин", "Иван", "Дмитриевич", "89585663421",
                    Collections.singleton(PlumbingTypes.TOILETS),
                    "4374952605776329", "02/27", "669"));
        };
    }
}
