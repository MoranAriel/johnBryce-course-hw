package com.john.bryce.catsystem.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.john.bryce.catsystem.entities.Cat;
import com.john.bryce.catsystem.exceptions.CatSystemException;
import com.john.bryce.catsystem.repositories.CatRepo;

@Service
// @RequiredArgsConstructor
public class CatService {

  // field injection Bad!!!
  // @Autowired
  // private CatRepo catRepo;

  // Custructor Injection Good!!!
  // private final CatRepo catRepo;

  private final CatRepo catRepo;

  // @Autowired
  public CatService(CatRepo catRepo) {
    this.catRepo = catRepo;
  }

  @Transactional
  public void addCat(Cat cat) {
    catRepo.save(cat);
  }

  @Transactional
  public void updateCat(Cat cat) throws CatSystemException {
    Cat catFromDb = catRepo.findById(cat.getId()).orElseThrow(() -> new CatSystemException("Cat id not found"));
    catFromDb.setName(cat.getName());
    catFromDb.setWeight(cat.getWeight());
    catFromDb.setBirthday(cat.getBirthday());
    // catRepo.save(catFromDb);
  }

  @Transactional
  public void deleteCat(int catId) throws CatSystemException {
    if (!catRepo.existsById(catId)) {
      throw new CatSystemException("Cat id not found");
    }
    catRepo.deleteById(catId);
  }

  public List<Cat> getAllCats() {
    return catRepo.findAll();
  }

  public Cat getSingleCat(int catId) throws CatSystemException {
    Cat catFromDb = catRepo.findById(catId).orElseThrow(() -> new CatSystemException("Cat id not found"));
    return catFromDb;
  }

  public List<Cat> getAllCatsByNameAndWeight(String name, double weight) throws CatSystemException {
    if (weight <= 0) {
      throw new CatSystemException("cat weight can not be blow or equal to 0");
    }
    return catRepo.findByNameAndWeight(name, weight);
  }

  public List<Cat> getAllCatsByNameOrWeight(String name, double weight) throws CatSystemException {
    if (weight <= 0) {
      throw new CatSystemException("cat weight can not be blow or equal to 0");
    }
    return catRepo.findByNameOrWeight(name, weight);
  }

  public List<Cat> getAllCatsNameStartingWith(String startWith) throws CatSystemException {
    if (startWith.length() > 50) {
      throw new CatSystemException("Cat name can not be longer then 50 characters");
    }
    return catRepo.findByNameStartingWith(startWith);
  }

  public double getWeightAvg() {
    return catRepo.getWeightAvg();
  }

}
