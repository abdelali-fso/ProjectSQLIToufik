package org.example.projectstatusqli.service.impl;

import org.example.projectstatusqli.dto.ContributeurDto;
import org.example.projectstatusqli.dto.ContributeurDtoSave;
import org.example.projectstatusqli.functions.Builders;
import org.example.projectstatusqli.functions.BuildersImpl;
import org.example.projectstatusqli.functions.CheckIfPresent;
import org.example.projectstatusqli.functions.IsPresent;
import org.example.projectstatusqli.model.Contributeur;
import org.example.projectstatusqli.repository.ContributeurRepository;
import org.example.projectstatusqli.service.ContributeurService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContributeurServiceImpl implements ContributeurService {
    private static final Logger logger = LoggerFactory.getLogger(ContributeurServiceImpl.class);
    Builders builders = new BuildersImpl();
    CheckIfPresent check = new IsPresent() ;
    private final ContributeurRepository contributeurRepository;
    @Autowired
    public ContributeurServiceImpl(ContributeurRepository contributeurRepository) {
        this.contributeurRepository = contributeurRepository;
    }

    @Override
    public Optional<List<ContributeurDto>> getAllContributeurs() {
        try{
            List<Contributeur> contributeurs = contributeurRepository.findAll();
            List<ContributeurDto> contributeurDtos = contributeurs.stream()
                    .map(contributeur -> builders.mapToContributeurDto(contributeur))
                    .toList();
            return Optional.of(contributeurDtos);
        }catch (Exception e){
            logger.error("Error in getting all contributors: " + e.getMessage());
            throw new RuntimeException("Failed to retrieve all contributors", e);
        }
    }

    @Override
    public void deleteContributeur(Long id) {
        try{
            Optional<Contributeur> optionalContributeur = contributeurRepository.findById(id);
            check.isNotPresent(optionalContributeur);
            contributeurRepository.deleteById(id);
            logger.info("contributors with id : " + id + " deleted successfully");
        }catch (Exception e) {
            logger.error("Error in deleting contributors: " + e.getMessage());
            throw new RuntimeException("Failed to delete contributors", e);
        }
    }

    @Override
    public Optional<ContributeurDtoSave> addContributeur(ContributeurDto contributeurDto) {
        try{
            Contributeur savedContributeur = contributeurRepository.save(builders.mapToContributeur(contributeurDto));
            logger.info("contributors saved successfully");
            return Optional.of(builders.mapToContributeurDtoSave(savedContributeur));
        }catch (Exception e) {
            logger.error("Error in adding contributors: " + e.getMessage());
            throw new RuntimeException("Failed to add contributors", e);
        }
    }

    @Override
    public Optional<ContributeurDto> updateContributeur(Long id, ContributeurDto contributeurDto) {
        try{
            Optional<Contributeur> optionalContributeur = contributeurRepository.findById(id);
            check.isNotPresent(optionalContributeur);
            Contributeur updatedContributeur = contributeurRepository.save(builders.mapToContributeurUpdate(id,contributeurDto));
            logger.info("contributors updated successfully");
            return Optional.of(builders.mapToContributeurDto(updatedContributeur));
        }catch (Exception e) {
            logger.error("Error in updating contributors: " + e.getMessage());
            throw new RuntimeException("Failed to updating contributors", e);
        }
    }
}
