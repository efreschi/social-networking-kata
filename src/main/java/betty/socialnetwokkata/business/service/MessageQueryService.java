package betty.socialnetwokkata.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import betty.socialnetwokkata.business.model.MessageModel;
import betty.socialnetwokkata.business.model.UserModel;
import betty.socialnetwokkata.business.repository.FollowerRepository;
import betty.socialnetwokkata.business.repository.MessageRepository;

@Service
public class MessageQueryService {
	
	@Autowired
	private MessageRepository repository;
	@Autowired
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
