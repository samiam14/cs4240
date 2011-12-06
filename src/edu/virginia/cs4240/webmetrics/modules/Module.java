package edu.virginia.cs4240.webmetrics.modules;

import java.io.IOException;

import org.jsoup.nodes.Document;


public abstract class Module {
	protected static Document document;
	protected static String host;
	protected static String url;
	
	public static void setDocument(Document d) {
		Module.document = d;
	}
	public static void setHost(String h){
		Module.host = h;
	}
	public static void setUrl(String u){
		Module.url = u;
	}
	public static String extractHost(String url){
		int begin = 0;
		int end = 1;
		String hostString = "wikipedia.org";
		if(url.contains(".com")){
			end = url.indexOf(".com");
			begin = url.lastIndexOf(".",end);
		}
		if(url.contains(".org")){
			end = url.indexOf(".org");
			begin = url.lastIndexOf(".",end);
		}
		if(url.contains(".net")){
			end = url.indexOf(".net");
			begin = url.lastIndexOf(".",end);
		}
		if(url.contains(".edu")){
			end = url.indexOf(".edu");
			begin = url.lastIndexOf(".",end);
		}
		end+=4;
		hostString = url.substring(begin, end);
		System.out.println(hostString);
		return hostString;
	}
	public abstract String getStatistics() throws IOException;
}
