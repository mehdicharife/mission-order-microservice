package io.github.mehdicharife.missionorderservice.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.mehdicharife.missionorderservice.event.MissionTransportTreatedEvent;


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


    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }


    @Bean
    public DefaultClassMapper classMapper() {
        DefaultClassMapper classMapper = new DefaultClassMapper();
        Map<String, Class<?>> map = new HashMap<>();

        map.put(
        "io.github.mehdicharife.transporttreatmentmicroservice.event.MissionTransportTreatedEvent",
        MissionTransportTreatedEvent.class);

        classMapper.setIdClassMapping(map);
        
        return classMapper;
    }


    @Bean
    public Jackson2JsonMessageConverter converter(ObjectMapper objectMapper, DefaultClassMapper classMapper) {
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter(objectMapper);
        converter.setClassMapper(classMapper);
        return converter;
    }

    

    
}
