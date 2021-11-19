package betty.business.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import betty.business.model.UserModel;
import betty.business.repository.FollowerRepository;

public class UserServiceTest {

	private FollowerRepository repo = mock(FollowerRepository.class);
	
	@Test
	public void testCharlieFollowsAlice() {
		UserService us = new UserService(repo);
		UserModel charlie = new UserModel().setUsername("Charlie");
		UserModel alice = new UserModel().setUsername("Alice");
		us.follow(charlie, alice);
		
		verify(repo).addFollower(charlie, alice);
	}

}
