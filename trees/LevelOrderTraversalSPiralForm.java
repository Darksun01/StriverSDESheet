package trees;
import java.util.*;
public class LevelOrderTraversalSPiralForm {
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
	public void printSpiral(Node head)
	{
		Stack<Node> st1=new Stack<Node>();
		Stack<Node> st2=new Stack<Node>();
		st1.push(head);
		while(!st1.isEmpty() || !st2.isEmpty())
		{
			while(!st1.isEmpty())
			{
				Node node=st1.pop();
				System.out.print(node.data+" ");
				if(node.left!=null)
				{
					st2.push(node.left);
				}
				if(node.right!=null)
				{
					st2.push(node.right);
				}
			}
			System.out.println();
			while(!st2.isEmpty())
			{
				Node node=st2.pop();
				System.out.print(node.data+" ");
				if(node.right!=null)
				{
					st1.push(node.right);
				}
				if(node.left!=null)
				{
					st1.push(node.left);
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		LevelOrderTraversalSPiralForm a=new LevelOrderTraversalSPiralForm();
	    a.root = a.createNewNode(2);
	    a.root.left = a.createNewNode(7);
	    a.root.right = a.createNewNode(5);
	    a.root.left.left = a.createNewNode(12);
	    a.root.left.right = a.createNewNode(6);
	    a.root.left.right.left = a.createNewNode(5);
	    a.root.left.right.right = a.createNewNode(11);
	    a.root.right.right = a.createNewNode(9);
	    a.root.right.right.left = a.createNewNode(4);
	    a.printSpiral(a.root);

	}

}
