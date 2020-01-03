/**
 * Elerheto lekeresek loclahos-on: /hello, /topic
 * TODO topic-ot adatbazissa alakitani --> fuggosegek kialakitasa
 */
package mainapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("controller") //ez kell, hogy lassa a controller es/egyeb taskat(kat)
public class MainApp {

	/**
	 * Foprogram (Main Application)
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Java Spring Boot aplikacio -automata-servlet- futtato
		SpringApplication.run(MainApp.class, args);
		
		System.out.println("App betolt...App mukodik..."); //TESZT
	}

}
