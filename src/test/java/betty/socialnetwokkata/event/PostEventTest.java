package betty.socialnetwokkata.event;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import betty.socialnetwokkata.business.entity.Message;
import betty.socialnetwokkata.business.model.MessageModel;
import betty.socialnetwokkata.business.model.UserModel;
import betty.socialnetwokkata.business.service.MessageService;
import betty.socialnetwokkata.business.service.PostService;
import betty.socialnetwokkata.business.support.MessageModelBuilder;

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
		MessageModel mAlice = MessageModelBuilder.buildMessage(alice.getUsername(), "Messaggio Alice");  
		
		pe.eseguiEvento(alice.getUsername(), mAlice.getMessage());
		
		verify(service).post(Message.builder().username(mAlice.getUser().getUsername()).message(mAlice.getMessage()).build());
	}

}
