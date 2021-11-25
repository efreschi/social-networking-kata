package betty.socialnetwokkata.step;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import betty.socialnetwokkata.event.FollowsEvent;
import betty.socialnetwokkata.event.PostEvent;
import betty.socialnetwokkata.event.ReadEvent;
import betty.socialnetwokkata.event.SocialNetworkKataEvent;
import betty.socialnetwokkata.event.WallEvent;

@Component
public class SocialNetworkingKataWriter implements ItemWriter<String> {

	private static final String POST_OP = "->";
	private static final String READ_OP = "";
	private static final String WALL_OP = "wall";
	private static final String FOLLOW_OP = "follows";
	
	
	private Map<String, SocialNetworkKataEvent> mappaIstruzioneEvento = new HashMap<String, SocialNetworkKataEvent>();

	@Autowired
	private PostEvent pe;
	@Autowired
	private ReadEvent re;
	@Autowired
	private WallEvent we;
	@Autowired
	private FollowsEvent fe;
	
	public SocialNetworkingKataWriter(PostEvent pe, ReadEvent re, WallEvent we, FollowsEvent fe) {
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
	
	@Override
	public void write(List<? extends String> items) throws Exception {
		for (String istruzione : items) {
			invoke(istruzione);
		}
		
	}


	protected void invoke(String istruzione) {
		List<String> istruzioni = istruzioni(istruzione.trim());
		SocialNetworkKataEvent event = retrieveEvent(istruzioni);
		String username = istruzioni.get(0);
		String[] args = Optional.of(istruzioni)
				.filter(i -> i.size() > 2)
				.map(l -> l.subList(2, l.size()))
				.map(l -> l.toArray(new String[0]))
				.orElseGet(() -> new String[] {});
		event.eseguiEvento(username, args);
	}
	
	protected SocialNetworkKataEvent retrieveEvent(List<String> istruzioni) {
		return mappaIstruzioneEvento.getOrDefault(
				Optional.of(istruzioni)
					.filter(i -> i.size() > 1)
					.map(l -> l.get(1))
					.orElseGet(() -> ""), re);
	}
	
	protected List<String> istruzioni(String istruzione) {
		return Arrays.asList(istruzione.split(" ", 3));		
	}
}
