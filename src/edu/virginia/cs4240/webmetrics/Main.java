package edu.virginia.cs4240.webmetrics;

import java.io.IOException;

import javax.swing.JFrame;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import edu.virginia.cs4240.webmetrics.gui.NewJFrame;

public class Main {

	public static void main(String[] args) {
		final Main controller = new Main();
		
		final JFrame gui = new NewJFrame(controller);
		gui.setLocationRelativeTo(null);
		gui.setVisible(true);
	}
	
	public Main()
	{
		// attributes, etc.
	}

	public void fetchPage(String url) throws IOException {
		Document page = Jsoup.connect(url).get();
		
	}

}
