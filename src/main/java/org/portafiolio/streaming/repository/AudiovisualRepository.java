package org.portafiolio.streaming.repository;

import org.portafiolio.streaming.model.Audiovisual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudiovisualRepository extends JpaRepository<Audiovisual, Long> {
}
