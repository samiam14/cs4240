package edu.virginia.cs4240.webmetrics.modules;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.jsoup.nodes.Element;

public class PageModule extends Module {

	@Override
	public String getStatistics() throws IOException {
		StringBuilder stats = new StringBuilder(256);
		stats.append("The maximum depth of the webpage is: "+(maxTreeDepth(request.getDocument()))+"\n");
		stats.append(pageSize(request.getUrl()));
		return stats.toString();
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
		
		return 1+max;
	}
	
	public String getHeaders() {
		return null;
	}
	
	public String pageSize(String pagename)throws IOException{
		HttpURLConnection conn = (HttpURLConnection) new URL(pagename).openConnection();
		long pageSize = conn.getContentLength();
		String retVal = null;
		if(pageSize == -1){
			return "The size of the web page is unpublished.";
		}
		else{
			String size = hrbCount(pageSize, false);
			System.out.println(size);
			retVal = "The size of the web page is: "+size+"\n";	
		}
		return retVal;
	}
	
	private String hrbCount(long bytes, boolean si) {
	    int unit = si ? 1000 : 1024;
	    if (bytes < unit) return bytes + " B";
	    int exp = (int) (Math.log(bytes) / Math.log(unit));
	    String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
	    return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}
}
