package betty.socialnetwokkata.business.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import betty.socialnetwokkata.business.model.MessageModel;
import betty.socialnetwokkata.business.model.UserModel;
import betty.socialnetwokkata.business.repository.MessageRepository;
import betty.socialnetwokkata.business.support.MessageModelBuilder;
import betty.socialnetwokkata.business.time.Clock;

public class MessageRepositoryTest {
	
	private Clock clock = mock(Clock.class);

	@Test
	public void testAliceBobScrivonoMessaggiELeggoMessagiAlice() {
		MessageRepository repo = new MessageRepository(clock);
		UserModel alice = new UserModel().setUsername("Alice");
		when(clock.nowDateTime()).thenReturn(LocalDateTime.of(2021, 11, 19, 23, 52, 1));
		MessageModel message1 = MessageModelBuilder.buildMessage(alice.getUsername(), "Messaggio 1");
		repo.save(message1);
		when(clock.nowDateTime()).thenReturn(LocalDateTime.of(2021, 11, 19, 23, 52, 2));
		MessageModel message2 = MessageModelBuilder.buildMessage(alice.getUsername(), "Messaggio 2");
		repo.save(message2);
		when(clock.nowDateTime()).thenReturn(LocalDateTime.of(2021, 11, 19, 23, 52, 3));
		MessageModel messageBob = MessageModelBuilder.buildMessage("Bob", "Messaggio Bob");
		repo.save(messageBob);
		MessageModel message3 = MessageModelBuilder.buildMessage(alice.getUsername(), "Messaggio 3");
		repo.save(message3);
		
		List<MessageModel> messaggiAlice = repo.findByUser(alice);
		
		assertThat(messaggiAlice).isEqualTo(Arrays.asList(message3, message2, message1));
	}

	@Test
	public void testAliceBobScrivonoMessaggiELeggoMessagiAliceBob() {
		MessageRepository repo = new MessageRepository(clock);
		UserModel alice = new UserModel().setUsername("Alice");
		when(clock.nowDateTime()).thenReturn(LocalDateTime.of(2021, 11, 19, 23, 52, 1));
		MessageModel message1 = MessageModelBuilder.buildMessage(alice.getUsername(), "Messaggio 1");
		repo.save(message1);
		when(clock.nowDateTime()).thenReturn(LocalDateTime.of(2021, 11, 19, 23, 52, 2));
		MessageModel message2 = MessageModelBuilder.buildMessage(alice.getUsername(), "Messaggio 2");
		repo.save(message2);
		when(clock.nowDateTime()).thenReturn(LocalDateTime.of(2021, 11, 19, 23, 52, 3));
		UserModel bob = new UserModel().setUsername("Bob");
		MessageModel messageBob = MessageModelBuilder.buildMessage(bob.getUsername(), "Messaggio Bob");
		repo.save(messageBob);
		when(clock.nowDateTime()).thenReturn(LocalDateTime.of(2021, 11, 19, 23, 52, 4));
		MessageModel message3 = MessageModelBuilder.buildMessage(alice.getUsername(), "Messaggio 3");
		repo.save(message3);
		
		List<MessageModel> messaggiAlice = repo.findByUsers(Arrays.asList(alice, bob));
		
		assertThat(messaggiAlice).isEqualTo(Arrays.asList(message3,messageBob,  message2, message1));
	}
}
