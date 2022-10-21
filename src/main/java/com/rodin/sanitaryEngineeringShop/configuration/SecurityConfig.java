package com.rodin.sanitaryEngineeringShop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable();

        httpSecurity.authorizeHttpRequests().antMatchers("/login").permitAll();
        httpSecurity.authorizeHttpRequests().antMatchers(HttpMethod.GET, "/sanitary_order")
                .hasAnyAuthority("ROLE_USER");
        httpSecurity.authorizeHttpRequests().antMatchers(HttpMethod.POST, "/sanitary_order")
                .hasAnyAuthority("ROLE_USER");
        httpSecurity.authorizeHttpRequests().anyRequest().permitAll();

        httpSecurity.formLogin().loginPage("/login");
        httpSecurity.formLogin().failureUrl("/login-error");
        httpSecurity.logout().logoutSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }


    // Объявление bean-компонента PasswordEncoder,
    // который му быдем использовать при создании новых пользователей
    // и при аутентификации.
    @SuppressWarnings("deprecation")
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder(); // применяет надёжное шифрования bcrypt;
    }
}
