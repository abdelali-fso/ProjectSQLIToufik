package org.example.projectstatusqli.repository;

import org.example.projectstatusqli.model.Libelle;
import org.example.projectstatusqli.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<Status,Long> {
    Optional<Status> findByLibelle(Libelle libelle);
}
