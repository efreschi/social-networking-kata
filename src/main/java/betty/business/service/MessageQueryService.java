package betty.business.service;

import java.util.List;

import betty.business.model.MessageModel;
import betty.business.model.UserModel;
import betty.business.repository.MessageRepository;

public class MessageQueryService {
	
	private MessageRepository repository;
	
	public MessageQueryService(MessageRepository repository) {
		super();
		this.repository = repository;
	}

	public List<MessageModel> read(UserModel user) {
		return repository.findByUser(user);
	}

}
