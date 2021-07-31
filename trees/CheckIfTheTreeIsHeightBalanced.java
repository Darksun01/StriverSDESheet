package trees;
import java.util.*;


public class CheckIfTheTreeIsHeightBalanced {
	private class Node{
		int data;
		Node right,left;
		public Node(int data)
		{
			this.data=data;
			right=left=null;
		}
	}
	Node root;
	public Node createNewNode(int data)
	{
		Node newNode=new Node(data);
		newNode.data=data;
		newNode.left=null;
		newNode.right=null;
		return newNode;
	}
	static boolean flag=true;
	public int height(Node node)
	{
		if(node==null) return 0;
		int lh=height(node.left);
		int rh=height(node.right);
		if(Math.abs(lh-rh)>1)
		{
			flag=false;
		}
		return Math.max(lh, rh)+1;
	}
	//O(n^2)
	public boolean bruteForce(Node root) {
        if(root==null) return true;
        int lh=height(root.left);
        int rh=height(root.right);
        
        return Math.abs(lh-rh)<=1 && bruteForce(root.left) && bruteForce(root.right);
    }
	public boolean optimalApproach(Node node)//O(n)
	{
		if(node==null) return true;
		height(node);
		return flag;
	}

	public static void main(String[] args) {
		CheckIfTheTreeIsHeightBalanced tree=new CheckIfTheTreeIsHeightBalanced();
		 tree.root = tree.createNewNode(1);
	     tree.root.left =tree.createNewNode(2);
	     tree.root.right = tree.createNewNode(3);
	     tree.root.left.left = tree.createNewNode(4);
	     tree.root.left.right = tree.createNewNode(5);
	     tree.root.left.left.left =tree.createNewNode(8);
	    System.out.println(tree.optimalApproach(tree.root));
	    System.out.println(tree.bruteForce(tree.root));

	}

}
