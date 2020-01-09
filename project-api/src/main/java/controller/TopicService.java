/**
 * (Singleton Design Pattern)
 * TopicService
 */
package controller;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import interfaces.TopicRepository;
import objects.TopicObject;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	//In runtime only one will  from this- singleton
//	private List<TopicObject> topics = new ArrayList<>(Arrays.asList(
//			
//			//adding new objects
//			new TopicObject("Spring", "Java Spring Boot", "Java Spring Boot description"),
//			new TopicObject("Java", "Core Java 1.8", "Core Java 1.8 description"),
//			new TopicObject("JavaScript", "JavaScript - Eclipse", "JavaScript description"),
//			new TopicObject("TypeScript", "TypeScript - Angular", "Angular description")
//			));

	//Getter for (ArrayList) all topics from database
	public List<TopicObject> getAllTopics() {
		//return topics; //old get call
		List<TopicObject> topics = new ArrayList<>(); //creating an empty ArrayList
		topicRepository.findAll().forEach(topics::add); //adding elements to the array
		return topics;
		
	}
	
	/**
	 * Topics (ArrayList) database filtered search, using ID as key
	 * @param id - unique key
	 * @return first found object that matches the ID @param
	 */
	public TopicObject getTopic(String id) {
		//topics array stream filter with lambda expression: ID matches id
		//return topics.stream().filter(t -> t.getID().equals(id)).findFirst().get();
		return topicRepository.findOne(id);
	}

	//Adding Topics to (-"topics" array-) database
	public void addTopic(TopicObject topic) {
		//topics.add(topic); //old add method
		topicRepository.save(topic);
	}
	
	//Refreshing Topics to "topics" database
	public void updateTopic(String id, TopicObject topic) {
		
		//Searching the array for element object - ID as key
//		for (int i = 0; i < topics.size(); i++) {
//			TopicObject tempTopic = topics.get(i);
//			
//			if (tempTopic.getID().equals(id)) {
//				topics.set(i, topic); // refreshing "i" element
//				return;
//			}
//		}
		
		//Updating topic, using id as key
		topicRepository.save(topic);
	}
	
	//Deleting Topic from "topics" database - ID as key
	public void deleteTopic(String id) {
		//topics.removeIf(t -> t.getID().equals(id));
		topicRepository.delete(id);
	}
}
