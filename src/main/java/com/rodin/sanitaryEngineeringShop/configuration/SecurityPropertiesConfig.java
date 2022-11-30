package com.rodin.sanitaryEngineeringShop.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "security")
public class SecurityPropertiesConfig {

    private String loginPageUrl;
}
