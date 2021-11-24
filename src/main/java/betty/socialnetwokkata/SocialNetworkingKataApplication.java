package betty.socialnetwokkata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import betty.socialnetwokkata.app.SocialNetworkKataApp;
import betty.socialnetwokkata.app.SocialNetworkKataEngine;

@SpringBootApplication
public class SocialNetworkingKataApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SocialNetworkingKataApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
		SocialNetworkKataApp main = new SocialNetworkKataApp();
		SocialNetworkKataEngine engine = main.inizializzaEngine();
		engine.run();
    }
}
