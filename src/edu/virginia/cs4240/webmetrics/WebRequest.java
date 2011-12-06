package edu.virginia.cs4240.webmetrics;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebRequest {

	private Document document;
	private Connection connection;
	private boolean executed = false;
	private IOException exception = null;
	
	public WebRequest(String url) {
		connection = Jsoup.connect(url);
	}
	
	public void validateRequest() throws IOException {
		connection.method(Connection.Method.GET);
		try {
	        connection.execute();
		} catch(IOException e) {
			executed = true;
			exception = e;
			throw e;
		}
	}
	
	// Lazy load the document
	public Document getDocument() throws IOException {
		if(document == null) {
			if(executed && exception != null) {
				throw exception;
			}
			
			validateRequest();
			try {
				document = connection.response().parse();
			} catch (IOException e) {
				exception = e;
				throw e;
			}
		}
		return document;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public IOException getException() {
		return exception;
	}
}
