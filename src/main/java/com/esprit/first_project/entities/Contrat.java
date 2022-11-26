package com.esprit.first_project.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Contrat implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContrat;

    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;

    @Temporal(TemporalType.DATE)
    private Date dateFinContrat;

    private Boolean archive;
    private Integer montantContrat;

    @Enumerated(EnumType.STRING)
    public Specialite specialite;

    @ManyToOne
    private Etudiant etudiant;
}