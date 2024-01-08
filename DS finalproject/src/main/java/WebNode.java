import java.io.IOException;
import java.util.ArrayList;

public class WebNode
{
	public WebNode parent;
	public ArrayList<WebNode> children;
	public WebPage webPage;
	public double nodeScore = 0;

	public WebNode(WebPage webPage)
	{
		this.webPage = webPage;
		this.children = new ArrayList<WebNode>();
		nodeScore = webPage.getScore();
	}
	
	public double childrenScore(){	
		double childrenScore = 0;
		for(WebNode child : children){
			childrenScore += child.nodeScore;
		}
		return childrenScore;
	}
	
	public double getScore() {
		double result = nodeScore + childrenScore();
		return result;
	}
	

	public void addChild(WebNode child)
	{
		this.children.add(child);
		child.parent = this;
	}

	public boolean isTheLastChild()
	{
		if (this.parent == null)
			return true;
		ArrayList<WebNode> siblings = this.parent.children;

		return this.equals(siblings.get(siblings.size() - 1));
	}

	public int getDepth()
	{
		int retVal = 1;
		WebNode currNode = this;
		while (currNode.parent != null)
		{
			retVal++;
			currNode = currNode.parent;
		}
		return retVal;
	}
}