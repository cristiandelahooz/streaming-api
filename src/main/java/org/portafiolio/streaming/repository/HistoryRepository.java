package org.portafiolio.streaming.repository;

import org.portafiolio.streaming.model.History;
import org.portafiolio.streaming.model.compositeprimarykey.HistoryPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface HistoryRepository extends JpaRepository<History, HistoryPK> {
   /* @Query("SELECT h FROM History h WHERE h.userId = :userId AND h.audiovisualId = :audiovisualId and h.date = :date")
    Optional<History> findHistory(Long userid, Long audiovisualId, Date date);*/
}
