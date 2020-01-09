/**
 * SubTopics SubService
 */
package subtopics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubService {

	@Autowired
	private SubRepository subRepository;

	//Getter for all subtopics from database into an ArrayList
	public List<SubObject> getAllSubTopics(String topicId) {
		List<SubObject> subtopics = new ArrayList<>(); //creating an empty ArrayList
		subRepository.findByTopicID(topicId).forEach(subtopics::add); //adding elements to the array
		return subtopics;
		
	}
	
	/**
	 * SubTopics database filtered search, using ID as key
	 * @param id - unique key
	 * @return first found object that matches the ID @param
	 */
	public SubObject getSubTopic(String id) {
		return subRepository.findOne(id);
	}

	//Adding SubTopics to database
	public void addSubTopic(SubObject subtopic) {
		subRepository.save(subtopic);
	}
	
	//Refreshing SubTopics to database
	public void updateSubTopic(SubObject subtopic) {
		subRepository.save(subtopic);
	}
	
	//Deleting SubTopic from database - ID as key
	public void deleteSubTopic(String id) {
		subRepository.delete(id);
	}
}
