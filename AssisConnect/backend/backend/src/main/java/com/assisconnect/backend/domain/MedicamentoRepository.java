package com.assisconnect.backend.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
    List<Medicamento> findByResidenteId(Long residenteId);
    void deleteByResidenteId(Long residenteId);
}
