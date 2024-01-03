package io.github.mehdicharife.missionorderservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    @Value("${missionTransportTreatedQueueName}")
    private String MISSION_TRANSPORT_TREATED_QUEUE_NAME;
    
    @Value("${missionTransportTreatedExchangeName}")
    private String MISSION_TRANSPORT_TREATED_EXCHANGE_NAME;


    @Bean
    public Queue missionTransportTreatedQueue() {
        return QueueBuilder.durable(MISSION_TRANSPORT_TREATED_QUEUE_NAME).build();
    }
    
    
    @Bean
    public Binding missionTransportTreatedExchangeBinding(Queue missionTransportTreatedQueue) {
        return new Binding(
            MISSION_TRANSPORT_TREATED_QUEUE_NAME,
            DestinationType.QUEUE,
            MISSION_TRANSPORT_TREATED_EXCHANGE_NAME,
            "",
            null 
        );
    }

    

    
}
