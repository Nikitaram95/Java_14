package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Smartphone smartphone = new Smartphone();

    @Test
    void matches() {
        smartphone.setVendor("Apple");
        String text = "Apple";

        boolean expected = true;
        boolean actual = smartphone.matches(text);

        assertEquals(expected, actual);
    }

    @Test
    void matchesFalse() {
        smartphone.setVendor("Apple");
        String text = "Iphone";

        boolean expected = false;
        boolean actual = smartphone.matches(text);

        assertEquals(expected, actual);
    }
}