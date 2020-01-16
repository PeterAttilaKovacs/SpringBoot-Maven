/**
 * REST SubTopic controller - for handling URL request
 */
package subtopics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import objects.TopicObject;

@RestController
public class SubController {

	@Autowired
	private SubService subService;
	
	/**
	 * List of Array of Objects --> made in to JSon
	 * @return SubService ArrayList
	 */
	@RequestMapping("/topic/{id}/subtopics")
	public List<SubObject> subtopicController(@PathVariable String id){
		return subService.getAllSubTopics(id);
	}
	
	/**
	 * SubObject request, parameter: ID
	 * @param id - id, the PathVariable gives it as a String to id <--request mapping
	 * @return the first ID of the Object
	 * 	(see also: SubService)
	 */
	@RequestMapping("/topic/{topicId}/subtopics/{id}")
	public SubObject getSubTopic(@PathVariable String id) {
		return subService.getSubTopic(id);
	}

	/**
	 * SubTopic adding with @RequestMapping configuration - POST
	 * @RequestBody - gives back one object of SubObject
	 * @PathVariable - gives back the parent topicId
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/topic/{topicId}/subtopics")
	public void addSubTopic(@RequestBody SubObject subtopic, 
			@PathVariable String topicId, String name, String description) {
		//subtopic.setTopic(new TopicObject(topicId, "", "")); //see SubObject Topic setter
		//subtopic.setTopic(TopicObject(topicId, name, description));
		subtopic.setTopic(new TopicObject(topicId, name, description));
		subService.addSubTopic(subtopic);
	}
	
	/**
	 * SubTopic refreshing (ID as key) with @RequestMapping configuration - PUT
	 * @RequestBody - gives back one object of SubObject
	 * @PathVariable - gives back the parent topicId 
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/topic/{topicId}/subtopics/{id}")
	public void updateSubTopic(	@RequestBody SubObject subtopic, 
								@PathVariable String id,
								@PathVariable String topicId) {
		subtopic.setTopic(new TopicObject(topicId, "", "")); //see SubObject Topic setter
		subService.updateSubTopic(subtopic);
	}
	
	/**
	 * SubTopic deleting (ID as key) with @RequestMapping configuration - DELETE
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/topic/{topicId}/subtopics/{id}")
	public void deleteSubTopic(@PathVariable String id) {
		subService.deleteSubTopic(id);
	}
}
