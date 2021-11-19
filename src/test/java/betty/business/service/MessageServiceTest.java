package betty.business.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import betty.business.model.MessageModel;
import betty.business.repository.MessageRepository;
import betty.business.support.MessageModelBuilder;

public class MessageServiceTest {
	
	private MessageRepository mr = mock(MessageRepository.class);
	
	@Test
	public void testPostWithMessageThenOK() {
		MessageService ms = new MessageService(mr);
		MessageModel message = MessageModelBuilder.buildMessage("Alice", "Messaggio");
		ms.post(message);
		verify(mr).save(message);
	}
	}
