package edu.virginia.cs4240.webmetrics.modules;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.nodes.Element;

public class PageModule extends Module {

	@Override
	public String getStatistics() {
		try {
			StringBuilder stats = new StringBuilder(256);
			stats.append("The maximum depth of the webpage is: "+(maxTreeDepth(request.getDocument()))+"\n");
			stats.append(pageSize());
			stats.append("\nPage Complexity Score: " + getScore());
			stats.append("\nHeaders sent:\n");
			stats.append(getRequestHeaders());
			stats.append("\nHeaders recieved:\n");
			stats.append(getResponseHeaders());
			return stats.toString();
		} catch(IOException e) {
			return "Error parsing the document.";
		}
	}
	
	public int maxTreeDepth(Element root) {
		List<Element> children = root.children();
		int max = 0;
		for(Element c : children) {
			int maxChildDepth = maxTreeDepth(c);
			if(maxChildDepth > max) {
				max = maxChildDepth;
			}
		}
		score += 2;
		return 1+max;
	}
	
	public String getResponseHeaders() {
		Connection.Response res = request.getConnection().response();
		StringBuilder build = new StringBuilder(128);
		Map<String, String> headers = res.headers();
		for (Map.Entry<String, String> entry : headers.entrySet()) {
			build.append("  ");
			build.append(entry.getKey());
			build.append(": ");
			build.append(entry.getValue());
			build.append("\n");
		}
		return build.toString();
	}
	
	public String getRequestHeaders() {
		Connection.Request req = request.getConnection().request();
		StringBuilder build = new StringBuilder(128);
		Map<String, String> headers = req.headers();
		for (Map.Entry<String, String> entry : headers.entrySet()) {
			build.append("  ");
			build.append(entry.getKey());
			build.append(": ");
			build.append(entry.getValue());
			build.append("\n");
		}
		return build.toString();
	}
	
	public String pageSize() {
		Connection.Response res = request.getConnection().response();
		String contentLength = res.header("Content-Length");
		try {
			int pageSize = Integer.parseInt(contentLength);
			score += pageSize;
			return "The size of the web page is: " + hrbCount(pageSize, true);
		} catch(NumberFormatException e) {
			return "The size of the web page is unpublished.";
		}
	}
	
	private String hrbCount(long bytes, boolean si) {
	    int unit = si ? 1000 : 1024;
	    if (bytes < unit) return bytes + " B";
	    int exp = (int) (Math.log(bytes) / Math.log(unit));
	    String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
	    return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}
}
