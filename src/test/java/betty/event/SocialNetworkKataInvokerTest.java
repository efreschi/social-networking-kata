package betty.event;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

public class SocialNetworkKataInvokerTest {

    @Test
	public void testAliceReadIstruzione() {
    	PostEvent pe = mock(PostEvent.class);
    	ReadEvent re = mock(ReadEvent.class);
    	WallEvent we = mock(WallEvent.class);
    	
		String username = "Alice";
		String istruzione = username;
		
		SocialNetworkKataInvoker ki = new SocialNetworkKataInvoker(pe, re, we);
		ki.invoke(istruzione);
		
		verify(re).eseguiEvento(username, new String[] {});
	}

    @Test
	public void testAlicePostMessageIstruzione() {
    	PostEvent pe = mock(PostEvent.class);
    	ReadEvent re = mock(ReadEvent.class);
    	WallEvent we = mock(WallEvent.class);
    	
		String username = "Alice";
		String istruzione = username + " -> Messaggio Alice";
		
		SocialNetworkKataInvoker ki = new SocialNetworkKataInvoker(pe, re, we);
		ki.invoke(istruzione);
		
		verify(pe).eseguiEvento(username, new String[] {"Messaggio Alice"});
	}

    @Test
	public void testAliceWallIstruzione() {
    	PostEvent pe = mock(PostEvent.class);
    	ReadEvent re = mock(ReadEvent.class);
    	WallEvent we = mock(WallEvent.class);
    	
		String username = "Alice";
		String istruzione = username + " wall";
		
		SocialNetworkKataInvoker ki = new SocialNetworkKataInvoker(pe, re, we);
		ki.invoke(istruzione);
		
		verify(we).eseguiEvento(username, new String[] {});
	}
}
