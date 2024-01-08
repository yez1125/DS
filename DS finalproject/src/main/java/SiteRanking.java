import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class SiteRanking{
	
	public ArrayList<WebTree> WebTreeArray = new ArrayList<WebTree>();
	private GoogleQuery result;
	private Sort sort;

	public SiteRanking(String query) throws IOException{
		result = new GoogleQuery(query);
		HashMap<String, String>web = result.query();
		for(String title : web.keySet()) {
			double score = new PageRanking(web.get(title)).getScore();
			WebPage page = new WebPage(web.get(title) , title , score);
			WebTreeArray.add(new WebTree(page));
		}
		
		for(WebTree tree : WebTreeArray) {
			ArrayList<WebNode> children = result.findChildUrl(tree.getRoot().webPage.url);
			for(WebNode child : children) {
				tree.getRoot().addChild(child);
			}
			tree.setTreeScore();
		}
		
		sort = new Sort(WebTreeArray);
		sort.sort();
		WebTreeArray = sort.getSort();
		for(WebTree tree : WebTreeArray) {
			System.out.println(tree.getRoot().webPage.name+","+tree.getTreeScore());
			tree.eularPrintTree();
		}
	}
	
	public ArrayList<WebTree> getResult() {
		return WebTreeArray;
	}
	
}

