package edu.virginia.cs4240.webmetrics.modules;

import java.util.List;

public class AllModules extends Module {
	
	private List<DisplayOption> options;

	public AllModules(List<DisplayOption> opts) {
		options = opts;
	}
	
	@Override
	public String getStatistics() {
		for(DisplayOption d : options) {
			d.fetchOptionStatistics();
		}
		return null;
	}

}
