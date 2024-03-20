package org.example.projectstatusqli.controller;

import org.example.projectstatusqli.dto.ContributeurDto;
import org.example.projectstatusqli.dto.ContributeurDtoSave;
import org.example.projectstatusqli.service.ContributeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contributeur")
public class ContributeurController {
    private final ContributeurService contributeurService;
    @Autowired
    public ContributeurController(ContributeurService contributeurService) {
        this.contributeurService = contributeurService;
    }
    @GetMapping
    public Optional<List<ContributeurDto>> getAllContributeurs(){
        return contributeurService.getAllContributeurs();
    }
    @DeleteMapping("/{id}")
    public void deleteContributeur(@PathVariable  Long id){
        contributeurService.deleteContributeur(id);
    }
    @PostMapping
    public Optional<ContributeurDtoSave> addContributeur(@RequestBody ContributeurDto contributeurDto){
        return contributeurService.addContributeur(contributeurDto);
    }
    @PutMapping("/{id}")
    public Optional<ContributeurDto> updateContributeur(@PathVariable Long id,@RequestBody ContributeurDto contributeurDto){
        return contributeurService.updateContributeur(id,contributeurDto);
    }
}
