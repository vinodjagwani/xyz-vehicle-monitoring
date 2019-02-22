package com.xyz.vehicle.monitoring.config;


import com.xyz.vehicle.monitoring.constant.Constants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by vinodjagwani on 21/01/19.
 */
@Configuration
public class RabbitMQConfig {


    @Bean
    public Exchange vehicleStatusExchange() {
        return ExchangeBuilder.topicExchange(Constants.EXCHANGE_VEHICLE_STATUS).build();
    }

    @Bean
    public Queue vehicleStatusQueue() {
        return QueueBuilder.durable(Constants.QUEUE_VEHICLE_STATUS).build();
    }


    @Bean
    public Binding binding(Queue vehicleStatusQueue, TopicExchange vehicleStatusExchange) {
        return BindingBuilder.bind(vehicleStatusQueue).to(vehicleStatusExchange).with(Constants.QUEUE_VEHICLE_STATUS);
    }


    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
