package com.john.bryce.catsystem.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.john.bryce.catsystem.entities.Cat;
import com.john.bryce.catsystem.exceptions.CatSystemException;
import com.john.bryce.catsystem.services.CatService;

@RestController
@RequestMapping("api/cats")
@CrossOrigin
public class CatController {

  private final CatService catService;

  public CatController(CatService catService) {
    this.catService = catService;
  }

  /*
   * 200 - 299 Good (200 = OK, 201 = Create, 204 No Content)
   * 300 - 399 Proccessing
   * 400 - 499 Client Error
   * 500 -599 Server Error
   * 
   * 
   * 3 ways to get data from request
   * PathVariable - id/primray Key
   * RequestParam - name/weight/birthday
   * RequestBody - object
   */

  //  request in postman example
  // http://localhost:8080/api/cats

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void addCat(@RequestBody Cat cat) {
    catService.addCat(cat);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateCat(@RequestBody Cat cat) throws CatSystemException {
    catService.updateCat(cat);
  }

  @DeleteMapping("/{catId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCat(@PathVariable int catId) throws CatSystemException {
    catService.deleteCat(catId);
  }


  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Cat> getAllCats() {
    return catService.getAllCats();
  }

  @GetMapping("/{catId}")
  public Cat getSingleCat(@PathVariable int catId) throws CatSystemException {
    return catService.getSingleCat(catId);
  }


  @GetMapping("/by-name-and-weight")
  public List<Cat> getAllCatsByNameAndWeight(@RequestParam String name, @RequestParam double weight) throws CatSystemException {
    return catService.getAllCatsByNameAndWeight(name, weight);
  }

  @GetMapping("/by-name-or-weight")
  public List<Cat> getAllCatsByNameOrWeight(@RequestParam String name, @RequestParam double weight) throws CatSystemException {
    return catService.getAllCatsByNameOrWeight(name, weight);
  }


}
