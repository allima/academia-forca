package com.ropalon.academia.forca.rest;

import com.ropalon.academia.forca.model.Jedi;
import com.ropalon.academia.forca.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class JediResource {

    @Autowired
    private JediRepository repository;

    @GetMapping("/api/jedi")
    public List<Jedi> getAllJedi() {

        return repository.findAll();

    }

    @GetMapping("/api/jedi/{id}")
    public Jedi getJedi(@PathVariable("id") Long id) {
        Optional<Jedi> jediOp = repository.findById(id);

        Jedi jedi = null;
        if (jediOp.isPresent()) {
            jedi= jediOp.get();
        }
        return jedi;
    }
}
