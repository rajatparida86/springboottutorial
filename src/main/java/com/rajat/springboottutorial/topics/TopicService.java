package com.rajat.springboottutorial.topics;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("kairos", "kairosDB", "Starter for kairosDB"),
            new Topic("cassie", "Cassie", "Starter for Cassandra"),
            new Topic("redis", "Redis", "Starter for Redis")));

    public List<Topic> getAllTopics(){
        return topics;
    }

    public Topic getTopicById(String id){
        Topic topic = topics.stream()
                .filter(object -> object.getId().equals(id))
                .findFirst()
                .orElse(null);
        return topic;
    }

    public void addTopic(Topic topic){
        topics.add(topic);
    }

    public Topic updateTopic(String id, Topic topic) {
        for (int i=0; i<topics.size();i++){
            Topic t = topics.get(i);
            if (t.getId().equals(id)){
                topics.set(i,topic);
            }
        }
        return this.getTopicById(id);
    }

    public void deleteTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
    }
}
