package betty.socialnetwokkata;

import java.util.Scanner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import betty.socialnetwokkata.event.FollowsEvent;
import betty.socialnetwokkata.event.PostEvent;
import betty.socialnetwokkata.event.ReadEvent;
import betty.socialnetwokkata.event.WallEvent;
import betty.socialnetwokkata.step.ConsoleInputReader;
import betty.socialnetwokkata.step.SocialNetworkingKataProcessor;
import betty.socialnetwokkata.step.SocialNetworkingKataWriter;

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

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private ConsoleInputReader consoleInputReader;	

	@Autowired
	private SocialNetworkingKataWriter snkWriter;
	public SocialNetworkingKataConfig() {
		super();
		this.scanner = new Scanner(System.in);
	}
	
	@Bean
	public Scanner getScanner() {
		return scanner;
	}
	
	@Bean
	public SocialNetworkingKataProcessor processor() {
	  return new SocialNetworkingKataProcessor();
	}

	@Bean
	public Job createJob() {
		return jobBuilderFactory.get("MyJob")
				.incrementer(new RunIdIncrementer())
				.flow(createStep())
				.end()
				.build();
	}

	@Bean
	public Step createStep() {
		return stepBuilderFactory.get("MyStep")
				.<String, String> chunk(1)
				.reader(consoleInputReader)
				.processor(processor())
				.writer(snkWriter)
				.build();
	}
}
