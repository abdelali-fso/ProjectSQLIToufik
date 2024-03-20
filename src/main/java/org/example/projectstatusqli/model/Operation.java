package org.example.projectstatusqli.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_operation")
    private Long idOperation;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "date_creation")
    private LocalDateTime dateCreation;
    @Column(name = "date_mise_a_jour")
    private LocalDateTime dateMiseAJour;

    @ManyToOne
    @JoinColumn(name = "id_contributeur")
    private Contributeur contributeur;

    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status status;
}
