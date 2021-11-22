package betty.socialnetwokkata.business.service;

import betty.socialnetwokkata.business.model.MessageModel;
import betty.socialnetwokkata.business.repository.MessageRepository;

public class MessageService {
	
	private MessageRepository repository;
	
	public MessageService(MessageRepository repository) {
		super();
		this.repository = repository;
	}

	public void post(MessageModel message) {
		repository.save(message);
	}

}
