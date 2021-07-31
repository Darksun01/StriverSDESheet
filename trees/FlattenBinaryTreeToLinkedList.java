package trees;
import java.util.*; 
public class FlattenBinaryTreeToLinkedList {
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
	public void preTraversal(Node node)
	{
		if(node==null) return;
		System.out.print(node.data+" ");
		preTraversal(node.left);
		preTraversal(node.right);
		
	}
	public Node bruteForce(Node node)
	{
		if(node==null) return null;
		Stack<Node> st=new Stack<Node>();
		st.push(node);
		while(!st.isEmpty())
		{
			Node temp=st.pop();
			if(temp.right!=null)
			{
				st.push(temp.right);
			}
			if(temp.left!=null)
			{
				st.push(temp.left);
			}
			if(!st.isEmpty())
			{
				temp.right=st.peek();
			}
			temp.left=null;
		}
		return node;
	}
	//O(N) && O(H)
	public Node betterApproach(Node node)
	{
		if(node==null)
		{
			return null;
		}
		if(node.left==null && node.right==null)
		{
			return null;
		}
		if(node.left!=null)
		{
			betterApproach(node.left);
			Node tempLeft=node.left;
			Node tempRight=node.right;
			node.right=tempLeft;
			node.left=null;
			
			Node current=node;
			while(current.right!=null)
			{
				current=current.right;
			}
			current.right=tempRight;
		}
		betterApproach(node.right);
		return node;
	}
	public Node optimalApproach(Node root)
	{
		 if(root==null) 
	        {return null;}
			while(root!=null)
	        {
	            if(root.left!=null)
	            {
	                Node left=root.left;
	                Node current=left;
	                while(current.right!=null)
	                {
	                    current=current.right;
	                }
	                current.right=root.right;
	                root.left=null;
	                root.right=left;
	            }
	            root=root.right;
	        }
			return root;
    }
	

	public static void main(String[] args) {
		FlattenBinaryTreeToLinkedList a=new FlattenBinaryTreeToLinkedList();
		Node root=a.createNewNode(1);
		root.left=a.createNewNode(2);
		root.right=a.createNewNode(5);
		root.left.left=a.createNewNode(3);
		root.left.right=a.createNewNode(4);
		root.right.right=a.createNewNode(6);
		Node ans=a.optimalApproach(root);
		a.preTraversal(ans);

	}

}
