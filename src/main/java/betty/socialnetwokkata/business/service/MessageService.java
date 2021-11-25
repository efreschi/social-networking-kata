package betty.socialnetwokkata.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import betty.socialnetwokkata.business.entity.Message;
import betty.socialnetwokkata.business.repository.MessageJpaRepository;
import betty.socialnetwokkata.business.time.Clock;

@Service
public class MessageService {
	
	@Autowired
	private MessageJpaRepository repository;
	
	@Autowired
	private Clock clock;
	
	public MessageService(MessageJpaRepository repository, Clock clock) {
		super();
		this.repository = repository;
		this.clock = clock;
	}

	public void post(Message message) {
		message.setTime(clock.nowDateTime());
		repository.save(message);
	}

}
