package betty.event;

import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class KataInvoker {
	
	private ReadEvent re;

	public KataInvoker(ReadEvent re) {
		super();
		this.re = re;
	}

	public void invoke(String istruzione) {
		List<String> istruzioni = istruzioni(istruzione);
		ReadEvent event = retrieveEvent(istruzioni);
		event.eseguiEvento(istruzioni.get(0));
	}
	
	public ReadEvent retrieveEvent(List<String> istruzioni) {
		return re;
	}
	
	public List<String> istruzioni(String istruzione) {
		return Collections.list(new StringTokenizer(istruzione, " ")).stream()
			      .map(token -> (String) token)
			      .collect(Collectors.toList());		
	}
}
