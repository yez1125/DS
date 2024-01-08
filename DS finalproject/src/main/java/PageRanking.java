import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;
public class PageRanking {
	
	private String urlStr ;
	private KeywordList kLst = new KeywordList();
	private ArrayList<Integer> counts = new ArrayList<Integer>();
	private double score = 0;
	
	public PageRanking(String url) throws FileNotFoundException,IOException{
		this.urlStr = url ;
		WordCounter counter = new WordCounter(urlStr);
		
		for(Keyword k : kLst.getKeywords()){
				int count = counter.countKeyword(k.name);
				counts.add(count);
		}
		
		score = kLst.outputScore(counts);
	}
	
	public double getScore() {
		return score;
	}
	
}
