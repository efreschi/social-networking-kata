package betty.socialnetwokkata.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import betty.socialnetwokkata.business.service.MessageService;
import betty.socialnetwokkata.business.support.MessageModelBuilder;

@Component
public class PostEvent implements SocialNetworkKataEvent {

	@Autowired
	private MessageService service;
	
	public PostEvent(MessageService service) {
		super();
		this.service = service;
	}


	protected void eseguiEvento(String username, String message) {
		service.post(MessageModelBuilder.buildMessage(username, message));
	}


	@Override
	public void eseguiEvento(String username, String... args) {
		eseguiEvento(username, args[0]);
	}
}
