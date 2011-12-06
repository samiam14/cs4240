package edu.virginia.cs4240.webmetrics;

import java.io.*;
import java.net.*;
import java.util.*;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class MichaelStuff {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		
		//Request the user to enter a web page
		Scanner stdin = new Scanner(System.in);
		System.out.print("Enter web page: ");
		String pagename = stdin.next();
		
		//CHANGE THIS for dynamic page selection
		pagename = "http://en.wikipedia.org/wiki/Spider-Man";
		//DETERMINE host
		String host = "wikipedia.org";
		
		//Get the web page HTML and turn to doc
		Document doc = Jsoup.connect(pagename).get();
		
		//get the data about links
		int[] numlink = numLinks(doc, host);
		
		//Output total stats for page
		System.out.println("Total number of links: " + numlink[0] +"\nNumber of internal links: "+numlink[1]);
		System.out.println("Number of external links: "+ numlink[2]);
		System.out.println("Number of images: "+numImages(doc));
		System.out.println("Page size is "+ pageSize(pagename));
		System.out.println("Number of different tags: "+ElementTypes(doc).size());
		System.out.println("Types of tags: ");
		for(String s: ElementTypes(doc)){
			System.out.println(s);
		}
		resList(doc);
		System.out.println(doc.toString());
	}
	//returns page size in human readable form
	//code taken from http://stackoverflow.com/questions/3758606/how-to-convert-byte-size-into-human-readable-format-in-java
	public static String hrbCount(long bytes, boolean si) {
	    int unit = si ? 1000 : 1024;
	    if (bytes < unit) return bytes + " B";
	    int exp = (int) (Math.log(bytes) / Math.log(unit));
	    String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
	    return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}
	//returns a list of tag names in given doc
	public static List<String> ElementTypes(Document doc){
		Elements all = doc.getAllElements();
		
		ArrayList<String> tagList = new ArrayList<String>();
		
		for(Element current: all){
			String tagName = current.tagName();
			if(!tagList.contains(tagName)&&!tagName.equals("#root")){
				tagList.add(tagName);
			}
		}
		return tagList;
	}
	//returns number of links, total, internal, external
	public static int[] numLinks(Document doc, String host){
		//Get all the link elements
		Elements links = doc.getElementsByTag("a");
		
		//Initialize link counts
		int linkCount = 0;
		int iLinks = 0;
		int eLinks = 0;
		//Iterate through links
		for (Element link : links) {
		  String linkHref = link.attr("href");
		  if(linkHref.contains(host)||linkHref.startsWith("/")){
			  ++iLinks;
		  }
		  else{
			  ++eLinks;
		  }
		  linkCount++;
		}
		int[] ret = {linkCount, iLinks, eLinks};
		return ret;
	}
	//returns number of images in web page
	public static int numImages(Document doc){
		Elements images = doc.getElementsByTag("img");
		return images.size();
	}
	//returns returns page size string
	public static String pageSize(String pagename)throws IOException{
		HttpURLConnection conn = (HttpURLConnection) new URL(pagename).openConnection();
		long pageSize = conn.getContentLength(); 
		//Get page size
		String size = hrbCount(pageSize, false);
		return size;
	}
	//print list of resources
	public static void resList(Document doc){
		Elements resources = doc.getElementsByTag("link");
		for(Element e: resources){
			System.out.println(e.toString());
		}
	}
}
