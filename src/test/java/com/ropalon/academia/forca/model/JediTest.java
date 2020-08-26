package com.ropalon.academia.forca.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JediTest {

    @Test
    public void testSetForeignWord() {
        Jedi card = new Jedi();
        card.setName("test");
        card.setLastName("test");
        assertTrue(card.getName() == "test");
        assertTrue(card.getLastName() == "test");
    }


}