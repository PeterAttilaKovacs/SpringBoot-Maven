/**
 * Singelton Design Pattern
 */
package controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import objects.TopicObject;

@Service
public class TopicService {

	//Ebbol a futasido alatt csak 1 peldany fog letrejonni - singelton
	private List<TopicObject> topics = Arrays.asList(
			
			//uj objektumok hozzadasa
			new TopicObject("Spring", "Java Spring Boot", "Java Spring Boot description"),
			new TopicObject("Java", "Core Java 1.8", "Core Java 1.8 description"),
			new TopicObject("JavaScript", "JavaScript - Eclipse", "JavaScript description"),
			new TopicObject("TypeScript", "TypeScript - Angular", "Angular description")
			);

	//List tomb gettere
	public List<TopicObject> getAllTopics() {
		System.out.println("Service mukodik...");//TESZT
		return topics;
	}
	
	/**
	 * Topics List tomb filteres keresese, ID alapjan
	 * @param id - kapott egyedi azonosito
	 * @return megtalalt elso elem ID egyezes alapjan
	 */
	public TopicObject getTopic(String id) {
		//topics tomb stream keresese lambdakifejezessel: ID megegyezik-e a kapott id ertekkel
		return topics.stream().filter(t -> t.getID().equals(id)).findFirst().get();
		
	}
}
