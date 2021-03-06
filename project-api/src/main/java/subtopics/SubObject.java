/**
 * Entity class as SubObject
 * 
 * +SubTopic to Topic is --> Many to One relation //egy a sokhoz relacio//
 */
package subtopics;

import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne; //+

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

//import controller.TopicController;
//import interfaces.TopicRepository;
import objects.TopicObject;

@Entity
public class SubObject {

	//variables definition - text columns
	@Id
	private String ID;
	
	private String name;
	private String description;
	
//	@ManyToOne(fetch = FetchType.LAZY, optional = false) //+
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private TopicObject topic;
	
//	@ManyToOne
//	private TopicController topicController;
	
//	private TopicRepository topicRepository;
	
	/**
	 * SubObject base constructor
	 */
	public SubObject(){}
	
	/**
	 * SubObject parameter constructor
	 * @param id - subtopic unique key
	 * @param name - subtopic name
	 * @param description - subtopic description
	 * @param topicId - reference to parent topic
	 */
	public SubObject(String id, String name, String description, String topicId) {
		super();
		ID = id;
		this.name = name;
		this.description = description;
		//creating a new TopicObject witch has the topicId
		this.topic = new TopicObject(topicId, "", "");
		//this.topic = topicController.getTopic(topicId);
		//this.topic = topicRepository.findOne(topicId);
	}
	//ID getters and setters
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	//Name getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//Description getters and setters
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	//TopicObject getters and setters
	public TopicObject getTopic() {
		return topic;
	}

	public void setTopic(TopicObject topic) {
		this.topic = topic;
	}
}
