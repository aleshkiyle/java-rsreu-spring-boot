package com.rodin.sanitaryEngineeringShop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;

@Data
@Slf4j
@AllArgsConstructor
public class SanitaryShopOrder {

    private Long id;

    public SanitaryShopOrder() {

    }

    @NotBlank(message = "Surname is required")
    private String surname;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Patronymic is required")
    private String patronymic;

    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$",
            message = "Not a valid phone number")
    private String phoneNumber;

    @Size(min = 1, message = "Pick sny plumbing types")
    private Collection<PlumbingTypes> plumbingTypes;

    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])(/)([1-9][0-9])$",
            message = "Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

}
