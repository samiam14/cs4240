package edu.virginia.cs4240.webmetrics;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebRequest {

	private Document document;
	private Connection connection;
	private IOException exception = null;
	
	public WebRequest(String url) {
		connection = Jsoup.connect(url);
	}
	
	// Lazy load the document
	public Document getDocument() throws IOException {
		if(document == null) {
			if(exception != null) {
				throw exception;
			}
			
			try {
				document = connection.get();
			} catch(IOException e) {
				exception = e;
				throw e;
			}
			
		}
		return document;
	}
	
	public Connection getConnection() throws IOException {
		if(exception != null) {
			throw exception;
		}
		return connection;
	}
}
