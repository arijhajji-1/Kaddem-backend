package com.esprit.first_project.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Equipe implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEquipe;

    private String nomEquipe;

    @Enumerated(EnumType.STRING)
    public Niveau niveau;

    @OneToOne(mappedBy = "equipe")
    private DetailEquipe detail_equipe;

    @ManyToMany(mappedBy = "equipe", cascade = CascadeType.ALL)
    private Set<Etudiant> etudiant;
}