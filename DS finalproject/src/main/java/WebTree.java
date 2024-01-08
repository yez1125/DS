
public class WebTree
{
	private WebNode root;
	private double treeScore;

	public WebTree(WebPage rootPage)
	{
		this.root = new WebNode(rootPage);
	}

	public double getTreeScore() {
		return treeScore;
	}
	
	public void setTreeScore() {
		treeScore = root.getScore();
	}
	
	public WebNode getRoot() {
		return root;
	}

	public void eularPrintTree()
	{
		eularPrintTree(root);
		
	}

	private void eularPrintTree(WebNode startNode)
	{
		int nodeDepth = startNode.getDepth();

		if (nodeDepth > 1)
			System.out.print("\n" + repeat("\t", nodeDepth - 1));

		System.out.print("(");
		System.out.print(startNode.webPage.name + "," + startNode.getScore());
		
		for(int i = 0 ; i < startNode.children.size() ; i++) {
			eularPrintTree(startNode.children.get(i)) ;
		}
		

		System.out.print(")");

		if (startNode.isTheLastChild()) {
			System.out.print("\n" + repeat("\t", nodeDepth - 2));
		}
	}

	private String repeat(String str, int repeat)
	{
		String retVal = "";
		for (int i = 0; i < repeat; i++)
		{
			retVal += str;
		}
		return retVal;
	}
}