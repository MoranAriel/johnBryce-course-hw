package com.john.bryce.catsystem;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.john.bryce.catsystem.entities.Cat;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class CatSystemApplication {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(CatSystemApplication.class, args);
    System.out.println(" Cat System is running ");

    RestTemplate restTemplate = new RestTemplate();
    final String URL = "http://localhost:8080/api/cats";

    Cat cat = new Cat(0, "Rose", 15.5, LocalDate.now(), null);
    Cat cat2 = new Cat(0, "Moshe", 15.5, LocalDate.now(), null);
    Cat cat3 = new Cat(0, "Shmil", 15.5, LocalDate.now(), null);

    ResponseEntity<Void> re = restTemplate.exchange(URL, HttpMethod.POST, new HttpEntity<>(cat), Void.class);

    restTemplate.exchange(URL, HttpMethod.POST, new HttpEntity<>(cat2), Void.class);

    restTemplate.exchange(URL, HttpMethod.POST, new HttpEntity<>(cat3), Void.class);

    System.out.println("Create cat successfully " + re.getStatusCode());

    System.out.println("-----------------------------------------------------");

    cat.setId(1);
    cat.setName("Rosa");
    cat.setWeight(25);
    ResponseEntity<Void> re2 = restTemplate.exchange(URL, HttpMethod.PUT, new HttpEntity<>(cat), Void.class);
    System.out.println("Update cat successfully " + re2.getStatusCode());


    System.out.println("-----------------------------------------------------");


    ResponseEntity<Void> re3 = restTemplate.exchange(URL + "/1", HttpMethod.DELETE, null, Void.class);
    System.out.println("Delete cat successfully " + re3.getStatusCode());

    System.out.println("-----------------------------------------------------");

    List<Cat> mycats;

    ResponseEntity<List<Cat>> re4 = restTemplate.exchange(
      URL, 
      HttpMethod.GET, 
      null, 
      ParameterizedTypeReference.forType(List.class)
    );
    System.out.println("All cats successfully \n" + re4.getBody());

    System.out.println("-----------------------------------------------------");

    ResponseEntity<List<Cat>> re5 = restTemplate.exchange(
      URL + " /by-name-or-weight?name=rose&weight=15.5", 
      HttpMethod.GET, 
      null, 
      ParameterizedTypeReference.forType(List.class)
    );
    System.out.println("All cats by name or weight successfully \n" + re5.getBody());

    System.out.println("-----------------------------------------------------");
    ResponseEntity<Cat> re6 = restTemplate.exchange(
      URL+"/2", 
      HttpMethod.GET, 
      null, 
      Cat.class
    );
    System.out.println("Cat successfully \n" + re6.getBody());


    // 
    // Cat cat = new Cat(0, "Rose", 15.5, LocalDate.now(), null);

    // CatRepo catRepo = ctx.getBean(CatRepo.class);
    // ToyRepo toyRepo = ctx.getBean(ToyRepo.class);

    // CatService catService = ctx.getBean(CatService.class);

    // Cat cat1 =
    // Cat.builder().id(0).name("Rose").weight(10).birthday(LocalDate.now()).build();

    // Toy toy1 = Toy.builder().id(0).name("ball red").cat(cat1).build();
    // Toy toy2 = Toy.builder().id(0).name("ball blue").cat(cat1).build();

    // cat1.setToys(Arrays.asList(toy1, toy2));

    // catRepo.save(cat1);

    // // catRepo.delete(cat1);

    // cat1.setName("Mitzi");
    // try {
    // catService.updateCat(cat1);
    // } catch (CatSystemException e) {
    // e.printStackTrace();
    // }

  }

}
