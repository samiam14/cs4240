package edu.virginia.cs4240.webmetrics;

import java.io.IOException;

import javax.swing.JFrame;

import edu.virginia.cs4240.webmetrics.gui.GUIFrame;

public class Main {
	
	public static void main(String[] args) throws IOException {		
		final JFrame gui = new GUIFrame("WebMetrics");
		gui.setLocationRelativeTo(null);
		gui.setVisible(true);
	}
}
