package betty.socialnetwokkata.business.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import betty.socialnetwokkata.business.entity.Message;
import betty.socialnetwokkata.command.PostCommand;

public class PostServiceTest {

	@Test
	public void testAlicePostMessage() {
		MessageService messageService = mock(MessageService.class);
		PostService service = new PostService(messageService);
		String username = "Alice";
		String message = "Messaggio Alice";
		PostCommand command = 
				PostCommand.builder().username(username).message(message).build();
		service.execute(command);
		
		verify(messageService).post(Message.builder().username(username).message(message).build());
	}
}
