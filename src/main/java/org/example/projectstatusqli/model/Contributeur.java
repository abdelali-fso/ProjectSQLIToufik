package org.example.projectstatusqli.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contributeur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_contributeur")
    private Long idContributeur;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "emai,")
    private String email;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "pay")
    private String pay;
    @Column(name = "ville")
    private String ville;

    @JsonIgnore
    @OneToMany(mappedBy = "contributeur",cascade = CascadeType.ALL)
    private List<Operation> operations;

}

