package io.github.mehdicharife.missionorderservice.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import io.github.mehdicharife.missionorderservice.domain.Mission;
import io.github.mehdicharife.missionorderservice.domain.MissionOrder;
import io.github.mehdicharife.missionorderservice.domain.Professor;
import io.github.mehdicharife.missionorderservice.event.MissionTransportTreatedEvent;
import io.github.mehdicharife.missionorderservice.service.MissionOrderPrinter;
//import io.github.mehdicharife.missionorderservice.service.MissionOrderService;
import io.github.mehdicharife.missionorderservice.service.MissionOrderService;

@Component
@RabbitListener(queues="${missionTransportTreatedQueueName}")
public class MissionTransportTreatedEventListener {

    
    //@Autowired
    //private MissionOrderService missionOrderService;

    //@Autowired
    //private MissionOrderPrinter missionOrderPrinter;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${esb}")
    private String esb;
    
    @RabbitHandler
    public void react(MissionTransportTreatedEvent missionTransportTreatedEvent) {
        Long missionId = missionTransportTreatedEvent.getMissionId();
        Long professorId = missionTransportTreatedEvent.getProfessorId();

        MissionOrder missionOrder = new MissionOrder(missionId, professorId);
        
        Mission mission = this.restTemplate.getForObject(esb + "missions/" + missionId, Mission.class);
        Professor professor = this.restTemplate.getForObject(esb + "professors/" + professorId, Professor.class);
        
        //String fileName = this.missionOrderPrinter.generateMissionOrderDocument(mission, professor);
        //missionOrder.setFileName(fileName);

        System.out.println(mission);
        System.out.println(professor);

        //this.missionOrderService.saveMissionOrder(missionOrder);
    }
}
