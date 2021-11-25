package betty.socialnetwokkata.business.service;

import betty.socialnetwokkata.command.SocialNetworkingKataCommand;

public interface SocialNetworkingKataService<C extends SocialNetworkingKataCommand> {

	public void execute(C command); 
}
