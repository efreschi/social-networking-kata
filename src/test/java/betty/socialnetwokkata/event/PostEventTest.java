package betty.socialnetwokkata.event;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import betty.socialnetwokkata.business.entity.Message;
import betty.socialnetwokkata.business.service.MessageService;
import betty.socialnetwokkata.business.service.PostService;
import betty.socialnetwokkata.business.support.UserModel;

public class PostEventTest {
	
	private MessageService service = mock(MessageService.class);
	
    @AfterEach
    void clear() {
        reset(service);
    }

    @Test
	public void testPostAlice() {
		PostService pe = new PostService(service);
		UserModel alice = new UserModel().setUsername("Alice");
		Message mAlice = Message.builder().username(alice.getUsername()).message("Messaggio Alice").build();  
		
		pe.eseguiEvento(alice.getUsername(), mAlice.getMessage());
		
		verify(service).post(Message.builder().username(mAlice.getUsername()).message(mAlice.getMessage()).build());
	}

}
