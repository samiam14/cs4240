package edu.virginia.cs4240.webmetrics;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import edu.virginia.cs4240.webmetrics.modules.*;

import edu.virginia.cs4240.webmetrics.gui.GUIFrame;

public class Main {
	
	private List<Module> activeModules;

	public static void main(String[] args) throws IOException {
		final Main controller = new Main();
		
		final JFrame gui = new GUIFrame(controller);
		gui.setLocationRelativeTo(null);
		gui.setVisible(true);
	}
	
	public Main() {
		activeModules = new ArrayList<Module>();
		activeModules.add(new ElementModule());
		activeModules.add(new PageModule());
	}

	public String fetchPage(String url) throws IOException {
		Document page = Jsoup.connect(url).get();
		Module.setDocument(page); // Shared resource for all Modules
		
		return page.toString();
	}
	
	public String fetchStatistics() {
		// Template
		return null;
	}

}
