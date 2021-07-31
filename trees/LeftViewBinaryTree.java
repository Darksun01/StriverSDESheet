package trees;
import java.util.*;
public class LeftViewBinaryTree {
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
	public Node add(int data)
	{
		Node newNode=new Node(data);
		newNode.data=data;
		newNode.left=null;
		newNode.right=null;
		return newNode;
	}
	public int size()
	{
		return size(root);
	}
	private int size(Node root2) {
		if(root2==null) return 0;
		return size(root2.left)+1+size(root2.right);
	}
	int maxLevel=0;
	public void leftView(Node head,int level)
	{
		if(head==null) return;
		if(maxLevel<=level)
		{
			System.out.print(head.data+" ");
			maxLevel++;
		}
		leftView(head.left,level+1);
		leftView(head.right,level+1);	
	}

	public static void main(String[] args) {
		LeftViewBinaryTree a=new LeftViewBinaryTree();
		a.root=a.add(1);
		a.root.left=a.add(2);
		a.root.right=a.add(3);
		a.root.right.left=a.add(4);
		a.root.right.right=a.add(5);
		a.root.right.left.right=a.add(6);
		System.out.println(a.size());
		boolean []arr=new boolean[a.size()];
		a.leftView(a.root,0);
		

	}

}
