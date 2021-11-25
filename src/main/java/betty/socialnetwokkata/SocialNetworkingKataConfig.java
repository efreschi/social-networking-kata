package betty.socialnetwokkata;

import java.util.Scanner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import betty.socialnetwokkata.business.service.SocialNetworkingKataServiceFactory;
import betty.socialnetwokkata.command.SocialNetworkingKataCommand;
import betty.socialnetwokkata.step.ConsoleInputReader;
import betty.socialnetwokkata.step.SocialNetworkingKataProcessor;
import betty.socialnetwokkata.step.SocialNetworkingKataWriter;

@Configuration
@EnableAutoConfiguration(exclude = {HibernateJpaAutoConfiguration.class})
@EnableBatchProcessing
public class SocialNetworkingKataConfig {
	
	private Scanner scanner;
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private ConsoleInputReader consoleInputReader;	

	public SocialNetworkingKataConfig() {
		super();
		this.scanner = new Scanner(System.in);
	}
	

	@Bean("socialNetworkingKataServiceFactory")
    public ServiceLocatorFactoryBean socialNetworkingKataServiceFactory() {
	    ServiceLocatorFactoryBean locator = new ServiceLocatorFactoryBean();
	    locator.setServiceLocatorInterface(SocialNetworkingKataServiceFactory.class);
        return locator;
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
	public Job createJob( Step step1) {
		return jobBuilderFactory.get("MyJob")
				.incrementer(new RunIdIncrementer())
				.flow(step1)
				.end()
				.build();
	}

	@Bean
	public Step createStep(SocialNetworkingKataWriter snkWriter) {
		return stepBuilderFactory.get("MyStep")
				.<String, SocialNetworkingKataCommand> chunk(1)
				.reader(consoleInputReader)
				.processor(processor())
				.writer(snkWriter)
				.build();
	}
	
}
