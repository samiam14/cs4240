package edu.virginia.cs4240.webmetrics.modules;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ElementModule extends Module {
	protected static String host;
	public ElementModule() {
	}
	
	@Override
	public String getStatistics() {
		String retString=ElementTypes(document)+"\n"+numLinks(document,host)+"\n"
		+numImages(document)+"\n"+resList(document)+"\n";
		return retString;
	}
	
	//returns a string of tag names in given doc
	public static String ElementTypes(Document doc){
		Elements all = doc.getAllElements();
		
		ArrayList<String> tagList = new ArrayList<String>();
		String retString = "List of tag names: \n";
		for(Element current: all){
			String tagName = current.tagName();
			if(!tagList.contains(tagName)&&!tagName.equals("#root")){
				retString+=tagName+"\n";
				tagList.add(tagName);
			}
		}
		return retString;
	}
	//returns string with num of links, total, internal, external
	public static String numLinks(Document doc, String host){
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
		String ret = "Total links: "+linkCount+"\nInternal links: "+iLinks
		+"\nExternal links: "+eLinks;
		return ret;
	}
	//returns number of images in web page
	public static int numImages(Document doc){
		Elements images = doc.getElementsByTag("img");
		return images.size();
	}

	//return list of resources
	public static String resList(Document doc){
		String retString = "List of resources:\n";
		Elements resources = doc.getElementsByTag("link");
		for(Element e: resources){
			retString = retString+e.toString()+"\n";
		}
		return retString;
	}
}
