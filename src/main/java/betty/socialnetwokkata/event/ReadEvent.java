package betty.socialnetwokkata.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import betty.socialnetwokkata.business.model.UserModel;
import betty.socialnetwokkata.business.service.MessageQueryService;
import betty.socialnetwokkata.print.PrintMessageConsole;

@Component
public class ReadEvent implements SocialNetworkKataEvent {

	@Autowired
	private MessageQueryService service;
	@Autowired
	private PrintMessageConsole printMessageConsole;
	
	public ReadEvent(MessageQueryService service, PrintMessageConsole printMessageConsole) {
		super();
		this.service = service;
		this.printMessageConsole = printMessageConsole;
	}


	protected void eseguiEvento(String username) {
		printMessageConsole.print(service.read(new UserModel().setUsername(username)));
	}


	@Override
	public void eseguiEvento(String username, String... args) {
		eseguiEvento(username);
	}
}
