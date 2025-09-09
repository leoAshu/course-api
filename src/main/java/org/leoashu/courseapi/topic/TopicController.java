package org.leoashu.courseapi.topic;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    List<Topic> topics;

    public TopicController() {
        topics = new ArrayList<>();
        topics.add(new Topic("java", "Core Java", "Core Java Description."));
        topics.add(new Topic("spring", "Spring Framework", "Spring Framework Description."));
        topics.add(new Topic("spring-boot", "Spring Boot", "Spring Boot Description."));
    }

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return topics;
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topics.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
