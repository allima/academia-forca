package com.ropalon.academia.forca.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculoTest {

    @Test
    void soma() {
        Calculo cal = new Calculo();
        assertEquals(5, cal.soma(2,3));
    }
}