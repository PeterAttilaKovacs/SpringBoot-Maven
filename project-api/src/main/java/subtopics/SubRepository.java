/**
 * SubRepository interface using CrudRepository
 * Special impl.: findByTopicID - for finding subtopics under one topic
 */
package subtopics;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SubRepository extends CrudRepository<SubObject, String> {

						//name and variable must match! - Topic ID
	public List<SubObject> findByTopicID(String topicId);
	//public List<SubObject> findByName(String name);
	//public List<SubObject> findByDescription(String description);
}
