package trees;
import java.util.*;
public class BottomViewOfBinaryTree {
	private class Node{
		int data,hd;
		Node right,left;
		public Node(int data)
		{
			this.data=data;
			right=left=null;
			hd=0;
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
	public void bruteForce(Node node)
	{
		if(node==null) return;
		TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(node);
		while(!queue.isEmpty())
		{
			Node temp=queue.poll();
			map.put(temp.hd, temp.data);
			if(temp.left!=null)
			{
				temp.hd=temp.hd-1;
				queue.add(temp.left);
			}
			if(temp.right!=null)
			{
				temp.hd=temp.hd-1;
				queue.add(temp.right);
			}
		}
		System.out.println(map.values());
		
	}
	//O(n) O(n)
 	public ArrayList<Integer> optimalApproach(Node node)
	{
		ArrayList<Integer> arr = new ArrayList<Integer>();

		if(node == null)
		return arr;

		//tree map can be used to store keys in sorted order but in guess this will work too

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		HashMap<Integer,Integer> map = new HashMap<>();

		Queue<Node> q = new LinkedList<>();
		q.add(node); node.hd = 0;

		//level order traversal
		while( ! q .isEmpty() )
		{
		Node temp = q.poll();

		map.put(temp.hd , temp.data);

		min = Math.min( min , temp.hd);
		max = Math.max(max , temp.hd);

		if(temp.left != null)
		{
		temp.left.hd = temp.hd -1;
		q.add(temp.left);
		}

		if(temp.right != null)
		{
		temp.right.hd = temp.hd+1;
		q.add(temp.right);
		}

		}

		for(int i = min ; i <= max ; i++)
		{
		if(map.containsKey(i))
		arr.add(map.get(i));
		}

		return arr;
	}

	public static void main(String[] args) {
		BottomViewOfBinaryTree a=new BottomViewOfBinaryTree();
		Node root = a.createNewNode(2);
	    root.left = a.createNewNode(7);
	    root.right = a.createNewNode(5);
	    root.left.left = a.createNewNode(2);
	    root.left.right = a.createNewNode(6);
	    root.left.right.left = a.createNewNode(5);
	    root.left.right.right = a.createNewNode(11);
	    root.right.right = a.createNewNode(9);
	    root.right.right.left = a.createNewNode(4);
	    ArrayList<Integer> arr=new ArrayList<Integer>();
	    arr=a.optimalApproach(root);
//	    for(int i=0;i<arr.size();i++)
//	    {
//	    	System.out.print(arr.get(i)+" ");
//	    }
	    a.bruteForce(root);

	}

}
