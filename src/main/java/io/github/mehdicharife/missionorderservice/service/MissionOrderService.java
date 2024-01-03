package io.github.mehdicharife.missionorderservice.service;

import java.util.List;
import java.util.Optional;

import io.github.mehdicharife.missionorderservice.domain.MissionOrder;



public interface MissionOrderService {
    List<MissionOrder> getAllMissionOrders();

    Optional<MissionOrder> getMissionOrderById(Long id);
    
    MissionOrder saveMissionOrder(MissionOrder missionOrder);
}
