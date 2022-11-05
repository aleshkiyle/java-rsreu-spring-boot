package com.rodin.sanitaryEngineeringShop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;

@Data
@AllArgsConstructor
@Builder
@Table(name = "sanitary_shop_order")
public class SanitaryShopOrder {

    @PrimaryKeyColumn
            (name = "id",
            type = PrimaryKeyType.PARTITIONED,
            ordering = Ordering.ASCENDING)
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

    @Column(name = "phone_number")
    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$",
            message = "Not a valid phone number")
    private String phoneNumber;

    @Column(name = "plumbingTypes")
    @Size(min = 1, message = "Pick sny plumbing types")
    private Collection<PlumbingTypes> plumbingTypes;

    @Column(name = "ccNumber")
    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;

    @Column(name = "ccExpiration")
    @Pattern(regexp = "^(0[1-9]|1[0-2])(/)([1-9][0-9])$",
            message = "Must be formatted MM/YY")
    private String ccExpiration;

    @Column(name = "ccCvv")
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

}
