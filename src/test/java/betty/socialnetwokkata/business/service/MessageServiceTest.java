package betty.socialnetwokkata.business.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import betty.socialnetwokkata.business.model.MessageModel;
import betty.socialnetwokkata.business.repository.MessageRepository;
import betty.socialnetwokkata.business.service.MessageService;
import betty.socialnetwokkata.business.support.MessageModelBuilder;

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
