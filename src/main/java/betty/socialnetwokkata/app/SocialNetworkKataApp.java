package betty.socialnetwokkata.app;

import java.util.Scanner;

import betty.socialnetwokkata.business.repository.FollowerRepository;
import betty.socialnetwokkata.business.repository.MessageRepository;
import betty.socialnetwokkata.business.service.MessageQueryService;
import betty.socialnetwokkata.business.service.MessageService;
import betty.socialnetwokkata.business.service.UserService;
import betty.socialnetwokkata.business.time.Clock;
import betty.socialnetwokkata.event.FollowsEvent;
import betty.socialnetwokkata.event.PostEvent;
import betty.socialnetwokkata.event.ReadEvent;
import betty.socialnetwokkata.event.SocialNetworkKataInvoker;
import betty.socialnetwokkata.event.WallEvent;
import betty.socialnetwokkata.print.Console;
import betty.socialnetwokkata.print.FormatDateTime;
import betty.socialnetwokkata.print.PrintMessageConsole;
import betty.socialnetwokkata.print.PrintUserMessageConsole;


public class SocialNetworkKataApp {

	public static void main(String[] args) {
		SocialNetworkKataApp main = new SocialNetworkKataApp();
		SocialNetworkKataEngine engine = main.inizializzaEngine();
		engine.run();
	}
	
	public SocialNetworkKataEngine inizializzaEngine() {
		Console console = new Console();
		console.setScanner(new Scanner(System.in));
		Clock clock = new Clock();
		FormatDateTime formatter = new FormatDateTime(clock);
		PrintMessageConsole pmc = new PrintMessageConsole(console, formatter);
		PrintUserMessageConsole pumc = new PrintUserMessageConsole(console, formatter);
		
		MessageRepository messageRepo = new MessageRepository(clock);
		FollowerRepository followerRepo = new FollowerRepository();
		
		MessageQueryService messageQuery = new MessageQueryService(messageRepo, followerRepo);
		MessageService messageService = new MessageService(messageRepo);
		UserService userService = new UserService(followerRepo);
				
		
		ReadEvent readE = new ReadEvent(messageQuery, pmc);
		PostEvent postE = new PostEvent(messageService);
		WallEvent wallE = new WallEvent(messageQuery, pumc);
		FollowsEvent followsE = new FollowsEvent(userService);
		
		SocialNetworkKataInvoker invoker = new SocialNetworkKataInvoker(postE, readE, wallE, followsE);
		
		return new SocialNetworkKataEngine(console, invoker);
	}

}
