package betty.socialnetwokkata.business.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import betty.socialnetwokkata.business.entity.Message;
import betty.socialnetwokkata.business.repository.MessageJpaRepository;
import betty.socialnetwokkata.business.support.UserModel;

public class MessageQueryServiceTest {
	
	private MessageJpaRepository mr = mock(MessageJpaRepository.class);
	
	@Test
	public void testReadMessagesByUser() {
		MessageQueryService mqs = new MessageQueryService(mr);
		
		UserModel u = new UserModel().setUsername("Alice");
		Message message1 = Message.builder().username(u.getUsername()).message("Messaggio 1").build();
		LocalDateTime dt = LocalDateTime.of(2021, 11, 21, 23, 45, 11);
		message1.setTime(dt);
		Message message2 = Message.builder().username(u.getUsername()).message("Messaggio 2").build();
		 dt = LocalDateTime.of(2021, 11, 21, 23, 56, 11);
		message2.setTime(dt);		
		List<Message> messagesByUserExpected = Arrays.asList(message2, message1);
		when(mr.findByUsername(u.getUsername())).thenReturn(messagesByUserExpected);
		
		List<Message> messagesByUser = mqs.read(u.getUsername());
		
		assertThat(messagesByUser).isEqualTo(messagesByUserExpected);
	}

	@Test
	public void testWallUser() {
		MessageQueryService mqs = new MessageQueryService(mr);
		
		UserModel alice = new UserModel().setUsername("Alice");
		Message message1 = Message.builder().username(alice.getUsername()).message("Messaggio 1").build();
		LocalDateTime dt = LocalDateTime.of(2021, 11, 21, 23, 45, 11);
		message1.setTime(dt);
		Message message2 = Message.builder().username(alice.getUsername()).message("Messaggio 2").build();
		dt = LocalDateTime.of(2021, 11, 21, 23, 47, 11);
		message2.setTime(dt);
		UserModel bob = new UserModel().setUsername("Bob");
		Message messageBob = Message.builder().username(bob.getUsername()).message("Messaggio 1").build();
		dt = LocalDateTime.of(2021, 11, 21, 23, 48, 11);
		messageBob.setTime(dt);
		List<Message> messagesByUserExpected = Arrays.asList(messageBob, message2, message1);
		when(mr.findByUsernameOrFollower(bob.getUsername())).thenReturn(messagesByUserExpected);
		
		List<Message> wall = mqs.wall(bob.getUsername());
		
		assertThat(wall).isEqualTo(messagesByUserExpected);
	}
}
