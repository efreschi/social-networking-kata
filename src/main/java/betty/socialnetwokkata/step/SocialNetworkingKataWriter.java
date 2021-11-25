package betty.socialnetwokkata.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import betty.socialnetwokkata.business.service.SocialNetworkingKataService;
import betty.socialnetwokkata.business.service.SocialNetworkingKataServiceFactory;
import betty.socialnetwokkata.command.SocialNetworkingKataCommand;

@Component
public class SocialNetworkingKataWriter implements ItemWriter<SocialNetworkingKataCommand> {

	@Autowired
	private SocialNetworkingKataServiceFactory factory;
	
	public SocialNetworkingKataWriter(SocialNetworkingKataServiceFactory factory) {
		super();
		this.factory = factory;
	}
	
	@Override
	public void write(List<? extends SocialNetworkingKataCommand> items) throws Exception {
		for (SocialNetworkingKataCommand command : items) {
			invoke(command);
		}
		
	}


	protected void invoke(SocialNetworkingKataCommand istruzione) {
		SocialNetworkingKataService<SocialNetworkingKataCommand> service =
				factory.getSocialNetworkingKataService(istruzione.getClass().getSimpleName());
		service.execute(istruzione);
	}
}
