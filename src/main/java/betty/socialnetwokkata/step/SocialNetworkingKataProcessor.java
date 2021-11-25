package betty.socialnetwokkata.step;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.batch.item.ItemProcessor;

import betty.socialnetwokkata.command.FollowsCommand;
import betty.socialnetwokkata.command.PostCommand;
import betty.socialnetwokkata.command.ReadCommand;
import betty.socialnetwokkata.command.SocialNetworkingKataCommand;
import betty.socialnetwokkata.command.WallCommand;
import lombok.SneakyThrows;

public class SocialNetworkingKataProcessor implements ItemProcessor<String, SocialNetworkingKataCommand> {

	private static final String POST_OP = "->";
	private static final String READ_OP = "";
	private static final String WALL_OP = "wall";
	private static final String FOLLOW_OP = "follows";
	
	private Map<String, Class<? extends SocialNetworkingKataCommand>> mappaIstruzioneEvento = new HashMap<String, Class<? extends SocialNetworkingKataCommand>>();
	
	public SocialNetworkingKataProcessor() {
		super();
		mappaIstruzioneEvento.put(POST_OP, PostCommand.class);
		mappaIstruzioneEvento.put(WALL_OP, WallCommand.class);
		mappaIstruzioneEvento.put(READ_OP, ReadCommand.class);
		mappaIstruzioneEvento.put(FOLLOW_OP, FollowsCommand.class);
	}
	
	

	@Override
	public SocialNetworkingKataCommand process(String istruzione) throws Exception {
		if (istruzione == null) {
			return null;
		}
		List<String> istruzioni = istruzioni(istruzione.trim());
		SocialNetworkingKataCommand command = retrieveCommand(istruzioni);
		String username = istruzioni.get(0);
		String[] args = Optional.of(istruzioni)
				.filter(i -> i.size() > 2)
				.map(l -> l.subList(2, l.size()))
				.map(l -> l.toArray(new String[0]))
				.orElseGet(() -> new String[] {});
		command.populate(username, args);
		return command;
	}

	
	protected List<String> istruzioni(String istruzione) {
		return Arrays.asList(istruzione.split(" ", 3));		
	}
	
    @SneakyThrows
	protected SocialNetworkingKataCommand retrieveCommand(List<String> istruzioni) {
		return retrieveTypeCommand(istruzioni).getDeclaredConstructor().newInstance();
	}

	
	protected Class<? extends SocialNetworkingKataCommand> retrieveTypeCommand(List<String> istruzioni) {
		return mappaIstruzioneEvento.getOrDefault(
				Optional.of(istruzioni)
					.filter(i -> i.size() > 1)
					.map(l -> l.get(1))
					.orElseGet(() -> ""), ReadCommand.class);
	}
}
