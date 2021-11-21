package betty.event;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import betty.business.model.UserModel;
import betty.business.service.UserService;

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
