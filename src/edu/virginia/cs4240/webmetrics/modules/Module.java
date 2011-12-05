package edu.virginia.cs4240.webmetrics.modules;

import org.jsoup.nodes.Document;


public abstract class Module {
	protected Document document;
	
	public void setDocument(Document d) {
		this.document = d;
	}
	
	public abstract String getStatistics();
}
