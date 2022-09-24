package com.rodin.sanitaryEngineeringShop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.EnumSet;

@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SanitaryShopOrder {

    @NotBlank(message = "Name is required")
    private String name;

    @Size(min = 1, message = "Pick sny plumbing types")
    private EnumSet<PlumbingTypes> plumbingTypes = EnumSet.noneOf(PlumbingTypes.class);

    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])(/)([1-9][0-9])$",
            message = "Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

}
