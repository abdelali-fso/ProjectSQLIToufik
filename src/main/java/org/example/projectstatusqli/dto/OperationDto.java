package org.example.projectstatusqli.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.projectstatusqli.model.Contributeur;
import org.example.projectstatusqli.model.Status;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperationDto {
    private String libelle;
    private LocalDateTime dateCreation;
    private LocalDateTime dateMiseAJour;
    private Status status;
    private Contributeur contributeur;
}
