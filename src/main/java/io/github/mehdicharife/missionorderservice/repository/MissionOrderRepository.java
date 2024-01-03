package io.github.mehdicharife.missionorderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.mehdicharife.missionorderservice.domain.MissionOrder;

@Repository
public interface MissionOrderRepository extends JpaRepository<MissionOrder, Long> {
    
}
