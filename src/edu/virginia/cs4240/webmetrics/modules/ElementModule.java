package edu.virginia.cs4240.webmetrics.modules;

import org.jsoup.nodes.Document;

public class ElementModule extends Module {

	public ElementModule(Document page) {
		this.document = page;
	}
	
	@Override
	public String getStatistics() {
		return null;
	}

}
