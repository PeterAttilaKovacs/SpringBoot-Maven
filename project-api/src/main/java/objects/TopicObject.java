package objects;

public class TopicObject {

	//valtozok definalasa
	private String ID;
	private String name;
	private String description;
	
	/**
	 * TopicObject alap konstruktora
	 */
	public TopicObject(){}
	
	/**
	 * TopicObject parameterezett konstruktora
	 * @param id - topic hivatkozasa egyedi azonositoval
	 * @param name - topic neve
	 * @param description - topic leirasa
	 */
	public TopicObject(String id, String name, String description) {
		super();
		ID = id;
		this.name = name;
		this.description = description;
	}
	//ID gettere es settere
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	//name gettere es settere
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//description gettere es settere
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
