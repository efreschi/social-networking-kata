package betty.socialnetwokkata.business.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import betty.socialnetwokkata.command.FollowsCommand;

public class FollowsServiceTest {

	@Test
	public void testAliceFollowsCharlie() {
		UserService service = mock(UserService.class);
		FollowsService followEvent = new FollowsService(service);
		String username = "Alice";
		String followed = "Charlie";
		FollowsCommand command = 
				FollowsCommand.builder().username(username).followed(followed).build();
		followEvent.execute(command);
		
		verify(service).follow(username, followed);
	}
}
