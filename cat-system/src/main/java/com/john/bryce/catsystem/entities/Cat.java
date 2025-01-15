package com.john.bryce.catsystem.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cats")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Cat {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private double weight;
  private LocalDate birthday;
  // @Enumerated(EnumType.STRING)
  // private Color color;
  // @OneToMany | @OneToOne | ManyToOne |  @ManyToMany
  // @OneToMany(mappedBy = "cat", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @OneToMany(mappedBy = "cat", cascade = CascadeType.ALL, orphanRemoval = true)
  @ToString.Exclude
  @JsonIgnore
  private List<Toy> toys;
}
