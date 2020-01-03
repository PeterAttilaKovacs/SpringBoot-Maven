/**
 * REST kontroller - URL hivasok kezelesere
 */
package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import objects.TopicObject;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	/**
	 * Lista tomb objektumokkal --> JSon alatikva (kesobb formazhato)
	 * @return TopicService elemekbol allo tomb
	 */
	@RequestMapping("/topic")
	public List<TopicObject> topicController(){
		return topicService.getAllTopics();
	}
	
	/**
	 * TopicObject parameterezett lekerdezese, parameter: ID
	 * @param id - id valtozo, amit a PathVariable atad a String id-be <--request mappingbol
	 * @return visszatero erteke az ID alapjan megtalalt es egyezo elso objektum
	 * 													(ld. TopicService)
	 * Nevkonvencio: id - id (valtoztatas eseten a PathVariable("...nev...")-ra valtoztatni)
	 */
	@RequestMapping("/topic/{id}")
	public TopicObject getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
}
