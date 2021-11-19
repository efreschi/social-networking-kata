package betty.business.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import betty.business.model.MessageModel;
import betty.business.model.UserModel;
import betty.business.support.MessageModelBuilder;
import betty.business.time.Clock;

public class MessageRepositoryTest {
	
	private Clock clock = mock(Clock.class);
	
	@Test
	public void testScrivoeLeggoMessaggiUtente() {
		MessageRepository repo = new MessageRepository(clock);
		UserModel u = new UserModel().setUsername("Alice");
		when(clock.nowDateTime()).thenReturn(LocalDateTime.of(2021, 11, 19, 23, 52, 1));
		MessageModel message1 = MessageModelBuilder.buildMessage(u.getUsername(), "Messaggio 1");
		repo.save(message1);
		when(clock.nowDateTime()).thenReturn(LocalDateTime.of(2021, 11, 19, 23, 52, 2));
		MessageModel message2 = MessageModelBuilder.buildMessage(u.getUsername(), "Messaggio 2");
		repo.save(message2);
		when(clock.nowDateTime()).thenReturn(LocalDateTime.of(2021, 11, 19, 23, 52, 3));
		MessageModel messageBob = MessageModelBuilder.buildMessage("Bob", "Messaggio Bob");
		repo.save(messageBob);
		MessageModel message3 = MessageModelBuilder.buildMessage(u.getUsername(), "Messaggio 3");
		repo.save(message3);
		
		List<MessageModel> messaggiAlice = repo.findByUser(u);
		
		assertThat(messaggiAlice).isEqualTo(Arrays.asList(message3, message2, message1));
		
	}

}
