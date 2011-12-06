package edu.virginia.cs4240.webmetrics;

import java.io.IOException;

import javax.swing.JFrame;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import edu.virginia.cs4240.webmetrics.gui.GUIFrame;
import edu.virginia.cs4240.webmetrics.modules.Module;

public class Main {
	
	public static void main(String[] args) throws IOException {
		final Main controller = new Main();
		
		final JFrame gui = new GUIFrame(controller);
		gui.setLocationRelativeTo(null);
		gui.setVisible(true);
	}

	public String fetchPage(String url) throws IOException {
		Document page = Jsoup.connect(url).get();
		Module.setDocument(page); // Shared resource for all Modules
		
		return page.toString();
	}

}
