package tn.esprit.firstproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.org.apache.xpath.internal.operations.Bool;
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
