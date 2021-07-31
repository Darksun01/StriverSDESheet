package trees;
import java.util.*;
public class TreeTraversalIterative {
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
	Stack<Node> st=new Stack<Node>();

	public void inOrderTraversal(Node node)
	{
		if(node==null) {return;}
		
		while(node!=null)
		{
			st.push(node);
			node=node.left;
		}
		while(!st.isEmpty())
		{
			Node temp=st.pop();
			System.out.print(temp.data+" ");
			Node t=temp.right;
			while(t!=null)
			{
				st.push(t);
				t=t.left;
			}
		}	
	}
	
	public void preOrderTraversal(Node node)
	{
		if(node==null) return;
		st.clear();
		st.push(node);
		while(!st.isEmpty())
		{
			Node temp=st.pop();
			System.out.print(temp.data+" ");
			if(temp.right!=null)
			{
				st.push(temp.right);
			}
			if(temp.left!=null)
			{
				st.push(temp.left);
			}
		}
	}
	
	public void postOrder2Stacks(Node node)
	{
		if(node==null) return;
		Stack<Node> st2=new Stack<Node>();
		st.clear();
		st.push(node);
		while(!st.isEmpty())
		{
			Node temp=st.pop();
			if(temp.left!=null)
			{
				st.push(temp.left);
			}
			if(temp.right!=null)
			{
				st.push(temp.right);
			}
			st2.push(temp);
		}
		while(!st2.isEmpty())
		{
			System.out.print(st2.pop().data+" ");
		}
	}

	public static void main(String[] args) {
		TreeTraversalIterative a=new TreeTraversalIterative();
		Node root = a.createNewNode(2);
	    root.left = a.createNewNode(7);
	    root.right = a.createNewNode(5);
	    root.left.left = a.createNewNode(2);
	    root.left.right = a.createNewNode(6);
	    root.left.right.left = a.createNewNode(5);
	    root.left.right.right = a.createNewNode(11);
	    root.right.right = a.createNewNode(9);
	    root.right.right.left = a.createNewNode(4);
//	    a.inOrderTraversal(root);
//	    a.preOrderTraversal(root);
	    a.postOrder2Stacks(root);

	}

}
