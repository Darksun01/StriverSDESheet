package linkedList;
import java.util.*;
public class DetectACycle {
	private class Node{
		int data;
		Node next;
		public Node(int data)
		{
			this.data=data;
			next=null;
		}
	}
	private Node head=null;
	private Node tail=null;
	public void addToLast(int data)
	{
		Node newNode=new Node(data);
		if(head==null)
		{
			head=newNode;
			tail=newNode;
		}
		else
		{
			tail.next=newNode;
			tail=newNode;
		}
	}
	public boolean bruteForce(Node head)
	{
		if(head==null) return false;
		Set<Node> set=new HashSet<Node>();
		while(head!=null)
		{
			if(set.contains(head))
			{
				return true;
			}
			set.add(head);
			head=head.next;
		}
		return false;
	}
	public boolean optimalApproach(Node head)
	{
		if(head==null) return false;
		Node fast=head,slow=head;
		while(fast.next!=null && fast.next.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(fast==slow)
			{
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		DetectACycle a=new DetectACycle();
		a.addToLast(1);
		a.addToLast(2);
		a.addToLast(3);
		a.addToLast(4);
		a.addToLast(5);
		a.tail.next=a.head.next.next;
	//	System.out.println(a.bruteForce(a.head));\
		System.out.println(a.optimalApproach(a.head));

	}

}
