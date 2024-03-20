package org.example.projectstatusqli.service;

import org.example.projectstatusqli.dto.OperationDto;
import org.example.projectstatusqli.dto.OperationDtoSave;

import java.util.List;
import java.util.Optional;

public interface OperationService {
    Optional<List<OperationDtoSave>> getAllOperations();
    void deleteOpertation(Long id);
    Optional<OperationDtoSave> addOperation(OperationDto operationDto);
    Optional<OperationDto> updateOperation(Long id,OperationDto operationDto);
}
