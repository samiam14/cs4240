package edu.virginia.cs4240.webmetrics.modules;

import java.util.List;

import org.jsoup.nodes.Element;

public class PageModule extends Module {
	
	public PageModule() {
	}

	@Override
	public String getStatistics() {
		return null;
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

}
