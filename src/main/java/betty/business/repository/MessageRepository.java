package betty.business.repository;

import java.util.HashSet;
import java.util.Set;

import betty.business.model.MessageModel;
import betty.business.time.Clock;

public class MessageRepository {
	
	private static final Set<MessageModel> messaggi = new HashSet<MessageModel>();
	
	private Clock clock;

	public MessageRepository(Clock clock) {
		super();
		this.clock = clock;
	}
	
	public void save(MessageModel message) {
		message.setTime(clock.nowDateTime());
		messaggi.add(message);
	}

}
