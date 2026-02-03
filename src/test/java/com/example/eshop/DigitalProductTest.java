package com.example.eshop;

import com.example.eshop.product.DigitalProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DigitalProductTest {

    void createNewDigitalProduct() {
        String name = "E-Book Java 2025";
        String description = "Best guide for JUnit 5";
        BigDecimal price = new BigDecimal("49.99");
        String url = "https://www.google.com";

        DigitalProduct newDigitalProduct = new DigitalProduct(name, description, price, url);

        assertAll("Verify product attributes",
                () -> assertEquals(name,newDigitalProduct.getName(), "Name should match"),
                () -> assertEquals(description,newDigitalProduct.getDescription(),"Description should match"),
                () -> assertEquals(price,newDigitalProduct.getPrice(), "Price should match"),
                () -> assertEquals(url,newDigitalProduct.getDownloadUrl(), "Download url should match"));
    }
}
