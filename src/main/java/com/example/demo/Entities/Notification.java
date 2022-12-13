package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter

@NoArgsConstructor
public class Notification implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNotif ;
    private String message ;
    private Boolean isSeen;
    @ManyToOne()
    @JoinColumn(name = "idEtudiant")
    @JsonIgnoreProperties({"notifications"})
    Etudiant etudiant ;

    public Notification(String message, Etudiant etudiant) {
        this.message = message;
        this.etudiant = etudiant;
        this.isSeen = false;
    }
    public Notification(String message) {
        this.message = message;
        this.isSeen = false;
    }
}
