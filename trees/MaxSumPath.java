package trees;
import java.util.*;
public class MaxSumPath {
	private class Node{
		int data;
		Node right,left;
		public Node(int data)
		{
			this.data=data;
			right=left=null;
		}
	}
	public Node createNewNode(int data)
	{
		Node newNode=new Node(data);
		newNode.data=data;
		newNode.left=null;
		newNode.right=null;
		return newNode;
	}
	int maxSum=Integer.MIN_VALUE;;
	public int maxSumPath(Node node)
	{
		maxSumPathUtil(node);
		return maxSum;
	}

	private int maxSumPathUtil(Node node) {
		if(node==null) return -1;
		
		int l=maxSumPathUtil(node.left);
		int r=maxSumPathUtil(node.right);
		
		int straight_case=Math.max(node.data, Math.max(l, r)+node.data);
		int root_case=Math.max(straight_case, l+r+node.data);
		 maxSum=Math.max(maxSum, root_case);
		 return straight_case;
	}

	public static void main(String[] args) {
		MaxSumPath a=new MaxSumPath();
		Node root = a.createNewNode(2);
	    root.left = a.createNewNode(4);
	    root.left.left = a.createNewNode(1);
	    root.left.right = a.createNewNode(6);
	    root.right = a.createNewNode(5);
	    root.right.right = a.createNewNode(7);
	    System.out.println(a.maxSumPath(root));

	}

}
