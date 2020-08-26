package com.ropalon.academia.forca.repository;

import com.ropalon.academia.forca.model.Jedi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JediRepositoryTest {
    @Autowired
    private JediRepository controller;

    @Test
    void getAllJediComSucesso() {
        assertThat(controller.getAllJedi()).isNotNull();
    }

    @Test
    void addComSucesso() {
        controller.add(new Jedi());
        Assertions.assertEquals(controller.getAllJedi().size(),2);
    }
}