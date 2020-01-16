/**
 * JUnit4 ClassRunner test on TesztController
 * 
 * Result: 2/2 - Fail (Testing: 12 times - 13.01.2020)
 * Result: 2/2 - Ok (Testing: 20 times - 16.01.2020)
 */
package test;

//import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import controller.TesztController;

@RunWith(SpringRunner.class)
//@WebMvcTest(TesztController.class)
public class TesztControllerMockTest {

	//Variables
	private MockMvc mockMvc; 
	
	//instance of TesztController
	@InjectMocks
	private TesztController tesztController;
	
	/**
	 * MockMVC stand alone on instance of TesztController
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(tesztController).build();
	}
	
	/**
	 * Basic test for TesztController
	 * status: ok 
	 * content: matches
	 * @throws Exception
	 */
	@Test
	public void testTesztController() throws Exception {
		
		mockMvc.perform(get("/hello"))
			.andExpect(status().isOk())
			.andExpect(content().string("Controller works.")); //Matches the text in TesztCtrl.
	}

	/**
	 * Test for JSon
	 * status: ok
	 * content: matches
	 * @throws Exception
	 */
	@Test
	public void testTesztControllerJSon() throws Exception {
		
		mockMvc.perform(get("/hello/json")
			.accept(MediaType.APPLICATION_JSON))

//this matcher dose not work together with json
//			.andExpect(status().isOk())
//			.andExpect((ResultMatcher) jsonPath("$.id", Matchers.matches("1")))
//			.andExpect((ResultMatcher) jsonPath("$.name", Matchers.matches("JSon")))
//			.andExpect((ResultMatcher) jsonPath("$.description", Matchers.matches("Object")));
		
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id").value("1"))
			.andExpect(jsonPath("$.name").value("JSon"))
			.andExpect(jsonPath("$.description").value("Object"));
	}
}