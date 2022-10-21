package com.rodin.sanitaryEngineeringShop.form;

import com.rodin.sanitaryEngineeringShop.model.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;

@Data
public class RegistrationForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public User toUser(PasswordEncoder encoder) {
        return new User(this.username, encoder.encode(this.password));
    }
}
