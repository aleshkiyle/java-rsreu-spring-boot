package com.rodin.sanitaryEngineeringShop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    // Объявление bean-компонента PasswordEncoder, который му быдем использовать при создании новых пользователей
    // и при аутентификации.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // применяет надёжное шифрования bcrypt;
    }
}
