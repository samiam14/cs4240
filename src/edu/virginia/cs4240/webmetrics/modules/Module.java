package edu.virginia.cs4240.webmetrics.modules;

import java.io.IOException;

import edu.virginia.cs4240.webmetrics.WebRequest;


public abstract class Module {
	
	protected static WebRequest request;
	protected int score = 0;
	
	public static void setRequest(WebRequest r) {
		Module.request = r;
	}
	
	public double getScore(){
		return score;
	}

	public abstract String getStatistics() throws IOException;
}
