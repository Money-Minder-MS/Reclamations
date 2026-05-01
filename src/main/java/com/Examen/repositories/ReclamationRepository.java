package com.Examen.repositories;

import com.Examen.entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
    // Cette interface permet d'utiliser save(), findAll(), deleteById(), etc.
}
