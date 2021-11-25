package betty.socialnetwokkata.business.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import betty.socialnetwokkata.business.entity.Message;
import betty.socialnetwokkata.business.repository.MessageJpaRepository;
import betty.socialnetwokkata.business.time.Clock;

public class MessageServiceTest {
	
	@Test
	public void testPostWithMessageThenOK() {
		MessageJpaRepository mr = mock(MessageJpaRepository.class);
		Clock clock = mock(Clock.class);
		when(clock.nowDateTime()).thenReturn(LocalDateTime.of(2021, 11, 19, 23, 52, 1));
		MessageService ms = new MessageService(mr, clock);
		Message message = Message.builder().username("Alice").message("Messaggio").build();
		ms.post(message);
		verify(mr).save(message);
	}
	}
