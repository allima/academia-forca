package com.ropalon.academia.forca.repository;


import com.ropalon.academia.forca.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JediRepository {
    private List<Jedi> jedi ;

    public JediRepository() {
        jedi = new ArrayList<>();
        this.jedi.add(new Jedi("Luke","Skaywalker"));
    }

    public List<Jedi> getAllJedi(){
        return this.jedi;
    }

    public void add(Jedi jedi) {
        this.jedi.add(jedi);

    }
}
