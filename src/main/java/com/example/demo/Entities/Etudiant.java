package com.example.demo.Entities;
import antlr.collections.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Etudiant")
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEtudiant;
    @Column(name = "prenom", length = 30, nullable = false)
    private  String prenom;
    @Column(name = "nom", length = 30, nullable = false)
    private  String nom;

    @Temporal (TemporalType.DATE)
    private Date dateNaissance ;

    @Enumerated(EnumType.ORDINAL)
    private  Option option;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Equipe> equipes ;

@OneToMany(cascade = CascadeType.ALL,mappedBy = "etudiant",fetch = FetchType.EAGER)
    private Set<Contrat> contrats;
@ManyToOne
    Departement departement;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "etudiant")
    @JsonIgnoreProperties({"etudiant"})
    private Set<Experience> experiences;
}
