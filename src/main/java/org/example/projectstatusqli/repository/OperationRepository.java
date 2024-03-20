package org.example.projectstatusqli.repository;

import org.example.projectstatusqli.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {
}
