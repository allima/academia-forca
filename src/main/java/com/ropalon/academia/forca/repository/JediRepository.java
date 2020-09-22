package com.ropalon.academia.forca.repository;


import com.ropalon.academia.forca.model.Jedi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Long> {

}
