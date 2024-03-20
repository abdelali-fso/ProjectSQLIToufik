package org.example.projectstatusqli.service.impl;

import org.example.projectstatusqli.dto.OperationDto;
import org.example.projectstatusqli.dto.OperationDtoSave;
import org.example.projectstatusqli.functions.Builders;
import org.example.projectstatusqli.functions.BuildersImpl;
import org.example.projectstatusqli.functions.CheckIfPresent;
import org.example.projectstatusqli.functions.IsPresent;
import org.example.projectstatusqli.model.Operation;
import org.example.projectstatusqli.repository.OperationRepository;
import org.example.projectstatusqli.service.OperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperationServiceImpl implements OperationService {

    private static final Logger logger = LoggerFactory.getLogger(OperationServiceImpl.class);
    Builders builders = new BuildersImpl();
    CheckIfPresent check = new IsPresent() ;
    private final OperationRepository operationRepository;
    @Autowired
    public OperationServiceImpl(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }


    @Override
    public Optional<List<OperationDtoSave>> getAllOperations() {
        try{
            List<Operation> operations = operationRepository.findAll();
            List<OperationDtoSave> operationDtos = operations.stream()
                    .map(operation -> builders.mapToOperationDtoSave(operation))
                    .toList();
            return Optional.of(operationDtos);
        }catch (Exception e){
            logger.error("Error in getting all operations: " + e.getMessage());
            throw new RuntimeException("Failed to retrieve all opertation", e);
        }
    }

    @Override
    public void deleteOpertation(Long id) {
        try{
            Optional<Operation> optionalOperation = operationRepository.findById(id);
            check.isNotPresent(optionalOperation);
            operationRepository.deleteById(id);
            logger.info("Operation with id : " + id + " deleted successfully");
        } catch (Exception e) {
            logger.error("Error in deleting operation: " + e.getMessage());
            throw new RuntimeException("Failed to delete operation", e);
        }
    }

    @Override
    public Optional<OperationDtoSave> addOperation(OperationDto operationDto) {
        try{
            Operation savedOperation = operationRepository.save(builders.mapToOperation(operationDto));
            logger.info("Operation saved successfully");
            return Optional.of(builders.mapToOperationDtoSave(savedOperation));
        }catch (Exception e) {
            logger.error("Error in adding operation: " + e.getMessage());
            throw new RuntimeException("Failed to add opertaion", e);
        }
    }

    @Override
    public Optional<OperationDto> updateOperation(Long id, OperationDto operationDto) {
        try{
            Optional<Operation> optionalOperation = operationRepository.findById(id);
            check.isNotPresent(optionalOperation);
            Operation updatedOperation = operationRepository.save(builders.mapToOperationUpdate(id,operationDto));
            logger.info("Operation updated successfully");
            return Optional.of(builders.mapToOperationDto(updatedOperation));
        }catch (Exception e) {
            logger.error("Error in updating operation: " + e.getMessage());
            throw new RuntimeException("Failed to updating operation", e);
        }
    }


}
