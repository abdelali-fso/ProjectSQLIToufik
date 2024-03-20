package org.example.projectstatusqli.service.impl;

import org.example.projectstatusqli.model.Libelle;
import org.example.projectstatusqli.model.Operation;
import org.example.projectstatusqli.model.Status;
import org.example.projectstatusqli.repository.OperationRepository;
import org.example.projectstatusqli.repository.StatusRepository;
import org.example.projectstatusqli.service.OperationStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OperationStatusServiceImpl implements OperationStatusService {
    static final int UPDATE_TIME = 60000;
    private final OperationRepository operationRepository;
    private final StatusRepository statusRepository;

    @Autowired
    public OperationStatusServiceImpl(OperationRepository operationRepository, StatusRepository statusRepository) {
        this.operationRepository = operationRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    @Scheduled(fixedRate = UPDATE_TIME)
    public void updateStatusAndDateMiseAJour() {
        List<Operation> operations = operationRepository.findAll();
        for (Operation operation : operations) {

            operation.setDateMiseAJour(LocalDateTime.now());
            long nextId =  (operation.getStatus().getIdStatus() + 1) % Libelle.values().length;
            Optional<Status> status = statusRepository.findById(nextId);
            operation.setStatus(status.get());



        }
        operationRepository.saveAll(operations);
    }
}
