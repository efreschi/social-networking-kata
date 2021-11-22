package betty.socialnetwokkata.business.service;

import java.util.List;

import betty.socialnetwokkata.business.model.MessageModel;
import betty.socialnetwokkata.business.model.UserModel;
import betty.socialnetwokkata.business.repository.FollowerRepository;
import betty.socialnetwokkata.business.repository.MessageRepository;

public class MessageQueryService {
	
	private MessageRepository repository;
	private FollowerRepository followerRepository;
	
	public MessageQueryService(MessageRepository repository, FollowerRepository followerRepository) {
		super();
		this.repository = repository;
		this.followerRepository  = followerRepository;
	}

	public List<MessageModel> read(UserModel user) {
		return repository.findByUser(user);
	}

	public List<MessageModel> wall(UserModel user) {
		return repository.findByUsers(followerRepository.findUsersByFollower(user));
	}
}
