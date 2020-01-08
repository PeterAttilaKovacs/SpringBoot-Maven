/**
 * Entity class as TopicObject
 */
package objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TopicObject {

	//variables definition - text columns
	@Id
	private String ID;
	
	private String name;
	private String description;
	
	/**
	 * TopicObject base constructor
	 */
	public TopicObject(){}
	
	/**
	 * TopicObject parameter constructor
	 * @param id - topic unique key
	 * @param name - topic name
	 * @param description - topic description
	 */
	public TopicObject(String id, String name, String description) {
		super();
		ID = id;
		this.name = name;
		this.description = description;
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
}
