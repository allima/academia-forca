package com.ropalon.academia.forca.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JediTest {

    @Test
    void testSetForeignWord() {
        Jedi card = new Jedi();
        card.setName("test");
        card.setLastName("test");
        assertEquals("test", card.getName());
        assertEquals("test", card.getLastName());
    }

    @Test
    void testConstrutorJedi() {
        Jedi card = new Jedi("test", "test");
        card.setId(1L);
        assertEquals("test", card.getName());
        assertEquals("test", card.getLastName());
        assertEquals(1L, card.getId());

    }

}