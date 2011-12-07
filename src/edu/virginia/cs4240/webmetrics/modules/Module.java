package edu.virginia.cs4240.webmetrics.modules;

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
	
	public String fetchStatistics()
	{
		if(Module.request != null) {
			return getStatistics();
		}
		return null;
	}

	public abstract String getStatistics();
}
