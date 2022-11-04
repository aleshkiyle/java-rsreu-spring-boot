package com.rodin.sanitaryEngineeringShop;

import com.rodin.sanitaryEngineeringShop.model.SanitaryShopOrder;
import com.rodin.sanitaryEngineeringShop.repository.SanitaryShopOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@Slf4j
public class SanitaryEngineeringShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SanitaryEngineeringShopApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(SanitaryShopOrderRepository
                                                       sanitaryShopOrderRepository) {
        return args -> {
            sanitaryShopOrderRepository.deleteAll();
            SanitaryShopOrder shopOrder1 = SanitaryShopOrder.builder()
                    .surname("Rodin")
                    .name("Alexey")
                    .patronymic("Viktorovich")
                    .phoneNumber("89585116132")
                    .ccNumber("4779297759275053")
                    .ccExpiration("10/25")
                    .ccCVV("351")
                    .build();
            SanitaryShopOrder shopOrder2= SanitaryShopOrder.builder()
                    .surname("Ivanov")
                    .name("Andrew")
                    .patronymic("Aleksandrovich")
                    .phoneNumber("89165341029")
                    .ccNumber("4694907065270398")
                    .ccExpiration("05/26")
                    .ccCVV("901")
                    .build();
            SanitaryShopOrder saveOrder1 = sanitaryShopOrderRepository.save(shopOrder1);
            SanitaryShopOrder saveOrder2 = sanitaryShopOrderRepository.save(shopOrder2);
            List<SanitaryShopOrder> orders = sanitaryShopOrderRepository.findAll();
            orders.forEach(order -> log.info("Sanitary order: {}" + order.getId()));
            sanitaryShopOrderRepository.findById(saveOrder1.getId())
                    .ifPresent(order -> log.info("Sanitary order: {}" + order.getName()));
        };
    }
}
