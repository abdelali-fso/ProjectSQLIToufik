package org.example.projectstatusqli.service.impl;

import org.example.projectstatusqli.dto.StatusDto;
import org.example.projectstatusqli.dto.StatusDtoSave;
import org.example.projectstatusqli.functions.Builders;
import org.example.projectstatusqli.functions.BuildersImpl;
import org.example.projectstatusqli.functions.CheckIfPresent;
import org.example.projectstatusqli.functions.IsPresent;
import org.example.projectstatusqli.model.Status;
import org.example.projectstatusqli.repository.StatusRepository;
import org.example.projectstatusqli.service.StatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService {
    private static final Logger logger = LoggerFactory.getLogger(StatusServiceImpl.class);
    Builders builders = new BuildersImpl();
    CheckIfPresent check = new IsPresent() ;
    private final StatusRepository statusRepository;
    @Autowired
    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }


    @Override
    public Optional<List<StatusDto>> getAllStatus() {
        try{
            List<Status> statuses = statusRepository.findAll();
            List<StatusDto> statusDtos = statuses.stream()
                    .map(status -> builders.mapToStatusDto(status))
                    .toList();
            return Optional.of(statusDtos);
        }catch (Exception e){
            logger.error("Error in getting all status: " + e.getMessage());
            throw new RuntimeException("Failed to retrieve all status", e);
        }
    }

    @Override
    public void deleteStatus(Long id) {
        try{
            Optional<Status> optionalStatus = statusRepository.findById(id);
            check.isNotPresent(optionalStatus);
            statusRepository.deleteById(id);
            logger.info("Status with id : " + id + " deleted successfully");
        } catch (Exception e) {
            logger.error("Error in deleting status: " + e.getMessage());
            throw new RuntimeException("Failed to delete status", e);
        }
    }

    @Override
    public Optional<StatusDtoSave> addStatus(StatusDto statusDto) {
        try{
            Optional<Status> optionalStatus = statusRepository.findByLibelle(statusDto.getLibelle());
            check.isPresent(optionalStatus);
            Status savedStatus = statusRepository.save(builders.mapToStatus(statusDto));
            logger.info("Status saved successfully");
            return Optional.of(builders.mapToStatusDtoSave(savedStatus));
        }catch (Exception e) {
            logger.error("Error in adding status: " + e.getMessage());
            throw new RuntimeException("Failed to add status", e);
        }
    }

    @Override
    public Optional<StatusDto> updateStatus(Long id, StatusDto statusDto) {
        try {
            Optional<Status> optionalStatus = statusRepository.findById(id);
            check.isNotPresent(optionalStatus);
            Status updatedStatus = statusRepository.save(builders.mapToStatusUpdate(id,statusDto));
            return Optional.of(builders.mapToStatusDto(updatedStatus));
        }catch (Exception e) {
            logger.error("Error in updating status: " + e.getMessage());
            throw new RuntimeException("Failed to updating status", e);
        }
    }


}
