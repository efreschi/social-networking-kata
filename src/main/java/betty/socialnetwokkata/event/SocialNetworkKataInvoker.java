package betty.socialnetwokkata.event;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SocialNetworkKataInvoker {
	
	private static final String POST_OP = "->";
	private static final String READ_OP = "";
	private static final String WALL_OP = "wall";
	private static final String FOLLOW_OP = "follows";
	
	
	private Map<String, SocialNetworkKataEvent> mappaIstruzioneEvento = new HashMap<String, SocialNetworkKataEvent>();
	private PostEvent pe;
	private ReadEvent re;
	private WallEvent we;
	private FollowsEvent fe;
	
	public SocialNetworkKataInvoker(PostEvent pe, ReadEvent re, WallEvent we, FollowsEvent fe) {
		super();
		this.pe = pe;
		this.re = re;
		this.we = we;
		this.fe = fe;
		mappaIstruzioneEvento.put(POST_OP, this.pe);
		mappaIstruzioneEvento.put(WALL_OP, this.we);
		mappaIstruzioneEvento.put(READ_OP, this.re);
		mappaIstruzioneEvento.put(FOLLOW_OP, this.fe);
	}

	public synchronized void registerIstruzione(String istruzione, SocialNetworkKataEvent evento) {
		mappaIstruzioneEvento.put(istruzione, evento);
	}

	public void invoke(String istruzione) {
		List<String> istruzioni = istruzioni(istruzione);
		SocialNetworkKataEvent event = retrieveEvent(istruzioni);
		String username = istruzioni.get(0);
		String[] args = Optional.of(istruzioni)
				.filter(i -> i.size() > 2)
				.map(l -> l.subList(2, l.size()))
				.map(l -> l.toArray(new String[0]))
				.orElseGet(() -> new String[] {});
		event.eseguiEvento(username, args);
	}
	
	public SocialNetworkKataEvent retrieveEvent(List<String> istruzioni) {
		return mappaIstruzioneEvento.getOrDefault(
				Optional.of(istruzioni)
					.filter(i -> i.size() > 1)
					.map(l -> l.get(1))
					.orElseGet(() -> ""), re);
	}
	
	public List<String> istruzioni(String istruzione) {
		return Arrays.asList(istruzione.split(" ", 3));		
	}
}
