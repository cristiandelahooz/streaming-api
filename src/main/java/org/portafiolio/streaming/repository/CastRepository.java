package org.portafiolio.streaming.repository;

import org.portafiolio.streaming.model.Cast;
import org.portafiolio.streaming.model.compositeprimarykey.CastPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CastRepository extends JpaRepository<Cast, CastPK> {
}
