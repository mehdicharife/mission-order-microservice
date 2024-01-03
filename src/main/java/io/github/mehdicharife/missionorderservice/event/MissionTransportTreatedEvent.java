package io.github.mehdicharife.missionorderservice.event;


public class MissionTransportTreatedEvent {
    
    private Long missionId;

    private Long requestId;


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

    
}
