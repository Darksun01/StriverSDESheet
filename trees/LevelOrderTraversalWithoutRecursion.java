package trees;
import java.util.*;
public class LevelOrderTraversalWithoutRecursion {
	private class Node{
		int data;
		Node right,left;
		public Node (int data)
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
	public void levelOrder(Node head)
	{
		if(head==null) return;
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(head);
		while(true)
		{
			int size=queue.size();
			if(size<=0)
			{
				break;
			}
			while(size>0)
			{
				Node node=queue.poll();
				System.out.print(node.data+" ");
				if(node.left!=null)
				{
					queue.add(node.left);
				}
				if(node.right!=null)
				{
					queue.add(node.right);
				}
				size--;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		LevelOrderTraversalWithoutRecursion a=new LevelOrderTraversalWithoutRecursion();
	    a.root = a.createNewNode(2);
	    a.root.left = a.createNewNode(7);
	    a.root.right = a.createNewNode(5);
	    a.root.left.left = a.createNewNode(2);
	    a.root.left.right = a.createNewNode(6);
	    a.root.left.right.left = a.createNewNode(5);
	    a.root.left.right.right = a.createNewNode(11);
	    a.root.right.right = a.createNewNode(9);
	    a.root.right.right.left = a.createNewNode(4);
	    a.levelOrder(a.root);


	}

}
