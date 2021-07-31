package trees;
import java.util.*;

//import binarytrees.Node;
public class TreeTraversalRecursion {
	private class Node{
		int data;
		Node left,right;
		public Node(int data)
		{
			this.data=data;
			left=right=null;
		}
	}
	public Node addNode(int data)
	{
		Node newNode=new Node(data);
		newNode.data=data;
		newNode.left=null;
		newNode.right=null;
		return newNode;
	}
	
	public void preOrder(Node head)
	{
		if(head==null) return;
		System.out.print(head.data+" ");
		preOrder(head.left);
		preOrder(head.right);
	//	System.out.println();
	}
	
	public void inOrder(Node head)
	{
		if(head==null) return;
		inOrder(head.left);
		System.out.print(head.data+" ");
		inOrder(head.right);
	//	System.out.println();
	}
	
	public void postOrder(Node head)
	{
		if(head==null) return;
		postOrder(head.left);
		postOrder(head.right);
		System.out.print(head.data+" ");
	}

	public static void main(String[] args) {
		TreeTraversalRecursion a=new TreeTraversalRecursion();
		Node root=a.addNode(1);
		root.left=a.addNode(2);
		root.right=a.addNode(3);
		root.left.left=a.addNode(4);
		root.left.right=a.addNode(5);
		System.out.println("\nPostorder traversal of binary tree is "); 
		a.postOrder(root);
		System.out.println("\nInorder traversal of binary tree is "); 
		a.inOrder(root);
		System.out.println("\nPreorder traversal of binary tree is ");
		a.preOrder(root);

	}

}
