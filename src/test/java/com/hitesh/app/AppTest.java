package com.hitesh.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    void addsTwoNumbers() {
        assertEquals(5, new App().add(2, 3));
    }

    @Test
    void addsNegativeNumbers() {
        assertEquals(-1, new App().add(2, -3));
    }
}
