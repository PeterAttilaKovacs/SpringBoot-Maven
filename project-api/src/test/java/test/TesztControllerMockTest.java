/**
 * JUnit4 ClassRunner test on TesztController
 * 
 * Result: 2/2 - Fail (Testing: 12 times)
 */
package test;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import controller.TesztController;

@RunWith(SpringJUnit4ClassRunner.class)
//@WebMvcTest(TesztController.class)
public class TesztControllerMockTest {

	//servlet test
	//@Autowired
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
		MockMvcBuilders.standaloneSetup(tesztController).build();
	}
	
	@Test
	public void testTesztController() throws Exception {
		
		mockMvc.perform(get("/hello/hello")) //nem latja az utvonalat?
			.andExpect(status().isOk()) //result: 200
			.andExpect(content().string("Controller works.")); //Matches the text in TesztCtrl.
	}

	@Test
	public void testTesztControllerJSon() throws Exception {
		
		mockMvc.perform(get("/hello/json") //nem latja az utvonalat?
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect((ResultMatcher) jsonPath("$.id", Matchers.matches("1")))
			.andExpect((ResultMatcher) jsonPath("$.name", Matchers.matches("JSon")))
			.andExpect((ResultMatcher) jsonPath("$.description", Matchers.matches("Object")));
	}
}

//nem fut le, de miert...mi nincs jel beallitva vajon...