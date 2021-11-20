package betty.business.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import betty.business.model.MessageModel;
import betty.business.model.UserModel;
import betty.business.repository.FollowerRepository;
import betty.business.repository.MessageRepository;
import betty.business.support.MessageModelBuilder;

public class MessageQueryServiceTest {
	
	private MessageRepository mr = mock(MessageRepository.class);
	private FollowerRepository fr = mock(FollowerRepository.class);
	
	@Test
	public void testReadMessagesByUser() {
		MessageQueryService mqs = new MessageQueryService(mr, null);
		
		UserModel u = new UserModel().setUsername("Alice");
		MessageModel message1 = MessageModelBuilder.buildMessage(u.getUsername(), "Messaggio 1");
		MessageModel message2 = MessageModelBuilder.buildMessage(u.getUsername(), "Messaggio 2");
		List<MessageModel> messagesByUserExpected = Arrays.asList(message2, message1);
		when(mr.findByUser(u)).thenReturn(messagesByUserExpected);
		
		List<MessageModel> messagesByUser = mqs.read(u);
		
		assertThat(messagesByUser).isEqualTo(messagesByUserExpected);
	}

	@Test
	public void testWallUser() {
		MessageQueryService mqs = new MessageQueryService(mr, fr);
		
		UserModel alice = new UserModel().setUsername("Alice");
		MessageModel message1 = MessageModelBuilder.buildMessage(alice.getUsername(), "Messaggio 1");
		MessageModel message2 = MessageModelBuilder.buildMessage(alice.getUsername(), "Messaggio 2");
		UserModel bob = new UserModel().setUsername("Bob");
		MessageModel messageBob = MessageModelBuilder.buildMessage(bob.getUsername(), "Messaggio 1");
		List<MessageModel> messagesByUserExpected = Arrays.asList(messageBob, message2, message1);
		when(fr.findUsersByFollower(bob)).thenReturn(Arrays.asList(bob, alice));
		when(mr.findByUsers(Arrays.asList(bob, alice))).thenReturn(messagesByUserExpected);
		
		List<MessageModel> wall = mqs.wall(bob);
		
		assertThat(wall).isEqualTo(messagesByUserExpected);
	}
}
