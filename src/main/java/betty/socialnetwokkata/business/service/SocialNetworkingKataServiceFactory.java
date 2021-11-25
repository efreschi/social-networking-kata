package betty.socialnetwokkata.business.service;

import betty.socialnetwokkata.command.SocialNetworkingKataCommand;

public interface SocialNetworkingKataServiceFactory {

	SocialNetworkingKataService<SocialNetworkingKataCommand> getSocialNetworkingKataService(String name);
	
}
