package edu.virginia.cs4240.webmetrics.modules;

import org.jsoup.nodes.Document;


public abstract class Module {
	protected static Document document;
	
	public void setDocument(Document d) {
		Module.document = d;
	}
	
	public abstract String getStatistics();
}
