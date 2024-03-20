package org.example.projectstatusqli.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.projectstatusqli.model.Libelle;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusDto {
    private Libelle libelle;
}
