package trees;
import java.util.*;

//import trees.BottomViewOfBinaryTree.Node;
public class TopViewOfBinaryTree {
	private class Node{
		int data,height;
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
	public void bruteForce(Node node)
	{
		if(node==null) return;
		TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(node);
		while(!queue.isEmpty())
		{
			Node temp=queue.poll();
			int hd=temp.height;
			if(map.get(hd)==null) {
			map.put(hd, temp.data);}
			if(temp.left!=null)
			{
				temp.left.height=hd-1;
				queue.add(temp.left);
			}
			if(temp.right!=null)
			{
				temp.right.height=hd+1;
				queue.add(temp.right);
			}
		}
		System.out.println(map.values());
	}
	public void optimalApproach(Node node)
	{
		if(node==null)return;
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(node);
		int max=0,min=0;
		while(!queue.isEmpty())
		{
			Node temp=queue.poll();
			int hd=temp.height;
			if(!map.containsKey(hd))
			{
				map.put(hd, temp.data);
				max=Math.max(max, hd);
				min=Math.min(min, hd);
			}
			if(temp.left!=null)
			{
				temp.left.height=hd-1;
				queue.add(temp.left);
			}
			if(temp.right!=null)
			{
				temp.right.height=hd+1;
				queue.add(temp.right);
			}
		}
		for(int i=min;i<=max;i++)
		{
			System.out.print(map.get(i)+" ");
		}
	}
	public static void main(String[] args) {
		TopViewOfBinaryTree a=new TopViewOfBinaryTree();
		Node root = a.createNewNode(2);
	    root.left = a.createNewNode(7);
	    root.right = a.createNewNode(5);
	    root.left.left = a.createNewNode(2);
	    root.left.right = a.createNewNode(6);
	    root.left.right.left = a.createNewNode(5);
	    root.left.right.right = a.createNewNode(11);
	    root.right.right = a.createNewNode(9);
	    root.right.right.left = a.createNewNode(4);
	   // a.bruteForce(root);
	    a.optimalApproach(root);

	}

}
