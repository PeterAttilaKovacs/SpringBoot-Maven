/**
 * Available topics on localhost: /topic, topic/id/subtopics, /hello - for testing
 * (memo: for war deployment in pom.xml change: <packaging>jar</packaging> to <packaging>war</packaging>)
 * 
 * Embedded Apache Derby DataBase - runs in memory in runtime
 * 
 * Actuator methods available on port: 9001
 * 
 * Using outer-controller for GET-POST-PUT-DELTE: FireFox RESTer 
 * 
 * TODO outer DB connection
 */
package mainapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories({"interfaces", "subtopics"}) //need to scan where JPA will be called
//@EnableJpaRepositories("interfaces") //need to scan where JPA will be called
@EntityScan({"objects", "subtopics"}) //need to scan where @Entity annotation is!
//@EntityScan("objects") //need to scan where @Entity annotation is!
@ComponentScan({"controller", "subtopics"}) //this is what it needs to see other packages
public class MainApp {

	/**
	 * Main Application
	 * @param args none
	 */
	public static void main(String[] args) {
		
		//Java Spring Boot application -auto-servlet-
		SpringApplication.run(MainApp.class, args);
		
		System.out.println("App loading and running..."); //console test-debug 
	}

}
