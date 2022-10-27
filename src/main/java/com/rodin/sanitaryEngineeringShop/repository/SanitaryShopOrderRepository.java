package com.rodin.sanitaryEngineeringShop.repository;

import com.rodin.sanitaryEngineeringShop.model.SanitaryShopOrder;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface SanitaryShopOrderRepository
        extends CassandraRepository<SanitaryShopOrder, Long> {

    @AllowFiltering
    List<SanitaryShopOrder> findBySurname(String surname);
}
