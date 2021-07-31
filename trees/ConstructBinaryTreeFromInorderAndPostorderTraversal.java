package trees;
import java.util.*;
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	private class Node {
		int data;
		Node right,left;
		public Node(int dta)
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
	public void inorderTraversal(Node node)
	{
		if(node==null) return;
		inorderTraversal(node.left);
		System.out.print(node.data+" ");
		System.out.println(node.right+" ");
	}
	// O(n^2);
	int postIndex;
	public Node buildTree(int []inorder,int []postorder)
	{
		postIndex=postorder.length-1;
		return buildTreeUtil(inorder,postorder,0,inorder.length-1);
	}

	private Node buildTreeUtil(int[] inorder, int[] postorder, int start, int end) {
		 if(start>end)
	        {
	            return null;
	        }
	        Node node=new Node(postorder[postIndex--]);
	         if(start==end)
	         {
	             return node;
	         }
	        int i;
	        for(i=start;i<=end;i++)
	        {
	            if(inorder[i]==node.data)
	            {
	                break;
	            }
	        }
	        node.left=buildTreeUtil(inorder,postorder,start,i-1);
	        node.right=buildTreeUtil(inorder,postorder,i+1,end);
	        
	        return node;
	}
	//O(n)
	 int postRootIndex;
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	    public Node buildTree1(int[] inorder, int[] postorder) {
	         postRootIndex=postorder.length-1;
			postRootIndex=postorder.length-1;
	        for(int i=0;i<inorder.length;i++)
	        {
	            map.put(inorder[i],i);
	        }
	        return buildTreeUtil(inorder,postorder,0,inorder.length-1);

	    }
	    public Node buildTreeUtil1(int []inorder,int []postorder,int start,int end)
	    {
	      if(start > end)
	            return null;
	        
	        Node root = new Node(postorder[postRootIndex--]);
	        
	        if(start == end)
	            return root;
	        
	        int inRootIndex = map.get(root.data);
	        
	        root.right = buildTreeUtil(inorder, postorder, inRootIndex + 1, end);
	        root.left = buildTreeUtil(inorder, postorder, start, inRootIndex - 1);
	        
	        return root;
	    }
	public static void main(String[] args) {
		ConstructBinaryTreeFromInorderAndPostorderTraversal a=new ConstructBinaryTreeFromInorderAndPostorderTraversal();
		int[] preorderArray = {9,15,7,20,3};
	    int[] inorderArray = {9,3,15,20,7};
	    Node ans=a.buildTree(inorderArray, preorderArray);
	   // a.inorderTraversal(ans);
	    Node ans1=a.buildTree1(preorderArray, inorderArray);
	    System.out.println(ans1.data);

	}

}
