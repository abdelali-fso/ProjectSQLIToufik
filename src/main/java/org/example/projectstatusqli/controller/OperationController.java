package org.example.projectstatusqli.controller;

import org.example.projectstatusqli.dto.OperationDto;
import org.example.projectstatusqli.dto.OperationDtoSave;
import org.example.projectstatusqli.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/operation")
public class OperationController {
    private final OperationService operationService;
    @Autowired
    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping
    public Optional<List<OperationDtoSave>> getAllOperations(){
        return operationService.getAllOperations();
    }
    @DeleteMapping("/{id}")
    public void deleteOperatin(@PathVariable Long id){
        operationService.deleteOpertation(id);
    }
    @PostMapping
    public Optional<OperationDtoSave> addOperation(@RequestBody OperationDto operationDto){
        return operationService.addOperation(operationDto);
    }
    @PutMapping("/{id}")
    public Optional<OperationDto> updateOperation(@PathVariable Long id,@RequestBody OperationDto operationDto){
        return operationService.updateOperation(id,operationDto);
    }
}
