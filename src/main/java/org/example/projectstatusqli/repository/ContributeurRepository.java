package org.example.projectstatusqli.repository;

import org.example.projectstatusqli.model.Contributeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributeurRepository extends JpaRepository<Contributeur,Long> {
}
