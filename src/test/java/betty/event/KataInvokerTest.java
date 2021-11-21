package betty.event;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class KataInvokerTest {

	private ReadEvent re = mock(ReadEvent.class);
	
    @AfterEach
    void clear() {
        reset(re);
    }

    @Test
	public void testAliceReadIstruzione() {
		String username = "Alice";
		String istruzione = username;
		
		KataInvoker ki = new KataInvoker(re);
		ki.invoke(istruzione);
		
		verify(re).eseguiEvento(username);
	}
}
