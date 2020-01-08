/**
 * REST Topic controller - for handling URL request
 */
package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import objects.TopicObject;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	/**
	 * List of Array of Objects --> made in to JSon
	 * @return TopicService ArrayList
	 */
	@RequestMapping("/topic")
	public List<TopicObject> topicController(){
		return topicService.getAllTopics();
	}
	
	/**
	 * TopicObject request, parameter: ID
	 * @param id - id, the PathVariable gives it as a String to id <--request mapping
	 * @return the first ID of the Object
	 * 	(see also: TopicService)
	 */
	@RequestMapping("/topic/{id}")
	public TopicObject getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}

	/**
	 * Topic adding with @RequestMapping configuration - POST
	 * @RequestBody - gives back one object of TopicObject
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/topic")
	public void addTopic(@RequestBody TopicObject topic) {
		topicService.addTopic(topic);
	}
	
	/**
	 * Topic refreshing (ID as key) with @RequestMapping configuration - PUT
	 * @RequestBody - gives back one object of TopicObject 
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/topic/{id}")
	public void updateTopic(@RequestBody TopicObject topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
	}
	
	/**
	 * Topic deleting (ID as key) with @RequestMapping configuration - DELETE
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/topic/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
}
