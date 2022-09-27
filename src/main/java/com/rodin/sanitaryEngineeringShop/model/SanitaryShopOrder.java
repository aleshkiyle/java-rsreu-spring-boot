package com.rodin.sanitaryEngineeringShop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Data
@Slf4j
@AllArgsConstructor
@Table(name = "sanitaryShopOrder")
public class SanitaryShopOrder {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public SanitaryShopOrder() {

    }

    @Column(name = "surname")
    @NotBlank(message = "Surname is required")
    private String surname;

    @Column(name = "name")
    @NotBlank(message = "Name is required")
    private String name;

    @Column(name = "patronymic")
    @NotBlank(message = "Patronymic is required")
    private String patronymic;

    @Column(name = "phoneNumber")
    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$",
            message = "Not a valid phone number")
    private String phoneNumber;

    @ElementCollection(targetClass = PlumbingTypes.class)
    @Column(name = "plumbingTypes", nullable = false)
    @Enumerated(EnumType.STRING)
    @Size(min = 1, message = "Pick sny plumbing types")
    private Collection<PlumbingTypes> plumbingTypes;

    @Column(name = "ccNumber")
    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;

    @Column(name = "ccExpiration")
    @Pattern(regexp = "^(0[1-9]|1[0-2])(/)([1-9][0-9])$",
            message = "Must be formatted MM/YY")
    private String ccExpiration;

    @Column(name = "ccCVV")
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

}
