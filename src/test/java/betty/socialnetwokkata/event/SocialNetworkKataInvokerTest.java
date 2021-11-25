package betty.socialnetwokkata.event;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import betty.socialnetwokkata.business.service.FollowsService;
import betty.socialnetwokkata.business.service.PostService;
import betty.socialnetwokkata.business.service.ReadService;
import betty.socialnetwokkata.business.service.WallService;
import betty.socialnetwokkata.event.SocialNetworkKataInvoker;

public class SocialNetworkKataInvokerTest {

    @Test
	public void testAliceReadIstruzione() {
    	PostService pe = mock(PostService.class);
    	ReadService re = mock(ReadService.class);
    	WallService we = mock(WallService.class);
    	FollowsService fe = mock(FollowsService.class);
    	
		String username = "Alice";
		String istruzione = username;
		
		SocialNetworkKataInvoker ki = new SocialNetworkKataInvoker(pe, re, we, fe);
		ki.invoke(istruzione);
		
		verify(re).eseguiEvento(username, new String[] {});
	}

    @Test
	public void testAlicePostMessageIstruzione() {
    	PostService pe = mock(PostService.class);
    	ReadService re = mock(ReadService.class);
    	WallService we = mock(WallService.class);
    	FollowsService fe = mock(FollowsService.class);
    	
		String username = "Alice";
		String istruzione = username + " -> Messaggio Alice";
		
		SocialNetworkKataInvoker ki = new SocialNetworkKataInvoker(pe, re, we, fe);
		ki.invoke(istruzione);
		
		verify(pe).eseguiEvento(username, new String[] {"Messaggio Alice"});
	}

    @Test
	public void testAliceWallIstruzione() {
    	PostService pe = mock(PostService.class);
    	ReadService re = mock(ReadService.class);
    	WallService we = mock(WallService.class);
    	FollowsService fe = mock(FollowsService.class);
    	
		String username = "Alice";
		String istruzione = username + " wall";
		
		SocialNetworkKataInvoker ki = new SocialNetworkKataInvoker(pe, re, we, fe);
		ki.invoke(istruzione);
		
		verify(we).eseguiEvento(username, new String[] {});
	}

    @Test
	public void testAliceFollowsCharlieIstruzione() {
    	PostService pe = mock(PostService.class);
    	ReadService re = mock(ReadService.class);
    	WallService we = mock(WallService.class);
    	FollowsService fe = mock(FollowsService.class);
    	
		String username = "Alice";
		String istruzione = username + " follows Charlie";
		
		SocialNetworkKataInvoker ki = new SocialNetworkKataInvoker(pe, re, we, fe);
		ki.invoke(istruzione);
		
		verify(fe).eseguiEvento(username, new String[] {"Charlie"});
	}
}
