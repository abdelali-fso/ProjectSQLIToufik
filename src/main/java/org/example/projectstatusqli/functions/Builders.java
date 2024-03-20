package org.example.projectstatusqli.functions;

import org.example.projectstatusqli.dto.*;
import org.example.projectstatusqli.model.Contributeur;
import org.example.projectstatusqli.model.Operation;
import org.example.projectstatusqli.model.Status;

public interface Builders {
    StatusDto mapToStatusDto(Status status);
    StatusDtoSave mapToStatusDtoSave(Status status);
    Status mapToStatus(StatusDto statusDto);
    Status mapToStatusUpdate(Long id, StatusDto statusDto);
    OperationDto mapToOperationDto(Operation operation);
    Operation mapToOperation(OperationDto operationDto);
    Operation mapToOperationFromSave(OperationDtoSave operationDtoSave);
    OperationDtoSave mapToOperationDtoSave(Operation operation);
    Operation mapToOperationUpdate(Long id, OperationDto operationDto);
    ContributeurDto mapToContributeurDto(Contributeur contributeur);
    ContributeurDtoSave mapToContributeurDtoSave(Contributeur contributeur);
    Contributeur mapToContributeur(ContributeurDto contributeurDto);
    Contributeur mapToContributeurUpdate(Long id,ContributeurDto contributeurDto);

}
