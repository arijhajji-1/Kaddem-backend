package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Contrat")

public class Contrat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContrat;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateFinContrat", nullable = false)


    private Date dateFinContrat;
    private Date dateDebutContrat;
    private boolean archive;

    private int montantContrat;

    @Enumerated(EnumType.ORDINAL)
    private Specialite specialite;
    @JsonIgnoreProperties({"etudiant"})

    @ManyToOne
    Etudiant etudiant;


}
