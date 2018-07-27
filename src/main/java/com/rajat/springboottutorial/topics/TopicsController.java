package com.rajat.springboottutorial.topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicsController {

    @Autowired
    public TopicService topicService;

    //Home URL
    @RequestMapping("")
    public List<Topic> getTopics(){
        return topicService.getAllTopics();
    }

    //Use of path variables
    @RequestMapping("/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopicById(id);
    }

    //Usage of Request BODY and handling a POST request
    @RequestMapping(method = RequestMethod.POST )
    public Topic addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
        return topicService.getTopicById(topic.getId());
    }

    //Handling a PUT request to update an existing Topic
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Topic updateTopic(@RequestBody Topic topic, @PathVariable String id){
        return topicService.updateTopic(id, topic);
    }

    //Handling a DELETE request
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public List<Topic> deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
        return topicService.getAllTopics();
    }
}
