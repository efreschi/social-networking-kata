package betty.business.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import betty.business.model.MessageModel;
import betty.business.model.UserModel;
import betty.business.repository.MessageRepository;

public class MessageServiceTest {
	
	private MessageRepository mr = mock(MessageRepository.class);
	
	
	@Test
	public void testPostWithMessageThenOK() {
		MessageService ms = new MessageService(mr);
		MessageModel message = buildMessage("Alice", "Messaggio");
		ms.post(message);
		verify(mr).save(message);
	}
	
	private MessageModel buildMessage(String username, String message) {
		UserModel u = new UserModel().setUsername(username);
		return new MessageModel().setUser(u).setMessage(message);
	}
}
