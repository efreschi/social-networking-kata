package betty.socialnetwokkata.step;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import betty.socialnetwokkata.event.FollowsEvent;
import betty.socialnetwokkata.event.PostEvent;
import betty.socialnetwokkata.event.ReadEvent;
import betty.socialnetwokkata.event.WallEvent;

public class SocialNetworkingKataWriterTest {

    @Test
	public void testAliceReadIstruzione() {
    	PostEvent pe = mock(PostEvent.class);
    	ReadEvent re = mock(ReadEvent.class);
    	WallEvent we = mock(WallEvent.class);
    	FollowsEvent fe = mock(FollowsEvent.class);
    	
		String username = "Alice";
		String istruzione = username;
		
		SocialNetworkingKataWriter ki = new SocialNetworkingKataWriter(pe, re, we, fe);
		ki.invoke(istruzione);
		
		verify(re).eseguiEvento(username, new String[] {});
	}

    @Test
	public void testAlicePostMessageIstruzione() {
    	PostEvent pe = mock(PostEvent.class);
    	ReadEvent re = mock(ReadEvent.class);
    	WallEvent we = mock(WallEvent.class);
    	FollowsEvent fe = mock(FollowsEvent.class);
    	
		String username = "Alice";
		String istruzione = username + " -> Messaggio Alice";
		
		SocialNetworkingKataWriter ki = new SocialNetworkingKataWriter(pe, re, we, fe);
		ki.invoke(istruzione);
		
		verify(pe).eseguiEvento(username, new String[] {"Messaggio Alice"});
	}

    @Test
	public void testAliceWallIstruzione() {
    	PostEvent pe = mock(PostEvent.class);
    	ReadEvent re = mock(ReadEvent.class);
    	WallEvent we = mock(WallEvent.class);
    	FollowsEvent fe = mock(FollowsEvent.class);
    	
		String username = "Alice";
		String istruzione = username + " wall";
		
		SocialNetworkingKataWriter ki = new SocialNetworkingKataWriter(pe, re, we, fe);
		ki.invoke(istruzione);
		
		verify(we).eseguiEvento(username, new String[] {});
	}

    @Test
	public void testAliceFollowsCharlieIstruzione() {
    	PostEvent pe = mock(PostEvent.class);
    	ReadEvent re = mock(ReadEvent.class);
    	WallEvent we = mock(WallEvent.class);
    	FollowsEvent fe = mock(FollowsEvent.class);
    	
		String username = "Alice";
		String istruzione = username + " follows Charlie";
		
		SocialNetworkingKataWriter ki = new SocialNetworkingKataWriter(pe, re, we, fe);
		ki.invoke(istruzione);
		
		verify(fe).eseguiEvento(username, new String[] {"Charlie"});
	}
}
