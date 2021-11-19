package betty.business.support;

import betty.business.model.MessageModel;
import betty.business.model.UserModel;

public class MessageModelBuilder {

	public static MessageModel buildMessage(String username, String message) {
		UserModel u = new UserModel().setUsername(username);
		return new MessageModel().setUser(u).setMessage(message);
	}
}
