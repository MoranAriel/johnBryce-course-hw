package com.john.bryce.catsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.john.bryce.catsystem.entities.Toy;

@Repository
public interface ToyRepo extends JpaRepository<Toy, Integer> {
  List<Toy> findByName(String name);

  boolean existsByName(String name);

  void deleteByName(String name);

}
