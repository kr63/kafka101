package com.example.kafka.springbootkafkaproducer.resources;

import com.example.kafka.springbootkafkaproducer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserResources {

    private static final String TOPIC = "Kafka_Example";

    private final KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    public UserResources(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name) {
        kafkaTemplate.send(TOPIC, new User(name, "dept1", 1234L));
        return "Published successfully";
    }
}
