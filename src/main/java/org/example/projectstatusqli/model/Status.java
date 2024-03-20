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
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_status")
    private Long idStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "libelle")
    private Libelle libelle;

    @JsonIgnore
    @OneToMany(mappedBy = "status",cascade = CascadeType.ALL)
    private List<Operation> operations;

    public Status(Long idStatus, Libelle libelle) {
        this.idStatus = idStatus;
        this.libelle = libelle;
    }
}
