package edu.virginia.cs4240.webmetrics.modules;

import java.io.IOException;

import edu.virginia.cs4240.webmetrics.WebRequest;


public abstract class Module {
	
	protected static WebRequest request;
	
	public static void setRequest(WebRequest r) {
		Module.request = r;
	}

	public abstract String getStatistics() throws IOException;
}
