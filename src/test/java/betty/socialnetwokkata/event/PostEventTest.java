package betty.socialnetwokkata.event;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import betty.socialnetwokkata.business.model.MessageModel;
import betty.socialnetwokkata.business.model.UserModel;
import betty.socialnetwokkata.business.service.MessageService;
import betty.socialnetwokkata.business.support.MessageModelBuilder;
import betty.socialnetwokkata.event.PostEvent;

public class PostEventTest {
	
	private MessageService service = mock(MessageService.class);
	
    @AfterEach
    void clear() {
        reset(service);
    }

    @Test
	public void testPostAlice() {
		PostEvent pe = new PostEvent(service);
		UserModel alice = new UserModel().setUsername("Alice");
		MessageModel mAlice = MessageModelBuilder.buildMessage(alice.getUsername(), "Messaggio Alice");  
		
		pe.eseguiEvento(alice.getUsername(), mAlice.getMessage());
		
		verify(service).post(MessageModelBuilder.buildMessage(alice.getUsername(), "Messaggio Alice"));
	}

}
