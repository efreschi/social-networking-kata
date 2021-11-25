package betty.socialnetwokkata.business.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import betty.socialnetwokkata.business.entity.Message;
import betty.socialnetwokkata.business.repository.MessageJpaRepository;

@Service
public class MessageQueryService {
	
	@Autowired
	private MessageJpaRepository repository;
	
	public MessageQueryService(MessageJpaRepository repository) {
		super();
		this.repository = repository;
	}

	public List<Message> read(String username) {
		return repository.findByUsername(username).stream()
				.sorted(Comparator.comparing(Message::getTime).reversed())
				.collect(Collectors.toList());
	}

	public List<Message> wall(String username) { 
		return repository.findByUsernameOrFollower(username).stream()
				.sorted(Comparator.comparing(Message::getTime).reversed())
				.collect(Collectors.toList());
	}
}
