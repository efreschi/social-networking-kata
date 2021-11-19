package betty.business.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import betty.business.model.MessageModel;
import betty.business.model.UserModel;
import betty.business.repository.MessageRepository;
import betty.business.support.MessageModelBuilder;

public class MessageQueryServiceTest {
	
	private MessageRepository mr = mock(MessageRepository.class);
	
	@Test
	public void testReadMessagesByUser() {
		MessageQueryService mqs = new MessageQueryService(mr);
		
		UserModel u = new UserModel().setUsername("Alice");
		MessageModel message1 = MessageModelBuilder.buildMessage(u.getUsername(), "Messaggio 1");
		MessageModel message2 = MessageModelBuilder.buildMessage(u.getUsername(), "Messaggio 2");
		List<MessageModel> messagesByUserExpected = Arrays.asList(message2, message1);
		when(mr.findByUser(u)).thenReturn(messagesByUserExpected);
		
		List<MessageModel> messagesByUser = mqs.read(u);
		
		assertThat(messagesByUser).isEqualTo(messagesByUserExpected);
	}
}
