package betty.socialnetwokkata.step;

import org.springframework.batch.item.ItemProcessor;

public class SocialNetworkingKataProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		return item;
	}

}
