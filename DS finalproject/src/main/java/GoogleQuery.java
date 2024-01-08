import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleQuery 
{
	public String searchKeyword;
	public String url;
	public String content;
	public ArrayList<WebPage> pageList;
	public String title_x;
	public String webSite;
	
	public GoogleQuery(String searchKeyword)
	{
		this.searchKeyword = searchKeyword;
		try 
		{
			String encodeKeyword=java.net.URLEncoder.encode("政大 "+searchKeyword,"utf-8");
			this.url = "https://www.google.com/search?q="+encodeKeyword+"&oe=utf8&num=20";
			
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	private String fetchContent() throws IOException
	{
		String retVal = "";

		URL u = new URL(url);
		URLConnection conn = u.openConnection();
		conn.setRequestProperty("User-agent", "Chrome/107.0.5304.107");
		InputStream in = conn.getInputStream();
		InputStreamReader inReader = new InputStreamReader(in, "utf-8");
		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null;

		while((line = bufReader.readLine()) != null)
		{
			retVal += line;
		}
		return retVal;
	}
	
	public HashMap<String, String> query() throws IOException
	{
		if(content == null)
		{
			content = fetchContent();
		}
		

		HashMap<String, String> retVal = new HashMap<String, String>();
		
		Document doc = Jsoup.parse(content);
		
		Elements lis = doc.select("div");
        
		lis = lis.select(".kCrYT");
		
		pageList = new ArrayList<WebPage>();
		for(Element li : lis)
		{
			try 
			{	
				String citeUrl = li.select("a").get(0).attr("href").replace("/url?q=", "");
				String title = li.select("a").get(0).select(".vvjwJb").text();
				if(citeUrl.contains("twitter" )) {
	    			continue;
	    		}
				if(citeUrl.contains("pdf" )) {
	    			continue;
	    		}
				if(citeUrl.contains("youtube" )) {
	    			continue;
	    		}
				if(citeUrl.contains("Dcard" )) {
	    			continue;
	    		}
				
				int theFirstChar = citeUrl.indexOf("&");
				String edit_citeUrl = citeUrl.substring(0, theFirstChar);
			
				//直接在這裡把從HTML中直接抓下來的網址decode
				String decoded_citeUrl = "";
				try {
					decoded_citeUrl = java.net.URLDecoder.decode(edit_citeUrl,"utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}	
				
				
				if(title.equals("")) 
				{
					continue;
				}
				if(decoded_citeUrl.equals("https://www.nccu.edu.tw/")) {
	    			continue;
	    		}
				System.out.println("Title: " + title + ", URL: " + decoded_citeUrl);
				//findChildUrl(decoded_citeUrl);
				retVal.put(title, decoded_citeUrl);

			} catch (IndexOutOfBoundsException e) 
			{
//				e.printStackTrace();
			}
		}
		
		
		return retVal;
	}
	
	public ArrayList<WebNode> findChildUrl(String father_url) {
		ArrayList<WebNode> children = new ArrayList<WebNode>();
		try {

			String text_x = java.net.URLDecoder.decode(father_url,"utf-8");
			Document doc_1 = Jsoup.connect(text_x).get();

		    // 提取並打印所有連結
		    Elements links = doc_1.select("a[href]");
		    
		    for (Element link : links) {

		    	if(children.size() < 10) {
		    		String child_url = "";
		    		child_url = link.attr("abs:href");
		    		//檢查父網頁中是否有重複的子網頁
		    		boolean check_repeat = false;
		    		if(children.size()>1) {
		    			for(int m = 0; m < children.size(); m++) {
		    				check_repeat = children.get(m).webPage.url.contentEquals(child_url);
		    			}
		    		}
		    		if(check_repeat == true) {
		    			continue;
		    		}
		    		if(child_url.startsWith("javascript")) {
		    			continue;
		    		}
		    		if(child_url.startsWith("https:") != true) {
		    			continue;
		    		}
		    		if(child_url.contentEquals("https://www.空中家教.com/web/") || child_url.contentEquals("https://help.voicetube.com/hc/zh-tw/categories/360001591732")) {
		    			continue;
		    		}
		    		if(child_url.startsWith("https://www.hm.com" )) {
		    			continue;
		    		}
		    		if(child_url.contains("twitter")) {
		    			continue;
		    		}
		    		else {
		    			children.add(new WebNode(new WebPage(child_url , new PageRanking(child_url).getScore())));
		    			//System.out.println("連結: " + child_url);
		    		}
		    	}
		    }
		    
		}
		    	
		    	
		    	
		catch (Exception e) {
			e.printStackTrace();
		}
		return children;
		
	}
	
}