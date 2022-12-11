package com.example.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Universite")
public class Universite implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUniv;
    @Column(name = "nomUniv", length = 30, nullable = false)
    private  String nomUniv;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Departement> departements;
}
