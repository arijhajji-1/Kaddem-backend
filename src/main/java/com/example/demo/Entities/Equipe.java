package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
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
    @Column(name="idEquipe")
    private Integer idEquipe; // Clé primaire
    private String nomEquipe;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;


    //////
    private String mail;

    private String logo;

    private Integer nbrDesMembresMax;






    //////

    @OneToOne
    private DetailEquipe detaileq;

    @ManyToMany
    @JsonIgnore
    private List<Etudiant> etuds;

}
