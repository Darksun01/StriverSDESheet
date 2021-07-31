package trees;
import java.util.*;
public class VerticalOrder {
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
	public void printVerticalOrder(Node node)
	{
		if(node==null)  return;
		TreeMap<Integer,ArrayList<Integer>> map=new TreeMap<Integer,ArrayList<Integer>>();
		int hd=0;
		getVerticalOrder(node,map,hd);
		for(Map.Entry<Integer, ArrayList<Integer>> entry:map.entrySet())
		{
			System.out.println(entry.getValue());
		}
	}

	private void getVerticalOrder(Node node, TreeMap<Integer, ArrayList<Integer>> map, int hd) {
		if(node==null) return;
		if(map.get(hd)==null)
		{
			ArrayList<Integer> list=new ArrayList<Integer>();
			list.add(node.data);
			map.put(hd,list);
		}
		else
		{
			ArrayList<Integer> list=map.get(hd);
			list.add(node.data);
			map.put(hd, list);
		}
		getVerticalOrder(node.left,map,hd-1);
		getVerticalOrder(node.right,map,hd+1);
	}
	// optimal Approach
	private class Point{
		Node node;
		int x,y;
		public Point(Node node,int x,int y)
		{
			this.node=node;
			this.x=x;
			this.y=y;
		}
	}
	public List<List<Integer>> optimalApproach(Node node)
	{
		List<List<Integer>> res=new ArrayList<>();
		if(node==null) return res;
		Map<Integer,PriorityQueue<Point>> map=new HashMap<>();
		Queue<Point> queue=new LinkedList<Point>();
		Comparator<Point> comparator=(a,b)->{
			if(a.y==b.y)
			{
				return a.node.data=b.node.data;
			}
			else
			{
				return a.y-b.y;
			}
		};
		int max=0,min=0;
		while(!queue.isEmpty())
		{
			Point point=queue.poll();
			root=point.node;
			map.putIfAbsent(point.x, new PriorityQueue<>(comparator));
			map.get(point.x).add(point);
			max=Math.max(max,point.x);
			min=Math.min(min,point.x);
			if(node.left!=null)
			{
				queue.add(new Point(node,point.x-1,point.y+1));
			}
			if(node.right!=null)
			{
				queue.add(new Point(node,point.x+1,point.y+1));
			}
		}
		for(int i=min;i<=max;i++)
		{
			PriorityQueue<Point> pq=map.get(i);
			List<Integer> list=new ArrayList<Integer>();
			while(!pq.isEmpty()) {
			list.add(pq.poll().node.data);}
			res.add(list);
		}
		return res;
	}
	public static void main(String[] args) {
		VerticalOrder a=new VerticalOrder();
		a.root = a.createNewNode(2);
		a.root.left = a.createNewNode(7);
	    a.root.right = a.createNewNode(5);
	    a.root.left.left = a.createNewNode(2);
	    a.root.left.right = a.createNewNode(6);
	    a.root.left.right.left = a.createNewNode(5);
	    a.root.left.right.right = a.createNewNode(11);
	    a.root.right.right = a.createNewNode(9);
	    a.root.right.right.left = a.createNewNode(4);
	 //   a.printVerticalOrder(a.root);
	    a.optimalApproach(a.root);

	}

}
