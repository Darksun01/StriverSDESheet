package trees;
import java.util.*;
public class LevelOrderSpiralFormRecursion {
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
	public int height(Node node)
	{
		if(node==null) return -1;
		return Math.max(height(node.right), height(node.left))+1;
	}
	public void printSpiral(Node head)
	{
		if(head==null) return;
		boolean flag=false;
		for(int i=0;i<=height(head);i++)
		{
			printSpiralUtil(head,i+1,flag);
			System.out.println();
			 flag=!flag;
		}
	}

	private void printSpiralUtil(Node head, int i,boolean flag) {
		if(head==null) return;
		if(i==1)
		{
			System.out.print(head.data+" ");
		}
		if(flag)
		{
			printSpiralUtil(head.left,i-1,flag);
			printSpiralUtil(head.right,i-1,flag);
		}
		else
		{
			printSpiralUtil(head.right,i-1,flag);
			printSpiralUtil(head.left,i-1,flag);
		}
		
	}
	public static void main(String[] args) {
		LevelOrderSpiralFormRecursion tree=new LevelOrderSpiralFormRecursion();
		tree.root = tree.createNewNode(1);
        tree.root.left = tree.createNewNode(2);
        tree.root.right = tree.createNewNode(3);
        tree.root.left.left = tree.createNewNode(7);
        tree.root.left.right = tree.createNewNode(6);
        tree.root.right.left = tree.createNewNode(5);
        tree.root.right.right = tree.createNewNode(4);
        tree.printSpiral(tree.root);

	}

}
