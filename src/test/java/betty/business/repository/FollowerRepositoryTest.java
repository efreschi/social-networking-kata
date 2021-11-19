package betty.business.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import betty.business.model.UserModel;

public class FollowerRepositoryTest {
	
	@Test
	public void testCharlieFollowerDiAliceAndBob() {
		FollowerRepository repo = new FollowerRepository();
		UserModel charlie = new UserModel()
				.setUsername("Charlie");
		List<UserModel> seguiti = repo.findUsersByFollower(charlie);
		assertThat(seguiti).isNullOrEmpty();
		
		UserModel alice = new UserModel()
				.setUsername("Alice");	
		
		repo.addFollower(charlie, alice);
		seguiti = repo.findUsersByFollower(charlie);
		
		assertThat(seguiti).isEqualTo(Arrays.asList(alice));
		
		UserModel bob = new UserModel()
				.setUsername("Bob");	
		
		repo.addFollower(charlie, bob);
		seguiti = repo.findUsersByFollower(charlie);
		
		assertThat(seguiti).isEqualTo(Arrays.asList(alice, bob));
	}

}
