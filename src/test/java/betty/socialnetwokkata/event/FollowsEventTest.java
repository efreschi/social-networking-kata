package betty.socialnetwokkata.event;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import betty.socialnetwokkata.business.service.FollowsService;
import betty.socialnetwokkata.business.service.UserService;
import betty.socialnetwokkata.business.support.UserModel;

public class FollowsEventTest {
	
    @Test
	public void testAliceFollowsCharlie() {
		UserService service = mock(UserService.class);
    	FollowsService followEvent = new FollowsService(service);
		UserModel alice = new UserModel().setUsername("Alice");
		UserModel charlie = new UserModel().setUsername("Charlie");
		
		followEvent.eseguiEvento(alice.getUsername(), charlie.getUsername());
		
		verify(service).follow(alice.getUsername(), charlie.getUsername());
	}

}
