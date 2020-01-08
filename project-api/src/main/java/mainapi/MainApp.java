/**
 * Available topics on localhost: /topic /ctest - for testing
 * 
 * Embedded Apache Derby DataBase - runs in memory in runtime
 * 
 * TODO
 */
package mainapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("interfaces") //need to scan where JPA will be called
@EntityScan("objects") //need to scan where @Entity annotation is!
@ComponentScan("controller") //this is what it needs to see other packages
public class MainApp {

	/**
	 * Main Application
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Java Spring Boot application -auto-servlet-
		SpringApplication.run(MainApp.class, args);
		
		System.out.println("App loading and running..."); //console test-debug 
	}

}
