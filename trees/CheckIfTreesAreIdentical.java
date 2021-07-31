package trees;
import java.util.*;

public class CheckIfTreesAreIdentical {
	private class Node{
		int data;
		Node right,left;
		public Node(int data)
		{
			this.data=data;
			right=left=null;
		}
	}
	
	Node root,root2;
	public Node createNewNode(int data)
	{
		Node newNode=new Node(data);
		newNode.data=data;
		newNode.left=null;
		newNode.right=null;
		return newNode;
	}
	public boolean ifIdentical(Node node1,Node node2)
	{
		if(node1==null && node2==null)
		{
			return true;
		}
		if(node1==null || node2==null)
		{
			return false;
		}
		return node1.data==node2.data
				&& ifIdentical(node1.left,node2.left)
				&& ifIdentical(node1.right,node2.right);
	}

	public static void main(String[] args) {
		CheckIfTreesAreIdentical a=new CheckIfTreesAreIdentical();
		a.root=a.createNewNode(2);
		a.root.left=a.createNewNode(7);
		a.root.right=a.createNewNode(5);
		a.root.left.left=a.createNewNode(2);
		a.root.left.right=a.createNewNode(6);
		a.root.left.right.left = a.createNewNode(5);
	    a.root.left.right.right = a.createNewNode(11);
	    a.root.right.right = a.createNewNode(9);
	    a.root.right.right.left = a.createNewNode(4);
	    
	    a.root2=a.createNewNode(2);
		a.root2.left=a.createNewNode(7);
		a.root2.right=a.createNewNode(5);
		a.root2.left.left=a.createNewNode(2);
		a.root2.left.right=a.createNewNode(6);
		a.root2.left.right.left =a.createNewNode(5);
	    a.root2.left.right.right =a.createNewNode(11);
	    a.root2.right.right =a.createNewNode(9);
	    a.root2.right.right.left = a.createNewNode(4);
	    System.out.println(a.ifIdentical(a.root, a.root2));

	}

}
