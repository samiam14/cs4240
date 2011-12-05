package edu.virginia.cs4240.webmetrics;

import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

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
	
	public static int maxTreeDepth(Element root) {
		List<Element> children = root.children();
		int max = 0;
		for(Element c : children) {
			int maxChildDepth = maxTreeDepth(c);
			if(maxChildDepth > max) {
				max = maxChildDepth;
			}
		}
		return 1 + max;
	}

	public void fetchPage(String url) {
		// Prepare url and fetch page
		// Update watcher modules
	}

}
