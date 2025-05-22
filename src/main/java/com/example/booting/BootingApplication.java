package com.example.booting;

import com.example.booting.async.AsyncPayload;
import com.example.booting.data.repository.RoomRepository;
import com.example.booting.data.repository.StaffRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class BootingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootingApplication.class, args);
    }

    private static final String QUEUE_NAME = "room-cleaner";
    private static final String EXCHANGE_NAME = "operations";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("landon.#");
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate, RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        return args -> {
            ResponseEntity<List<Room>> rooms = restTemplate.exchange("http://localhost:8080/api/rooms",
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Room>>() {
                    });
            rooms.getBody().forEach(r -> {
                AsyncPayload payload = new AsyncPayload();
                payload.setId(r.getId());
                payload.setModel("ROOMS");
                try{
                    rabbitTemplate.convertAndSend("operations", "landon.rooms.cleaner", objectMapper.writeValueAsString(payload));
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }


            });
            /* userRepository.saveAll(userRepository.findAll());

            User u1 = new User(1, "didul", "dulsaradidul@gmail.com");
            User u2 = new User(2, "thisal", "thisalsalpura@gmail.com");
            User u3 = new User(3, "kisal", "kisalviksura@gmail.com");
            User u4 = new User(4, "nithil", "nithilnethsuka@gmail.com");

            userRepository.saveAll(List.of(u1, u2, u3, u4));  // ✅ Persist to actual database

            userRepository.deleteById(2);  // ✅ Delete one

            User u5 = new User(4, "nithilananda", "nethsukanithil@gmail.com");
            userRepository.save(u5);  // ✅ Update (same ID)

            System.out.println("Loaded Users (after insert): " + userRepository.findAll());
            System.out.println("**** ROOMS ****");
            roomRepository.findAll().forEach(System.out::println);
            System.out.println("\n**** STAFF ****");
            staffRepository.findAll().forEach(System.out::println); */
        };
    }

}
