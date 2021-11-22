package betty.socialnetwokkata.business.support;

import betty.socialnetwokkata.business.model.MessageModel;
import betty.socialnetwokkata.business.model.UserModel;

public class MessageModelBuilder {

	public static MessageModel buildMessage(String username, String message) {
		UserModel u = new UserModel().setUsername(username);
		return new MessageModel().setUser(u).setMessage(message);
	}
}
