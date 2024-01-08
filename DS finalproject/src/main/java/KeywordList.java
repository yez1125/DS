import java.util.ArrayList;
import java.util.LinkedList;

public class KeywordList
{
	private ArrayList<Keyword> lst;

	public KeywordList()
	{
		this.lst = new ArrayList<Keyword>();
		lst.add(new Keyword("nccu",5));
		lst.add(new Keyword("政大",5));
		lst.add(new Keyword("政治大學",5));
		lst.add(new Keyword("教授",4));
		lst.add(new Keyword("專長",1));
		lst.add(new Keyword("研究領域",2));
		lst.add(new Keyword("經歷",2));
		lst.add(new Keyword("頂大",4));
		lst.add(new Keyword("文山區",4));
		lst.add(new Keyword("學術研究",2));
		
		
	}
	
	public ArrayList<Keyword> getKeywords()
	{
		return lst; 
	}

	public void add(Keyword keyword)
	{
		lst.add(keyword) ; 
	}

	public float outputScore(ArrayList<Integer> count)
	{
		float results = 0;
		for (int i = 0 ; i < lst.size() ; i++) {
			results += count.get(i) * lst.get(i).getWeight() ;
		}

		return results;
	}
	
	public void find(String s)
	{
		int maxValue = -1;
		Keyword LCS = null;

		for (Keyword k : lst)
		{
			int lcs = findLCS(k.name, s);

			if (lcs > maxValue)
			{
				maxValue = lcs;
				LCS = k;
				
			}
		}
		System.out.println(s + ": " + LCS.toString());
	}

	public int findLCS(String x, String y)
	{
		int matrix[][] = new int [y.length()+1][x.length()+1] ;
		x = x.toUpperCase();
		y = y.toUpperCase();
		for(int i = 0 ; i <= y.length() ; i++) {
			for(int j = 0 ; j <= x.length() ; j++) {
				matrix[i][j] = 0 ;
			}
		}
		for(int i = 1 ; i <= x.length() ; i++) {
			for(int j = 1 ; j <= y.length() ; j++) {
				
				if(x.charAt(i-1) == y.charAt(j-1)) {
					matrix[j][i] = matrix[j-1][i-1] + 1 ; 
				}else {
					matrix[j][i] =  Math.max(matrix[j-1][i],matrix[j][i-1]) ;
				}
			}
		}
		return matrix[y.length()][x.length()];
	}

	private void printKeywordList(LinkedList<Keyword> kLst)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < kLst.size(); i++)
		{
			Keyword k = kLst.get(i);
			if (i > 0)
				sb.append(" ");
			sb.append(k.toString());
		}
		System.out.println(sb.toString());
	}
}