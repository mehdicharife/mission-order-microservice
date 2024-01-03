package io.github.mehdicharife.missionorderservice.event;


public class MissionTransportTreatedEvent {
    
    private Long missionId;

    private Long requestId;

    private Long professorId;


    public Long getMissionId() {
        return this.missionId;
    }

    public void setMissionId(Long missionId) {
        this.missionId = missionId;
    }

    public Long getRequestId() {
        return this.requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }


    public Long getProfessorId() {
        return this.professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }


    @Override
    public String toString() {
        return "{" +
            " missionId='" + getMissionId() + "'" +
            ", requestId='" + getRequestId() + "'" +
            ", professorId='" + getProfessorId() + "'" +
            "}";
    }

}
