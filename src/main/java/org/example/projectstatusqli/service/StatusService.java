package org.example.projectstatusqli.service;

import org.example.projectstatusqli.dto.StatusDto;
import org.example.projectstatusqli.dto.StatusDtoSave;

import java.util.List;
import java.util.Optional;

public interface StatusService {
    Optional<List<StatusDto>> getAllStatus();
    void deleteStatus(Long id);
    Optional<StatusDtoSave> addStatus(StatusDto statusDto);
    Optional<StatusDto> updateStatus(Long id,StatusDto statusDto);
}
