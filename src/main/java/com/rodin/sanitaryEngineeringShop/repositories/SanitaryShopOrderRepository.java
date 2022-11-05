package com.rodin.sanitaryEngineeringShop.repositories;

import com.rodin.sanitaryEngineeringShop.model.SanitaryShopOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SanitaryShopOrderRepository extends
        MongoRepository<SanitaryShopOrder, Long> {


}
