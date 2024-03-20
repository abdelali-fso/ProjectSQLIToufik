package org.example.projectstatusqli.controller;

import org.example.projectstatusqli.dto.StatusDto;

import org.example.projectstatusqli.dto.StatusDtoSave;
import org.example.projectstatusqli.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/status")
public class StatusController {
    private final StatusService statusService;
    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping
    public Optional<List<StatusDto>> getAllStatus(){
        return statusService.getAllStatus();
    }
    @DeleteMapping("/{id}")
    public void deleteStatus(@PathVariable Long id){
        statusService.deleteStatus(id);
    }
    @PostMapping
    public Optional<StatusDtoSave> addStatus(@RequestBody StatusDto statusDto){
        return statusService.addStatus(statusDto);
    }
    @PutMapping("/{id}")
    public Optional<StatusDto> updateStatus(@PathVariable Long id,@RequestBody StatusDto statusDto){
        return statusService.updateStatus(id,statusDto);
    }

}
