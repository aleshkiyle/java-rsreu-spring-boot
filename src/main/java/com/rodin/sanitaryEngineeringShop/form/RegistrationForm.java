package com.rodin.sanitaryEngineeringShop.form;

import com.rodin.sanitaryEngineeringShop.model.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;

@Data
public class RegistrationForm {

    @NotBlank(message = "Username should not be blank")
    private String username;

    @NotBlank(message = "Password should not be blank")
    private String password;

    public User toUser(PasswordEncoder encoder) {
        return new User(username, encoder.encode(password));
    }
}
