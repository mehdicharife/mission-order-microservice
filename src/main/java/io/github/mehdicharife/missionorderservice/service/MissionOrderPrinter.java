package io.github.mehdicharife.missionorderservice.service;

import io.github.mehdicharife.missionorderservice.domain.Mission;
import io.github.mehdicharife.missionorderservice.domain.Professor;

public interface MissionOrderPrinter {
    String generateMissionOrderDocument(Mission mission, Professor professor);
}
