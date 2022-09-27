package com.rodin.sanitaryEngineeringShop.repository;

import com.rodin.sanitaryEngineeringShop.model.SanitaryShopOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JDBCSanitaryOrderRepository implements SanitaryShopOrderRepository {

    private final JdbcTemplate jdbcTemplate;

    public JDBCSanitaryOrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public SanitaryShopOrder save(SanitaryShopOrder sanitaryShopOrder) {
        jdbcTemplate.update(
                "INSERT INTO sanitary_shop_order(id, surname, name, patronymic, phone_number, plumbing_Types, cc_number, cc_expiration, cccvv) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                2L,
                sanitaryShopOrder.getSurname(),
                sanitaryShopOrder.getName(),
                sanitaryShopOrder.getPatronymic(),
                sanitaryShopOrder.getPhoneNumber(),
                sanitaryShopOrder.getPlumbingTypes().toString(),
                sanitaryShopOrder.getCcNumber(),
                sanitaryShopOrder.getCcExpiration(),
                sanitaryShopOrder.getCcCVV()
        );
        return sanitaryShopOrder;
    }
}
