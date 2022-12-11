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
@Table(name = "Experience")

public class Experience implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExperience;

    @Column(name = "type")
    private  String type;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateDebutExperience")
    private Date dateDebutExperience;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateFinExperience")
    private Date dateFinExperience;


    @Column(name = "descriptif")
    private  String descriptif;

    @Column(name = "TitreDuProfil")
    private  String TitreDuProfil;

    @Column(name = "lieu")
    private  String lieu;
    @JsonIgnoreProperties({"etudiant"})
    @ManyToOne
    Etudiant etudiant;


}
