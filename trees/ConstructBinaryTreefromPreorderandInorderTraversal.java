package trees;
import java.util.*;
public class ConstructBinaryTreefromPreorderandInorderTraversal {
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
	// O(n^2) && O(n)
	int preIndex=0;
	public Node bruteForce(int []preOrder,int []inOrder)
	{
		return bruteForceUtil(preOrder,inOrder,0,preOrder.length-1);
	}

	private Node bruteForceUtil(int[] preOrder, int[] inOrder, int start, int end) {
		if(start>end)
		{
			return null;
		}
		int data=preOrder[preIndex++];
		Node node=createNewNode(data);
		int i;
		for(i=start;i<=end;i++)
		{
			if(inOrder[i]==node.data)
			{
				break;
			}
		}
		node.left=bruteForceUtil(preOrder,inOrder,start,i-1);
		node.right=bruteForceUtil(preOrder,inOrder,i+1,end);
		return node;
	}
	//O(N) && O(n)
	int preIndex2=0;
	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	public Node optimalApproach(int []preOrder,int []inOrder)
	{
		for(int i=0;i<inOrder.length;i++)
		{
			map.put(inOrder[i], i);
		}
		return optimalApproachUtil(preOrder,inOrder,0,inOrder.length-1);
	}
	private Node optimalApproachUtil(int[] preOrder, int[] inOrder, int start, int end) {
		if(start>end)
		{
			return null;
		}
		int data=preOrder[preIndex2++];
		Node node=createNewNode(data);
		node.left=optimalApproachUtil(preOrder,inOrder,start,map.get(data)-1);
		node.right=optimalApproachUtil(preOrder,inOrder,map.get(data)+1,end);
		return node;
	}

	public static void main(String[] args) {
		ConstructBinaryTreefromPreorderandInorderTraversal a=new ConstructBinaryTreefromPreorderandInorderTraversal();
		  Node root = null;
		    int[] preorderArray = {2, 4, 7, 3, 8};
		    int[] inorderArray = {7, 4, 3, 2, 8};
		//    root=a.bruteForce(preorderArray, inorderArray);
		    root=a.optimalApproach(preorderArray, inorderArray);
		  
		    System.out.println(root.data+" ");

	}

}
