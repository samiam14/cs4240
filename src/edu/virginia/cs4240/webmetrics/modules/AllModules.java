package edu.virginia.cs4240.webmetrics.modules;

import java.io.IOException;
import java.util.List;

public class AllModules extends Module {
	
	private List<DisplayOption> options;

	public AllModules(List<DisplayOption> opts) {
		options = opts;
	}
	
	@Override
	public String getStatistics() throws IOException {
		StringBuilder displayBuilder = new StringBuilder(256);
		for(DisplayOption d : options) {
			displayBuilder.append(d.getTitle() + "\n");
			displayBuilder.append(d.fetchOptionStatistics());
			displayBuilder.append("\n\n");
		}
		return displayBuilder.toString();
	}

}
