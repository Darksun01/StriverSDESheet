package trees;
import java.util.*;
public class LevelOrderTraversalRecursion {
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
	public void levelOrderTraversalUsingRecursion(Node node) {
	    if (node == null) {
	      return;
	    }
	    
	    int height = getHeightOfTree(node);
	    
	    for(int i = 0; i <= height; i++) {
	      printAtGivenLevel(node, i + 1);
	      System.out.println();
	    }
	  }
	  
	  public int getHeightOfTree(Node node) {
	    if(node == null){
	      return -1;
	    }
	    
	    return Math.max(getHeightOfTree(node.left), getHeightOfTree(node.right)) + 1;
	  }
	  
	  public void printAtGivenLevel(Node node, int level) {
	    if(node == null) {
	      return;
	    }
	    
	    if(level == 1) {
	      System.out.print(node.data + " ");
	      return;
	    }
	    
	    printAtGivenLevel(node.left, level - 1);
	    printAtGivenLevel(node.right, level - 1);
	  }

	  public Node createNewNode(int val) {
	    Node newNode = new Node(val);
	    newNode.data = val;
	    newNode.left = null;
	    newNode.right = null;
	    return newNode;
	  }
	
	public static void main(String[] args) {
		LevelOrderTraversalRecursion a=new LevelOrderTraversalRecursion();
		a.root = a.createNewNode(2);
	    a.root.left = a.createNewNode(7);
	    a.root.right = a.createNewNode(5);
	    a.root.left.left = a.createNewNode(2);
	    a.root.left.right = a.createNewNode(6);
	    a.root.left.right.left = a.createNewNode(5);
	    a.root.left.right.right = a.createNewNode(11);
	    a.root.right.right = a.createNewNode(9);
	    a.root.right.right.left = a.createNewNode(4);
	    a.levelOrderTraversalUsingRecursion(a.root);
	}

}
