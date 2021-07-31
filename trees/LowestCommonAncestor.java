package trees;
import java.util.*;

public class LowestCommonAncestor {
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
	boolean isN1Present=false;
	boolean isN2Present=false;
	public Node findLca(Node node,Node p,Node q)
	{
		if(node==null) return null;
		Node lca=findLcaUtil(node,p.data,q.data);
		if(isN1Present && isN2Present)
		{
			return lca;
		}
		else if(!isN1Present && !isN2Present)
		{
			return null;
		}
		else
		{
			int val=lca.data==p.data?q.data:p.data;
			if(isPresent(lca,val))
			{
				return lca;
			}
	    }
		return null;
		
	}

	private Node findLcaUtil(Node node, int data1, int data2) {
		if(node==null) return null;
		if(node.data==data1)
		{
			isN1Present=true;
			return node;
		}
		if(node.data==data2)
		{
			isN2Present=true;
			return node;
		}
		Node leftLca=findLcaUtil(node.left,data1,data2);
		Node rightLca=findLcaUtil(node.right,data1,data2);
		
		if(leftLca!=null && rightLca!=null)
		{
			return node;
		}
		return leftLca!=null?leftLca:rightLca;
	}
	public boolean isPresent(Node node,int data)
	{
		if(node==null) return false;
		if(node.data==data)
		{
			return true;
		}
		return isPresent(node.left,data)|| isPresent(node.right,data);
	}

	public static void main(String[] args) {
		LowestCommonAncestor a=new LowestCommonAncestor();
		Node root = a.createNewNode(2);
	    root.left = a.createNewNode(7);
	    root.right = a.createNewNode(9);
	    root.right.right = a.createNewNode(3);
	    root.left.left = a.createNewNode(10);
	    root.left.right = a.createNewNode(6);
	    root.left.right.left = a.createNewNode(5);
	    root.left.right.right = a.createNewNode(11);
	    
	    Node ans=a.findLca(root,root.left.right.right, root.right);
	    if(ans!=null) {
	    System.out.println(ans.data);}
	    else
	    {
	    	System.out.println("Null");
	    }
	}

}
