import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class test {
	public static void main(String[] args)throws IOException
	{	
		
		try 
		{
			SiteRanking page = new SiteRanking("nccu");
			for(WebTree tree : page.getResult()) {
				System.out.println(tree.getRoot().webPage.url);
			}
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}



