/**
 * REST controller - for URL request - for test only
 */
package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesztController {

	//test
	/**
	 * Request call on localhost "/ctest" param <-- GET method
	 * @return request is returning "Controller works."
	 */
	@RequestMapping("/ctest")
	public String controllerTest() {
		return "Controller works.";
	}
}
