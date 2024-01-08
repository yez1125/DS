import java.io.IOException;
import java.util.ArrayList;

public class WebPage
{
	public String url;
	public String name;
	public double score;

	public WebPage(String url, String name , double score)
	{
		this.url = url;
		this.name = name;
		this.score = score;
	}
	
	public WebPage(String url , double score)
	{
		this.url = url;
		this.score = score;
	}
	
	public double getScore() {
		return score;
	}
}