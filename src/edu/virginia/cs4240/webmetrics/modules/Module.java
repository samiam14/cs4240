package edu.virginia.cs4240.webmetrics.modules;

import java.io.IOException;

import edu.virginia.cs4240.webmetrics.WebRequest;


public abstract class Module {
	
	protected static WebRequest request;
	protected static double score = 0;
	
	public static void setRequest(WebRequest r) {
		Module.request = r;
	}
	public static void setScore(double d){
		Module.score = d;
	}
	public static double getScore(){
		return Module.score;
	}

	public abstract String getStatistics() throws IOException;
}
