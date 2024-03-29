package com.ropalon.academia.forca.rest;

import com.ropalon.academia.forca.model.Jedi;
import com.ropalon.academia.forca.repository.JediRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<Jedi> getJedi(@PathVariable("id") Long id) {
        final Optional<Jedi> jediOp = repository.findById(id);
        ResponseEntity jedi;
        if (jediOp.isPresent()) {
            jedi = ResponseEntity.ok(jediOp.get());
        }else {
            jedi = ResponseEntity.notFound().build();
        }
        return jedi;
    }
    @PostMapping("/api/jedi")
    public Jedi createJedi(@Valid @RequestBody Jedi jedi){
        return repository.save(jedi);
    }
}
