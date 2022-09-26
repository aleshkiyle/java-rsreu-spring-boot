package com.rodin.sanitaryEngineeringShop;

import com.rodin.sanitaryEngineeringShop.configuration.JDBCPostgreConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SanitaryEngineeringShopApplication implements CommandLineRunner {

    private final JDBCPostgreConfig jdbcPostgreConfig;

    public SanitaryEngineeringShopApplication(JDBCPostgreConfig jdbcPostgreConfig) {
        this.jdbcPostgreConfig = jdbcPostgreConfig;
    }

    public static void main(String[] args) {
        SpringApplication.run(SanitaryEngineeringShopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        jdbcPostgreConfig.addStudent();
    }
}
