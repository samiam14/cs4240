package edu.virginia.cs4240.webmetrics.modules;

public class DisplayOption {

	private Module strategy;
	private String title;
	
	public DisplayOption(String t, Module m) {
		title = t;
		strategy = m;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String fetchOptionStatistics() {
		return strategy.fetchStatistics();
	}
	
	@Override
	public String toString(){
		return title;
	}
}
