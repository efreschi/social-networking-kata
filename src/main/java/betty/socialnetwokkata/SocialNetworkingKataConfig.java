package betty.socialnetwokkata;

import java.util.Scanner;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import betty.socialnetwokkata.event.FollowsEvent;
import betty.socialnetwokkata.event.PostEvent;
import betty.socialnetwokkata.event.ReadEvent;
import betty.socialnetwokkata.event.WallEvent;

@Configuration
@EnableBatchProcessing
public class SocialNetworkingKataConfig {
	
	private Scanner scanner;
	
	@Autowired
	private PostEvent postEvent;

	@Autowired
	private ReadEvent readEvent;

	@Autowired
	private FollowsEvent followsEvent;

	@Autowired
	private WallEvent wallEvent;

	public SocialNetworkingKataConfig() {
		super();
		this.scanner = new Scanner(System.in);
	}
	
	@Bean
	public Scanner getScanner() {
		return scanner;
	}
	
}
