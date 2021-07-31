package trees;
import java.util.*;
public class RightViewBianaryTree {
	private class Node{
		int data;
		Node right,left;
		public Node(int data)
		{
			this.data=data;
			right=left=null;
		}
	}
	private Node root;
	public Node add(int data)
	{
		Node newNode=new Node(data);
		newNode.data=data;
		newNode.left=null;
		newNode.right=null;
		return newNode;
	}
	int maxLevel=0;
	public void rightView(Node node,int level)
	{
		if(node==null) return ;
		if(maxLevel<=level)
		{
			System.out.print(node.data+" ");
			maxLevel++;
		}
		rightView(node.right,level+1);
		rightView(node.left,level+1);
	}

	public static void main(String[] args) {
		RightViewBianaryTree a=new RightViewBianaryTree();
		a.root=a.add(1);
		a.root.left=a.add(2);
		a.root.right=a.add(3);
		a.root.right.left=a.add(4);
		a.root.right.right=a.add(5);
		a.root.right.left.right=a.add(6);
		a.rightView(a.root, 0);

	}

}
