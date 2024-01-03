package io.github.mehdicharife.missionorderservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MissionOrder {

    @Id
    private Long id;
    
    private Long missionId;

    private Long professorId;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMissionId() {
        return this.missionId;
    }

    public void setMissionId(Long missionId) {
        this.missionId = missionId;
    }

    public Long getProfessorId() {
        return this.professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    
}
