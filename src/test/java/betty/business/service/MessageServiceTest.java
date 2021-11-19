package betty.business.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MessageServiceTest {
	
	private MessageService ms;
	
	
	@Test
	public void testPostWithMessageThenOK() {
		ms = new MessageService();
		Long res = ms.post(null);
		assertThat(res).isEqualTo(1L);
	}
}
