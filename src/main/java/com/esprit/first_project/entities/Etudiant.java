package com.esprit.first_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Etudiant  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEtudiant;

    private String prenomE;
    private String nomE;

    @Enumerated(EnumType.STRING)
    public Option option;

    @OneToMany(mappedBy = "etudiant")
    private Set<Contrat> contrat;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Departement departement;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Set<Equipe> equipe;
}