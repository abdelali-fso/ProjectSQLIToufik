package org.example.projectstatusqli.functions;

import org.example.projectstatusqli.dto.*;
import org.example.projectstatusqli.model.Contributeur;
import org.example.projectstatusqli.model.Operation;
import org.example.projectstatusqli.model.Status;


public class BuildersImpl implements Builders  {
    public  StatusDto mapToStatusDto(Status status){
        return StatusDto.builder()
                .libelle(status.getLibelle())
                .build();
    }

    public  StatusDtoSave mapToStatusDtoSave(Status status){
        return StatusDtoSave.builder()
                .id(status.getIdStatus())
                .libelle(status.getLibelle())
                .build();
    }

    public  Status mapToStatus(StatusDto statusDto){
        return Status.builder()
                .libelle(statusDto.getLibelle())
                .build();
    }
    public  Status mapToStatusUpdate(Long id, StatusDto statusDto){
        return Status.builder()
                .idStatus(id)
                .libelle(statusDto.getLibelle())
                .build();
    }
    public  OperationDto mapToOperationDto(Operation operation){
        return OperationDto.builder()
                .libelle(operation.getLibelle())
                .dateCreation(operation.getDateCreation())
                .dateMiseAJour(operation.getDateMiseAJour())
                .status(operation.getStatus())
                .contributeur(operation.getContributeur())
                .build();
    }
    public  Operation mapToOperation(OperationDto operationDto){
        return Operation.builder()
                .libelle(operationDto.getLibelle())
                .dateCreation(operationDto.getDateCreation())
                .dateMiseAJour(operationDto.getDateMiseAJour())
                .status(operationDto.getStatus())
                .contributeur(operationDto.getContributeur())
                .build();
    }

    @Override
    public Operation mapToOperationFromSave(OperationDtoSave operationDtoSave) {
        return Operation.builder()
                .idOperation(operationDtoSave.getId())
                .libelle(operationDtoSave.getLibelle())
                .dateCreation(operationDtoSave.getDateCreation())
                .dateMiseAJour(operationDtoSave.getDateMiseAJour())
                .status(operationDtoSave.getStatus())
                .contributeur(operationDtoSave.getContributeur())
                .build();
    }

    public  OperationDtoSave mapToOperationDtoSave(Operation operation){
        return OperationDtoSave.builder()
                .id(operation.getIdOperation())
                .libelle(operation.getLibelle())
                .dateCreation(operation.getDateCreation())
                .dateMiseAJour(operation.getDateMiseAJour())
                .status(operation.getStatus())
                .contributeur(operation.getContributeur())
                .build();
    }

    public  Operation mapToOperationUpdate(Long id, OperationDto operationDto){
        return Operation.builder()
                .idOperation(id)
                .libelle(operationDto.getLibelle())
                .dateCreation(operationDto.getDateCreation())
                .dateMiseAJour(operationDto.getDateMiseAJour())
                .status(operationDto.getStatus())
                .contributeur(operationDto.getContributeur())
                .build();
    }

    @Override
    public ContributeurDto mapToContributeurDto(Contributeur contributeur) {
        return ContributeurDto.builder()
                .nom(contributeur.getNom())
                .prenom(contributeur.getPrenom())
                .email(contributeur.getEmail())
                .telephone(contributeur.getTelephone())
                .pay(contributeur.getPay())
                .ville(contributeur.getVille())
                .operations(contributeur.getOperations())
                .build();
    }

    @Override
    public ContributeurDtoSave mapToContributeurDtoSave(Contributeur contributeur) {
        return ContributeurDtoSave.builder()
                .id(contributeur.getIdContributeur())
                .nom(contributeur.getNom())
                .prenom(contributeur.getPrenom())
                .email(contributeur.getEmail())
                .telephone(contributeur.getTelephone())
                .pay(contributeur.getPay())
                .ville(contributeur.getVille())
                .operations(contributeur.getOperations())
                .build();
    }

    @Override
    public Contributeur mapToContributeur(ContributeurDto contributeur) {
        return Contributeur.builder()

                .nom(contributeur.getNom())
                .prenom(contributeur.getPrenom())
                .email(contributeur.getEmail())
                .telephone(contributeur.getTelephone())
                .pay(contributeur.getPay())
                .ville(contributeur.getVille())
                .operations(contributeur.getOperations())
                .build();
    }

    @Override
    public Contributeur mapToContributeurUpdate(Long id, ContributeurDto contributeur) {
        return Contributeur.builder()
                .idContributeur(id)
                .nom(contributeur.getNom())
                .prenom(contributeur.getPrenom())
                .email(contributeur.getEmail())
                .telephone(contributeur.getTelephone())
                .pay(contributeur.getPay())
                .ville(contributeur.getVille())
                .operations(contributeur.getOperations())
                .build();
    }


}
