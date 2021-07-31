package trees;
import java.util.*;
public class DiameterOfABinaryTree {
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
		newNode.right=null;
		newNode.left=null;
		return newNode;
	}
	//O(n^2)
	public int height(Node node)
	{
		if(node==null) return -1;
		return Math.max(height(node.left),height(node.right))+1;
	}
	public int bruteForce(Node node)
	{
		if(node==null) return 0;
		int ld=bruteForce(node.left);
		int rd=bruteForce(node.right);
		int dia=height(node.left)+height(node.right)+2;
		return Math.max(dia, Math.max(ld, rd));
	}
	//O(n)
	private class diaPair{
		int ht;
		int dia;
	}
	public int optimalApproach(Node node)
	{
		if(node==null) return -1;
		diaPair res=optimalApproachUtil(node);
		return res.dia;
	}

	private diaPair optimalApproachUtil(Node node) {
		if(node==null)
		{
			diaPair basePair=new diaPair();
			basePair.ht=-1;
			basePair.dia=0;
			return basePair;
		}
		diaPair ld=optimalApproachUtil(node.left);
		diaPair rd=optimalApproachUtil(node.right);
		diaPair mp=new diaPair();
		mp.ht=Math.max(ld.ht, rd.ht)+1;
		int fes=ld.ht+rd.ht+2;
		mp.dia=Math.max(fes, Math.max(ld.dia, rd.dia));
		return mp;
	}
	public static void main(String[] args) {
		DiameterOfABinaryTree a=new DiameterOfABinaryTree();
		Node root = a.createNewNode(2);
	    root.left = a.createNewNode(7);
	    root.right = a.createNewNode(5);
	    root.left.left = a.createNewNode(2);
	    root.left.right = a.createNewNode(6);
	    root.left.right.left = a.createNewNode(5);
	    root.left.right.right = a.createNewNode(11);
	    root.right.right = a.createNewNode(9);
	    root.right.right.left = a.createNewNode(4);
	    System.out.println(a.bruteForce(root));
	    System.out.println(a.optimalApproach(root));

	}

}
