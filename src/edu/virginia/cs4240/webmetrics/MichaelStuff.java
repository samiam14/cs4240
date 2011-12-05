package edu.virginia.cs4240.webmetrics;

import java.io.*;
import java.util.*;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class MichaelStuff {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		Scanner stdin = new Scanner(System.in);
		System.out.print("Enter web page: ");
		String pagename = stdin.next();
		String host = "wikipedia.org";
		
		Document doc = Jsoup.connect(pagename).get();
		Elements links = doc.getElementsByTag("a");
		
		int linkCount = 0;
		int iLinks = 0;
		int eLinks = 0;
		for (Element link : links) {
		  String linkHref = link.attr("href");
		  if(linkHref.contains(host)||linkHref.startsWith("/")){
			  ++iLinks;
		  }
		  else{
			  ++eLinks;
		  }
		  String linkText = link.text();
		 
		  System.out.println(linkHref+ " "+ linkText);
		  
		  linkCount++;
		}
		System.out.println("Number of links:" + linkCount +"\nNumber of internal links: "+iLinks);
		System.out.println("Number of external links: "+ eLinks);
	}

}
