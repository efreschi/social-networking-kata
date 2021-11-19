package betty.business.service;

import betty.business.model.MessageModel;
import betty.business.repository.MessageRepository;

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
