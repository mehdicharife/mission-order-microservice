package io.github.mehdicharife.missionorderservice.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import io.github.mehdicharife.missionorderservice.domain.Mission;
import io.github.mehdicharife.missionorderservice.event.MissionTransportTreatedEvent;
//import io.github.mehdicharife.missionorderservice.service.MissionOrderService;

@Component
@RabbitListener(queues="${missionTransportTreatedQueueName}")
public class MissionTransportTreatedEventListener {

    
    /*@Autowired
    private MissionOrderService missionOrderService;*/

    @Autowired
    private RestTemplate restTemplate;

    @Value("${esb}")
    private String esb;
    
    @RabbitHandler
    public void react(MissionTransportTreatedEvent missionTransportTreatedEvent) {
        Mission mission = this.restTemplate.getForObject(esb + "missions/" + missionTransportTreatedEvent.getMissionId(), Mission.class);
        System.out.println(mission);
    }
}
