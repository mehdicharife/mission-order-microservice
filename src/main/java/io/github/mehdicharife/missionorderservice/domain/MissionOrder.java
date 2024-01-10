package io.github.mehdicharife.missionorderservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MissionOrder {

    @Id
    private Long id;
    
    private Long missionId;

    private Long professorId;

    private String fileName;

    public MissionOrder() {

    }

    public MissionOrder(Long missionId, Long professorId) {
        this.missionId = missionId;
        this.professorId = professorId;
    }


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

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    
}
