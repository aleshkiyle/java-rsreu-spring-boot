package com.rodin.sanitaryEngineeringShop.configuration;

import com.rodin.sanitaryEngineeringShop.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Configuration
public class SecurityConfig {

    // Объявление bean-компонента PasswordEncoder, который му быдем использовать при создании новых пользователей
    // и при аутентификации.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // применяет надёжное шифрования bcrypt;
    }

    @Bean
    public UserDetailService userDetailService(PasswordEncoder passwordEncoder) {
        List<UserDetails> usersList = new ArrayList<>();
        usersList.add(
                new User("aleshkiyle", passwordEncoder.encode("password"),
                        List.of(new SimpleGrantedAuthority("ROLE_USER"))));
        usersList.add(
                new User("frs717", passwordEncoder.encode("password"),
                        List.of(new SimpleGrantedAuthority("ROLE_USER"))));
        return (UserDetailService) new InMemoryUserDetailsManager(usersList);
    }

    @Bean
    public UserDetailService userDetailService(UserRepository userRepository) {
        return userName -> {
            Optional<com.rodin.sanitaryEngineeringShop.model.User> user = userRepository.findByUserName(userName);
            if (user.isPresent()) {
                return user.get();
            } else {
                throw new UsernameNotFoundException("User " + userName + " not found");
            }
        };
    }
}
