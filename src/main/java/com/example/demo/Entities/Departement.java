package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "Departement")
public class Departement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepart;
    @Column(name = "nomDepart", length = 30, nullable = false)
    private  String nomDepart;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "departement")
    private Set<Etudiant> etudiants;
}
