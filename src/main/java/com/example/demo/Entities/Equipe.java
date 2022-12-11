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
@Table(name = "Equipe")
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEquipe;

    @Column(name = "nomEquipe", length = 30, nullable = false)
    private  String nomEquipe;

    @Enumerated(EnumType.ORDINAL)
    private  Niveau niveau;

   @ManyToMany(cascade = CascadeType.ALL,mappedBy = "equipes")
    private Set<Etudiant> etudiants;

   @OneToOne
    private DetailEquipe equipeDetail;

}
