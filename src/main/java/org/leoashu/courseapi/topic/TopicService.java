package org.leoashu.courseapi.topic;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    List<Topic> topics = Arrays.asList(
            new Topic("java", "Core Java", "Core Java Description."),
            new Topic("spring", "Spring Framework", "Spring Framework Description."),
            new Topic("spring-boot", "Spring Boot", "Spring Boot Description.")
    );

    public List<Topic> getAllTopics() {
        return topics;
    }

}
