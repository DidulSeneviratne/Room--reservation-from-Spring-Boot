package com.example.booting.config;

import com.example.booting.async.RoomCleanerListener;
import org.apache.coyote.Adapter;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AsyncConfig {
    private static final String QUEUE_NAME = "room-cleaners";
    private static final String EXCHANGE_NAME = "operations";

    @Bean
    public Queue myqueue() {
        return new Queue(QUEUE_NAME, false);
    }

    @Bean
    public TopicExchange exchanges() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding bindings(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("landon.rooms.cleaner");
    }

    @Bean
    public MessageListenerAdapter listnerAdapters (RoomCleanerListener listener) {
        return new MessageListenerAdapter(listener, "receiveMessage");
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_NAME);
        container.setMessageListener(listenerAdapter);
        return container;
    }
}
