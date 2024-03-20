package org.example.projectstatusqli.service;

import org.example.projectstatusqli.dto.ContributeurDto;
import org.example.projectstatusqli.dto.ContributeurDtoSave;

import java.util.List;
import java.util.Optional;

public interface ContributeurService {
    Optional<List<ContributeurDto>> getAllContributeurs();
    void deleteContributeur(Long id);
    Optional<ContributeurDtoSave> addContributeur(ContributeurDto contributeurDto);
    Optional<ContributeurDto> updateContributeur(Long id,ContributeurDto contributeurDto);

}
