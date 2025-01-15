package com.john.bryce.catsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.john.bryce.catsystem.entities.Cat;

// 50% Extends Jpa Repository (All or id)
@Repository
public interface CatRepo extends JpaRepository<Cat, Integer> {

  // 40% Derived Query
  List<Cat> findByNameAndWeight(String name, double weight);

  List<Cat> findByNameOrWeight(String name, double weight);

  List<Cat> findAllByOrderByWeightDesc();

  List<Cat> findByNameStartingWith(String startWith);

  // List<Cat> findByColor(Color color);

  // @Query(value = "SELECT FROM cats WHERE color = ?;", nativeQuery = true)
  // List<Cat> findByColorQuery(String color);

  @Query(value = "SELECT AVG(weight) FROM cats;", nativeQuery = true)
  double getWeightAvg();
  // List<Cat> findByName(String name);
  // boolean existsByName(String name);
  // void deleteByName(String name);

  // 10% Native Query
  // @Query(value = "Delete from cats Join... ", nativeQuery = true)
  // void deleteCatsByToyId(int toyId);

}
