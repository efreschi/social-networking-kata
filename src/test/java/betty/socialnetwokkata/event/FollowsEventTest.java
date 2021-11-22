package betty.socialnetwokkata.event;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import betty.socialnetwokkata.business.model.UserModel;
import betty.socialnetwokkata.business.service.UserService;
import betty.socialnetwokkata.event.FollowsEvent;

public class FollowsEventTest {
	
    @Test
	public void testAliceFollowsCharlie() {
		UserService service = mock(UserService.class);
    	FollowsEvent followEvent = new FollowsEvent(service);
		UserModel alice = new UserModel().setUsername("Alice");
		UserModel charlie = new UserModel().setUsername("Charlie");
		
		followEvent.eseguiEvento(alice.getUsername(), charlie.getUsername());
		
		verify(service).follow(alice, charlie);
	}

}
