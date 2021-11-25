package betty.socialnetwokkata.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import betty.socialnetwokkata.business.model.MessageModel;
import betty.socialnetwokkata.business.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository repository;
	
	public MessageService(MessageRepository repository) {
		super();
		this.repository = repository;
	}

	public void post(MessageModel message) {
		repository.save(message);
	}

}
