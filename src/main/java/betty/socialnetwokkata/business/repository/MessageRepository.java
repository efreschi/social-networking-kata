package betty.socialnetwokkata.business.repository;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import betty.socialnetwokkata.business.model.MessageModel;
import betty.socialnetwokkata.business.model.UserModel;
import betty.socialnetwokkata.business.time.Clock;

@Component
public class MessageRepository {
	
	private Set<MessageModel> messaggi = new HashSet<MessageModel>();
	
	private Clock clock;

	public MessageRepository(Clock clock) {
		super();
		this.clock = clock;
	}
	
	public void save(MessageModel message) {
		message.setTime(clock.nowDateTime());
		messaggi.add(message);
	}
	
	public List<MessageModel> findByUser(UserModel user) {
		return findByUsers(Arrays.asList(user));
	}

	public List<MessageModel> findByUsers(List<UserModel> users) {
		return messaggi.stream()
				.filter(m -> users.contains(m.getUser()))
				.sorted(Comparator.comparing(MessageModel::getTime).reversed())
				.collect(Collectors.toList());
	}
}
