package betty.socialnetwokkata.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import betty.socialnetwokkata.command.ReadCommand;
import betty.socialnetwokkata.event.SocialNetworkKataEvent;
import betty.socialnetwokkata.print.PrintMessageConsole;

@Service("ReadCommand")
public class ReadService implements SocialNetworkKataEvent, SocialNetworkingKataService<ReadCommand> {

	@Autowired
	private MessageQueryService service;
	@Autowired
	private PrintMessageConsole printMessageConsole;
	
	public ReadService(MessageQueryService service, PrintMessageConsole printMessageConsole) {
		super();
		this.service = service;
		this.printMessageConsole = printMessageConsole;
	}


	protected void eseguiEvento(String username) {
		printMessageConsole.print(service.read(username));
	}


	@Override
	public void eseguiEvento(String username, String... args) {
		eseguiEvento(username);
	}


	@Override
	public void execute(ReadCommand command) {
		eseguiEvento(command.getUsername());
	}
}
