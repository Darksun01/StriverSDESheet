package trees;
import java.util.*;


public class CheckIfBinaryTreeIsHeightBalanced {
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
		return Math.max(height(node.left),height(node.right))+1;
	}
	public boolean ifHeightBalanced(Node node)
	{
		if(node==null) return true;
	    int leftSubtree=height(node.left);
	    int rightSubtree=height(node.right);
	    if(Math.abs(leftSubtree-rightSubtree)<=1 && ifHeightBalanced(node.left) && ifHeightBalanced(node.right))
	    {
	    	return true;
	    }
	    return false;
	}

	public static void main(String[] args) {
		CheckIfBinaryTreeIsHeightBalanced tree=new CheckIfBinaryTreeIsHeightBalanced();
		tree.root = tree.createNewNode(1);
        tree.root.left = tree.createNewNode(2);
        tree.root.right = tree.createNewNode(3);
        tree.root.left.left = tree.createNewNode(4);
        tree.root.left.right = tree.createNewNode(5);
        tree.root.left.left.left = tree.createNewNode(8);
        System.out.println(tree.ifHeightBalanced(tree.root));
	}

}
