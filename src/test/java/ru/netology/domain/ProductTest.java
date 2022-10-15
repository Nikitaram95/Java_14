package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product product = new Product();

    @Test
    void matches() {
        product.setName("Iphone");
        String text = "Iphone";

        boolean expected = true;
        boolean actual = product.matches(text);

        assertEquals(expected, actual);
    }

    @Test
    void matchesFalse() {
        product.setName("Make");
        String text = "Iphone";

        boolean expected = false;
        boolean actual = product.matches(text);

        assertEquals(expected, actual);
    }
}