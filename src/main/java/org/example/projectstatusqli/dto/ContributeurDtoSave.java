package org.example.projectstatusqli.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.projectstatusqli.model.Operation;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContributeurDtoSave {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String pay;
    private String ville;

    private List<Operation> operations;
}
