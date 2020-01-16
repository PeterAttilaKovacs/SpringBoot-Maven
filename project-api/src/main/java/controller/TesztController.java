/**
 * REST controller - for URL request - for test only
 */
package controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class TesztController {

	/**
	 * TesztController for testing
	 * Request call on localhost "/ctest" param <-- GET method
	 * @return request is returning "Controller works."
	 * @GetMapping - GET method
	 */
	@GetMapping
	public String controllerTest() {
		return "Controller works.";
	}
	
	@GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public controllerJson json() {
		return new controllerJson("1", "JSon", "Object");
	}
	
	//test controllerJSon object - nested class
	private class controllerJson {
		
		//Variables
		String id;
		String name;
		String description;
		
		//Constructor
		public controllerJson(String id, String name, String description) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
		}

		//Getter and setter for ID
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		//Getter and setter for Name
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		//Getter and setter for Description
		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
	}
}
