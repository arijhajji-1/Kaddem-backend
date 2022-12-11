package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DetailEquipe")
public class DetailEquipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDetailEquipe")
    private Integer idDetailEquipe; // Clé primaire
    private Integer salle;
    private String thematique;

    ////
    private String commentaire;

    @OneToOne(cascade = CascadeType.REMOVE,mappedBy = "detaileq")
    @JsonIgnore
    private Equipe equipe;
}
