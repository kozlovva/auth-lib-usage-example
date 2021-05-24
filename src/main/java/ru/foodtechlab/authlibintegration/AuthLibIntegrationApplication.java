package ru.foodtechlab.authlibintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableGlobalMethodSecurity(securedEnabled = true)
@SpringBootApplication(scanBasePackages = {"com.rcore", "ru.foodtechlab"})
public class AuthLibIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthLibIntegrationApplication.class, args);
    }

}
