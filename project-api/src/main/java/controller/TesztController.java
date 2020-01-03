/**
 * REST kontroller - URL hivasok kezelesere
 */
package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesztController {

	//TESZT
	/**
	 * Eljarashivas lokalhostra "/teszt" parameterrel <-- alapesetben GET metodus
	 * @return meghivott eljaras mukodik
	 */
	@RequestMapping("/hello")
	public String controllerTest() {
		return "Controller works...";
	}
}
