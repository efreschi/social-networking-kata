package betty.business.repository;

import java.util.HashSet;
import java.util.Set;

import betty.business.model.MessageModel;

public class MessageRepository {
	
	private static final Set<MessageModel> messaggi = new HashSet<MessageModel>();
	
	public void save(MessageModel messagge) {
		messaggi.add(messagge);
	}

}
